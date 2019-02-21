#include <LiquidCrystal_I2C.h>

// LCD
LiquidCrystal_I2C lcd(0x27,16,2);

// Buzzers
const int buzzerOne = 8;
const int buzzerTwo = 9;

// Button
const int button = 2;

// Touch
const int touch = 6;

boolean counting = false;

void setup() {
  // Buzzers
  pinMode(buzzerOne, OUTPUT);
  pinMode(buzzerTwo, OUTPUT);

  // Button
  pinMode(button, INPUT);

  // Touch
  pinMode(touch, INPUT);

  // LCD
  lcd.init();
  lcd.backlight();
  
  Serial.begin(9600);
  resetTimer();
}

void loop() {
  // Start the countdown
  if (digitalRead(button) == 0 && counting == false) {
    startTimer();
  }

}

void startTimer() {
  lcd.clear();
  counting = true;
  
  // Start counting
  for (int i = 720; i >= 0; i--) {
    int ss = i % 60;
    int mm = i / 60;
    lcd.print("Grandis i ovnen!");

    lcd.setCursor(0, 1);

    // Format string
    char output[13];
    sprintf(output, "%02d:%02d igjen!", mm, ss);
    lcd.print(output);
    
    delay(1000);
    lcd.clear();
  }

  // Done
  counting = false;
  buzz();
}

void resetTimer() {
  noBuzz();
  lcd.clear();
  lcd.print("Stek grandis!");
  lcd.setCursor(0, 1);
  lcd.print("12:00 igjen!");
}

void buzz() {
  while (true) {
    // Reset
    if (digitalRead(touch) == 1 && counting == false) {
      resetTimer();
      break;
     }
    
    lcd.print("PIZZATIME!");
    
    tone(buzzerOne, 3000);
    delay(500);
    noTone(buzzerOne);

    tone(buzzerTwo, 1000);
    delay(500);
    noTone(buzzerTwo);


    lcd.clear();
  } 
}

void noBuzz() {
  noTone(buzzerOne);
  noTone(buzzerTwo);
}
