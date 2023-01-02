
int relay_pin = 8;
void setup() {
  pinMode(relay_pin, OUTPUT);
}
void loop() {
  digitalWrite(relay_pin, HIGH);
  delay(5000);
  digitalWrite(relay_pin, LOW);
  delay(5000);
}
