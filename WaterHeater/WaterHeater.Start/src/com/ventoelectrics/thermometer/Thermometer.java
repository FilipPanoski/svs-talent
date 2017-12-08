package com.ventoelectrics.thermometer;

import com.ventoelectrics.powereddevice.exceptions.NoPowerException;
import com.ventoelectrics.powereddevice.PoweredDevice;

import java.util.Random;

public class Thermometer implements PoweredDevice {
	
	private boolean powerEnabled = false;

	private Random random = new Random(System.currentTimeMillis());

	public Integer getTemperature() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		return random.nextInt(60);
	}

	@Override
	public void enablePower() {
		powerEnabled = true;
	}

	@Override
	public void disablePower() {
		powerEnabled = false;
	}
}
