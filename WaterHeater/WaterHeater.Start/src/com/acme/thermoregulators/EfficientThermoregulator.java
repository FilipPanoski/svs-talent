package com.acme.thermoregulators;

import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.thermometer.Thermometer;
import java.util.concurrent.TimeUnit;

public class EfficientThermoregulator {

    private Heater heater;
    private Thermometer thermometer;

    private boolean powerEnabled = false;

    public EfficientThermoregulator(Heater heater, Thermometer thermometer){
        this.heater = heater;
        this.thermometer = thermometer;
    }

    public void startRegulatingTemperature(Integer temperature){
        Thread threadThatStartsRegulatingTemperature = new Thread(new Runnable() {
            @Override
            public void run() {
                while (powerEnabled) {
                    if (thermometer.getTemperature() < temperature){
                        heater.startHeating();
                    } else if (thermometer.getTemperature() > temperature){
                        heater.stopHeating();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch(InterruptedException ie){}
                }
            }
        });

        threadThatStartsRegulatingTemperature.start();
    }

    public void setPowerEnabled(boolean powerEnabled){
        this.powerEnabled = powerEnabled;
    }
}