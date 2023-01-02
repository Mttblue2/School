int led_pin = 3;
void setup() {
  pinMode(led_pin, OUTPUT);
  analogWrite(led_pin, LOW);
}
void loop() {
  analogWrite(led_pin, 0);
  delay(1000);
  analogWrite(led_pin, 127);
  delay(1000);
  analogWrite(led_pin, 255);
  delay(1000);
}
