#include <ZumoMotors.h>
#include <Pushbutton.h>
#include <QTRSensors.h>
#include <ZumoReflectanceSensorArray.h>

// Setup pins
#define LED               13
#define TRIGGER_PIN       6
#define ECHO_PIN          A1
 
// Light sensitivity
#define QTR_THRESHOLD     1800

// Speeds
#define TURN_SPEED        200
#define FORWARD_SPEED     300
#define MAX_SPEED         400
#define TURN_DURATION     50

 
ZumoMotors motors;
Pushbutton button(ZUMO_BUTTON); // pushbutton on pin 12
 
#define NUM_SENSORS 6
unsigned int sensor_values[NUM_SENSORS];
 
ZumoReflectanceSensorArray sensors;

void setup() {
  Serial.begin(9600);

  sensors.init();
  pinMode(TRIGGER_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);

  button.waitForButton();
  delay(1000);
  motors.setSpeeds(MAX_SPEED, -MAX_SPEED);
  delay(205);
  motors.setSpeeds(0,0);
}

void loop() {
  // Start scanning
  scanner(35);

  motors.setSpeeds(400, 400);

  // Charge when stopped scanning
  charge();

  // Dodge lines
  sensors.read(sensor_values);
  line_sensing();
}

///////////////////////////
//    S C A N N I N G    //
///////////////////////////
void scanner(float distance) {
  motors.setSpeeds(300, 20);
  
  while (echo() > distance) {
    sensors.read(sensor_values);
    line_sensing();
  }
}

//////////////////////////////
//     P R O X I M I T Y    //
/////////////////////////////
float echo() {
  digitalWrite(TRIGGER_PIN, LOW);
  delayMicroseconds(2);

  digitalWrite(TRIGGER_PIN, HIGH);
  delayMicroseconds(10);

  digitalWrite(TRIGGER_PIN, LOW);
  long dur = pulseIn(ECHO_PIN, HIGH);
  
  return dur * 0.01;
}

// If something is in sight, charge
void charge() {
  if (echo() < 35) {
    motors.setSpeeds(400, 400);
  }
}

////////////////////////////////////
//     L I N E  S E N S I N G     //
////////////////////////////////////
void line_sensing() {
  // Left edge
  if (sensor_values[0] < QTR_THRESHOLD) {
    // Back up
    motors.setSpeeds(-100, -100);
    delay(120);

    // Turn around
    motors.setSpeeds(220, -220);
    delay(500);

    // Towards middle of stage
    motors.setSpeeds(FORWARD_SPEED, FORWARD_SPEED);
    delay(400);
  }

  else if (sensor_values[5] < QTR_THRESHOLD) {
    // Back up a bit
    motors.setSpeeds(-100, -100);
    delay(120);

    // Spin to the left
    motors.setSpeeds(-220, 220);
    delay(500);

    // Towards the middle
    motors.setSpeeds(FORWARD_SPEED, FORWARD_SPEED);
    delay(400);
  }
}
