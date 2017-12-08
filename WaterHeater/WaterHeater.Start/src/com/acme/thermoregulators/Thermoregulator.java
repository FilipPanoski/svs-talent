package com.acme.thermoregulators;

import com.acme.adapters.VentoElectricsAdapter;

public interface Thermoregulator extends VentoElectricsAdapter{

    void setTemperature(Integer temperature);
}
