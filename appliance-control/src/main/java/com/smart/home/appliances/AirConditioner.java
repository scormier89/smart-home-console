package com.smart.home.appliances;

import com.smart.home.Appliance;

public class AirConditioner implements Appliance {
    private boolean isOn = false;
    private int temperature = 24;
    private ThermostatMode mode = ThermostatMode.OFF;

    @Override
    public void turnOn() {
        isOn = true;
        mode = ThermostatMode.COOL;
        System.out.println("Air conditioner is turned on in " + mode + " mode.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        mode = ThermostatMode.OFF;
        System.out.println("Air conditioner is turned off.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setTemperature(int temperature) {
        if (isOn) {
            this.temperature = temperature;
            System.out.println("Air conditioner temperature is set to " + temperature + "°C.");
        } else {
            System.out.println("Air conditioner is off. Please turn it on first.");
        }
    }

    public void setMode(ThermostatMode mode) {
        if (isOn) {
            this.mode = mode;
            System.out.println("Air conditioner mode is set to " + mode + ".");
        } else {
            System.out.println("Air conditioner is off. Please turn it on first.");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public ThermostatMode getMode() {
        return mode;
    }
    public boolean isCooling() {
        return mode == ThermostatMode.COOL;
    }
    public boolean isHeating() {
        return mode == ThermostatMode.HEAT;
    }
}
