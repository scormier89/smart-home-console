package com.smart.home.appliances;

import com.smart.home.Appliance;

public class Fan implements Appliance {
    private boolean isOn = false;
    private int speed = 0;
    
    @Override
    public void turnOn() {
        isOn = true;
        speed = 1;
        System.out.println("Fan is turned on at low speed.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        speed = 0;
        System.out.println("Fan is turned off.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setSpeed(int speed) {
        if (speed == 0) {
            turnOff();
        } else if (speed == 1 || speed == 2) {
            this.speed = speed;
            isOn = true;
            System.out.println("Fan is set to " + (speed == 1 ? "low" : "high") + " speed.");
        } else {
            System.out.println("Invalid speed setting. Fan remains at current speed.");
        }        
    }

    public int getSpeed() {
        return speed;
    }
    
}
