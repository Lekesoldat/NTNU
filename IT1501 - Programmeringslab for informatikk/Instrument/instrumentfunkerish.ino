// Echo
const int echoPin = 3;
const int triggerPin = 4;

// Buzzer
const int speakerOut = 11;


// Button
const int button = 12;

// Touch Sensor
const int touchIn = 7;

void setup() {
  // Echo
  pinMode(triggerPin, OUTPUT);
  pinMode(echoPin, INPUT);

  // Buzzer
  pinMode(speakerOut, OUTPUT);

  // Button
  pinMode(button, INPUT);

  // Touch Sensor
  pinMode(touchIn, INPUT);
  
  Serial.begin(9600);
}

void loop() {
  if (digitalRead(touchIn) != 0) {
    long cm = calculateCm(echo());
    if (cm <= 100 && digitalRead(button) != 1) {
      tone(speakerOut, cm * 200);
    } else {
      tone(speakerOut, cm * 500);
    }
  } else {
    noTone(speakerOut);
  }
}

int echo() {
  // The echoing
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(5);
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);

  return pulseIn(echoPin, HIGH);
}

int calculateCm(int duration) {
  return (duration/2) / 29.1;
}
