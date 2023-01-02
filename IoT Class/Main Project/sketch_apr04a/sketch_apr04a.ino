#include <ArduinoBLE.h>
BLEService PowerSwitch("1101");
BLEUnsignedCharCharacteristic PowerSwitchInt("2101", BLERead | BLEWrite);
const int relay_pin = 8;

void setup() {
  Serial.begin(9600);

  pinMode(relay_pin, OUTPUT);

  if (!BLE.begin())
  {
    Serial.println("starting BLE failed!");
    while (1);
  }

  BLE.setLocalName("PowerSwitch");
  BLE.setAdvertisedService(PowerSwitch);
  PowerSwitch.addCharacteristic(PowerSwitchInt);
  BLE.addService(PowerSwitch);

  BLE.advertise();
  Serial.println("Bluetooth device active, waiting for connections...");
}

void loop()
{
  BLEDevice central = BLE.central();

  if (central)
  {
    Serial.print("Connected to central: ");
    Serial.println(central.address());

    while (central.connected()) {
      int PSV = PowerSwitchInt.value();
      if (PSV == 49)
      { 
        Serial.println("LED on");
        digitalWrite(relay_pin, HIGH);        // will turn the LED on
      }
      else
      { 
        Serial.println("LED off");
        digitalWrite(relay_pin, LOW);         // will turn the LED off
      }

    }
  }
  Serial.print("Disconnected from central: ");
  Serial.println(central.address());
}
