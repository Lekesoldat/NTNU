#include <Servo.h>

Servo myServo;

const int carRed = 6;
const int carYellow = 5;
const int carGreen = 4;

const int humanRed = 2;
const int humanGreen = 3;
const int button = 8;

void setup() {
  pinMode(carRed, OUTPUT);
  pinMode(carYellow, OUTPUT);
  pinMode(carGreen, OUTPUT);
  pinMode(humanRed, OUTPUT);
  pinMode(humanGreen, OUTPUT);
  pinMode(button, INPUT);

  // State 3
  digitalWrite(carGreen, HIGH);
  digitalWrite(humanRed, HIGH);

  // Servo-setup
  myServo.attach(0);
  myServo.write(0);
}

void loop() {
  // If the button is clicked
  if (digitalRead(button) == 0) {
    // Click button, wait one second

    traverse();
  }
}

void traverse() {
  // Initial wait
  delay(1000);

  // Yellow for cars
  stateFour();

  // Wait 1s on yellow
  delay(1000);

  // Red for cars
  stateOne();

  // Wait 2s for ped-green
  delay(2000);
  pedWalk();

  // Ped walk 5s
  delay(5000);

  pedStop();

  // Reset after 2s
  delay(2000);
  stateTwo();

  delay(1000);
  stateThree();
}

void stateFour() {
  digitalWrite(carGreen, LOW);
  digitalWrite(carYellow, HIGH);
}

void stateTwo() {
  digitalWrite(carYellow, HIGH);
}

void stateThree() {
  digitalWrite(carGreen, HIGH);
  digitalWrite(carYellow, LOW);
  digitalWrite(carRed, LOW);
}

void stateOne() {
  digitalWrite(carYellow, LOW);
  digitalWrite(carRed, HIGH);
}

void pedWalk() {
  digitalWrite(humanRed, LOW);
  digitalWrite(humanGreen, HIGH);
  myServo.write(90);
}

void pedStop() {
  digitalWrite(humanGreen, LOW);
  digitalWrite(humanRed, HIGH);
  myServo.write(0);
}
