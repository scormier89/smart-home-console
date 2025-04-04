package com.smart.home;

import com.smart.home.appliances.*;
import com.smart.home.controller.SmartHomeController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        SmartHomeController controller = new SmartHomeController();
        controller.registerAppliance(light);
        controller.registerAppliance(fan);
        controller.registerAppliance(ac);

        controller.scheduleAnnualUpdate();

        while (true) {
            System.out.println("\n=== Smart Home Control Menu ===");
            System.out.println("1. Turn ON Light");
            System.out.println("2. Turn OFF Light");
            System.out.println("3. Turn ON Fan");
            System.out.println("4. Turn OFF Fan");
            System.out.println("5. Set Fan Speed (0=Off, 1=Low, 2=High)");
            System.out.println("6. Turn ON Air Conditioner");
            System.out.println("7. Turn OFF Air Conditioner");
            System.out.println("8. Set AC Temperature");
            System.out.println("9. Set AC Mode (COOL / HEAT / OFF)");
            System.out.println("10. Manually Run Jan 1st System Update");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> light.turnOn();
                case 2 -> light.turnOff();
                case 3 -> fan.turnOn();
                case 4 -> fan.turnOff();
                case 5 -> {
                    System.out.print("Enter speed (0-2): ");
                    int speed = scanner.nextInt();
                    scanner.nextLine();
                    fan.setSpeed(speed);
                }
                case 6 -> ac.turnOn();
                case 7 -> ac.turnOff();
                case 8 -> {
                    System.out.print("Enter temperature: ");
                    int temp = scanner.nextInt();
                    scanner.nextLine();
                    ac.setTemperature(temp);
                }
                case 9 -> {
                    System.out.print("Enter mode (COOL / HEAT / OFF): ");
                    String modeStr = scanner.nextLine().toUpperCase();
                    try {
                        ThermostatMode mode = ThermostatMode.valueOf(modeStr);
                        ac.setMode(mode);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid mode.");
                    }
                }
                case 10 -> controller.shutdownAllForUpdate();
                case 0 -> {
                    System.out.println("Shutting down Smart Home. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
        
    }
}
