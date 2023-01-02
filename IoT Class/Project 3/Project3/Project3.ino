#include <DHT.h>
#include <DHT_U.h>

DHT dht(7, DHT11);

void setup(){
  Serial.begin(9600);
  dht.begin();
}

void loop()
{
  Serial.print("Temperature = ");
  Serial.print(dht.readTemperature());
  Serial.println(" C");
  delay(1000);
}
