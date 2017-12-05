package es;

import es.fan.Fan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import es.powerbutton.PoweredDevice;

@Component
@Profile("es/fan")
public class PowerButtonFanAdapter implements PoweredDevice {
    private Fan fan;

    @Autowired
    public PowerButtonFanAdapter(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void enable() {
        fan.turnOn();
    }

    @Override
    public void disable() {
        fan.turnOff();
    }
}
