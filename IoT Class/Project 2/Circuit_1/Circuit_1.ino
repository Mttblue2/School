const int led_pin = 9;
const int ldr_pin = A0;

void setup() {

  Serial.begin(9600);
  pinMode(led_pin, OUTPUT);
  pinMode(ldr_pin, INPUT);

}

void loop() {

  int ldr_reading = analogRead(ldr_pin);
  Serial.println(ldr_reading);
  if (ldr_reading <= 900)
  {
    digitalWrite(led_pin, HIGH);
  }
  else
  {
    digitalWrite(led_pin,LOW);
  }
}
