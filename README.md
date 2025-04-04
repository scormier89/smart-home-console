# Smart Home Console App

This is a little Java console project that controls a few smart home appliances: a Light, a Fan, and an Air Conditioner.

Each device has its own rules for how it turns off:
- Light turns off by flipping a switch
- Fan turns off by setting speed to 0 (speeds are 0, 1, or 2)
- AC turns off by setting its mode to `OFF`

The system also has a fake “yearly update” that runs on January 1st at 1:00 AM (simulated using a scheduler), which shuts everything off.

## Features

- Console menu to turn stuff on/off, set speeds, temps, modes, etc.
- Simple OOP setup with an `Appliance` interface
- Test coverage using JUnit
- Real scheduling using `ScheduledExecutorService`

## How to Run It

You need Java 17+ and Maven installed.

```bash
cd /appliance-control
mvn compile
java -cp target/classes com.smart.home.Main