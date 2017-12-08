package com.acme.thermoregulators.forventoelectrics;

import com.acme.thermoregulators.EfficientThermoregulator;
import com.acme.thermoregulators.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.thermometer.Thermometer;

public class VentoElectricsEfficientAdapter implements Thermoregulator {

    private EfficientThermoregulator efficientThermoregulator;
    private Heater heater;
    private Thermometer thermometer;

    public VentoElectricsEfficientAdapter(Heater heater, Thermometer thermometer){
        this.heater = heater;
        this.thermometer = thermometer;
        efficientThermoregulator = new EfficientThermoregulator(heater, thermometer);
    }

    @Override
    public void setTemperature(Integer temperature) {
        efficientThermoregulator.startRegulatingTemperature(temperature);
    }

    @Override
    public void enablePower() {
        efficientThermoregulator.setPowerEnabled(true);
    }

    @Override
    public void disablePower() {
        efficientThermoregulator.setPowerEnabled(false);
    }
}
