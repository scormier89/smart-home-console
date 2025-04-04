package com.smart.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.smart.home.Appliance;

public class SmartHomeController {
    private List<Appliance> appliances = new ArrayList<>();

    public void registerAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void shutdownAllForUpdate() {
        System.out.println("Performing annual update...");
        for (Appliance appliance : appliances) {
            appliance.turnOff();
        }
    }

    public void turnOnAllAppliances() {
        for (Appliance appliance : appliances) {
            appliance.turnOn();
        }
    }

    public void scheduleAnnualUpdate() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            LocalDateTime now = LocalDateTime.now();
            if (now.getMonth() == Month.JANUARY && now.getDayOfMonth() == 1 &&
                now.getHour() == 1 && now.getMinute() == 0) {

                shutdownAllForUpdate();
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }
}
