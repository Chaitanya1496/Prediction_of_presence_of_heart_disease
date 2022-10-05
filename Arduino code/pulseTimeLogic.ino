int UpperThreshold = 340;
    int reading = 0;
    float BPM = 0.0;
    int value=0;
    bool IgnoreReading = false;
    bool FirstPulseDetected = false;
    unsigned long FirstPulseTime = 0;
    unsigned long SecondPulseTime = 0;
    unsigned long PulseInterval = 0;
    bool skip=false;

    void setup(){
      Serial.begin(9600);
    }

    void loop(){
        reading = analogRead(A0); 
      /*  if(reading>value)
        {
          skip==true;
        }
        else{
          skip==false;
        }
        */
      // Heart beat leading edge detected.
      if(reading > UpperThreshold ){
        value=reading;
        if(FirstPulseDetected == false){
          FirstPulseTime = millis();
          FirstPulseDetected = true;
        }
        else{
          SecondPulseTime = millis();
          PulseInterval = SecondPulseTime - FirstPulseTime;
          FirstPulseTime = SecondPulseTime;
        }
      BPM = (1.0/PulseInterval) * 60.0 * 1000;
     if(BPM<200){

        Serial.print('#');
            //for loop cycles through 4 sensors and sends values via serial
        for(int k=0; k<4; k++)
        {
         Serial.print(BPM);
          Serial.print('+');
    //technically not needed but I prefer to break up data values
    //so they are easier to see when debugging
        }
        
         Serial.print('~'); //used as an end of transmission character - used in app for string length
        Serial.println();
       delay(10);        //added a delay to eliminate missed transmissions
      }  
    }
    }
        
        
      
