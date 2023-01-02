const int trig_pin = 3;
const int echo_pin = 7;

float pulse_duration, distance;

void setup() {
  pinMode(trig_pin, OUTPUT);
  pinMode(echo_pin, INPUT);
  Serial.begin(9600);
}

void loop() {
  digitalWrite(trig_pin, LOW);
  delayMicroseconds(2);
  digitalWrite(trig_pin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trig_pin, LOW);

  pulse_duration = pulseIn(echo_pin, HIGH);
  distance = pulse_duration * .017150;
  Serial.print("Distance: ");
  Serial.println(distance);
  delay(100);
}
