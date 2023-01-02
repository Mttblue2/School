int led_pin = 8;
int switch_pin = 3;

void setup() {
  pinMode(led_pin, OUTPUT);
  pinMode(switch_pin, INPUT);
}
void loop() {
  int button = digitalRead(switch_pin);
  if (button == 1){
    if (digitalRead(led_pin) == HIGH){
      digitalWrite(led_pin,LOW);
    }
    else if (digitalRead(led_pin) == LOW) {
      digitalWrite(led_pin,HIGH);
    }
  }
}
