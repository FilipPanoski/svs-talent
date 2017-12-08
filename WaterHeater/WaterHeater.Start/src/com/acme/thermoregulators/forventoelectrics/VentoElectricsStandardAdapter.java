package com.acme.thermoregulators.forventoelectrics;

import com.acme.thermoregulators.StandardThermoregulator;
import com.acme.thermoregulators.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.thermometer.Thermometer;

public class VentoElectricsStandardAdapter implements Thermoregulator {

    private StandardThermoregulator standardThermoregulator;
    private Heater heater;
    private Thermometer thermometer;

    public VentoElectricsStandardAdapter(Heater heater, Thermometer thermometer){
        this.heater = heater;
        this.thermometer = thermometer;
        standardThermoregulator = new StandardThermoregulator(heater, thermometer);
    }

    @Override
    public void setTemperature(Integer temperature) {
        standardThermoregulator.startRegulatingTemperature(temperature);
    }

    @Override
    public void enablePower() {
        standardThermoregulator.setPowerEnabled(true);
    }

    @Override
    public void disablePower() {
        standardThermoregulator.setPowerEnabled(false);
    }
}
