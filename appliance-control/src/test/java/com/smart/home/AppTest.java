package com.smart.home;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.smart.home.appliances.*;

import com.smart.home.controller.SmartHomeController;


public class AppTest 
{

    @Test
    public void testAirConditioner() {
        AirConditioner ac = new AirConditioner();
        ac.turnOn();
        ac.setTemperature(22);
        ac.setMode(ThermostatMode.COOL);
        assertTrue(ac.isOn());
        assertEquals(22, ac.getTemperature());
        assertTrue(ac.getMode() == ThermostatMode.COOL);
        ac.turnOff();
    }

    @Test
    public void testLight() {
        Light light = new Light();
        light.turnOn();
        assertTrue(light.isOn());
        light.turnOff();
        assertTrue(!light.isOn());
    }

    @Test
    public void testThermostatMode() {
        ThermostatMode mode = ThermostatMode.COOL;
        assertTrue(mode == ThermostatMode.COOL);
        mode = ThermostatMode.HEAT;
        assertTrue(mode == ThermostatMode.HEAT);
        mode = ThermostatMode.OFF;
        assertTrue(mode == ThermostatMode.OFF);
    }

    @Test
    public void testAppliance() {
        Appliance appliance = new Appliance() {
            private boolean isOn = false;
            @Override
            public void turnOn() {
                isOn = true;
            }
            @Override
            public void turnOff() {
                isOn = false;
            }
            @Override
            public boolean isOn() {
                return isOn;
            }
        };
        appliance.turnOn();
        assertTrue(appliance.isOn());
        appliance.turnOff();
        assertTrue(!appliance.isOn());
    }

    @Test
    public void testFan() {
        Fan fan = new Fan();
        fan.turnOn();
        fan.setSpeed(2);
        assertTrue(fan.isOn());
        assertEquals(2, fan.getSpeed());


        fan.setSpeed(0);
        assertTrue(!fan.isOn());

        fan.setSpeed(1);
        assertTrue(fan.isOn());
        assertEquals(1, fan.getSpeed());

        fan.turnOff();
        assertTrue(!fan.isOn());
    }

    @Test
    public void testSmartHomeController() {
        SmartHomeController controller = new SmartHomeController();
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();
        
        controller.registerAppliance(light);
        controller.registerAppliance(fan);
        controller.registerAppliance(ac);
        
        assertEquals(3, controller.getAppliances().size());
        
        controller.scheduleAnnualUpdate();
        
        assertTrue(!light.isOn());
        assertTrue(!fan.isOn());
        assertTrue(!ac.isOn());

        controller.turnOnAllAppliances();

        assertTrue(light.isOn());
        assertTrue(fan.isOn());
        assertTrue(ac.isOn());

    }

}
