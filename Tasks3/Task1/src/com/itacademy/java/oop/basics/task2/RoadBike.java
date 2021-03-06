package com.itacademy.java.oop.basics.task2;

import com.itacademy.java.oop.basics.task2.exceptions.NotLegalObjectInitializationValues;

public class RoadBike implements Bicycle{

    static final int MAXIMUM_SPEED = 50;
    static final int MINIMUM_SPEED = 0;
    static final int MINIMUM_GEAR = 0;
    static final int MAXIMUM_GEAR = 10;
    private int gear;
    private int speed;

    public RoadBike(int gear, int speed) throws NotLegalObjectInitializationValues {
        if (gear>MAXIMUM_GEAR || gear < MINIMUM_GEAR){
            throw new NotLegalObjectInitializationValues("The values for the object initializations are not correct");
        }else{
            if (speed > MAXIMUM_SPEED || speed < MINIMUM_SPEED){
                throw new NotLegalObjectInitializationValues("The values for the object initializations are not correct");
            }
        }
        this.gear = gear;
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void changeGear(int newGear) {
        int changeInGear = Math.abs(gear - newGear);
        int suggestedGear;
        int possibleChange = 2;
        if (newGear <MINIMUM_GEAR || newGear >MAXIMUM_GEAR){
            System.out.println(String.format("The new gear is lower than %s or greater than %s.", MINIMUM_GEAR, MAXIMUM_GEAR));
        }else if(changeInGear > possibleChange){
                if (newGear > gear){
                    suggestedGear = gear + possibleChange;
                }else{
                    suggestedGear = gear - possibleChange;
                }
                System.out.println("The value is not allowed, please specify new value. You should use:" + suggestedGear + " gear.");
            }
        else {
            this.gear = newGear;
            System.out.println("The new gear: " + this.gear + " was set");
        }

    }

    @Override
    public void speedUp(int increment) {
        int newSpeed = speed + increment;
        if (increment < 0){
            System.out.println("The value is negative. Please use positive value.");
        }else if(newSpeed > MAXIMUM_SPEED){
            int highestIncrement = MAXIMUM_SPEED - speed;
            System.out.println("The speed is too high. The highest possible increment is "+ highestIncrement);
        }else{
            speed = newSpeed;
            System.out.println("The speed of the road bike was increased. The new speed is: " + speed);
        }
    }

    @Override
    public void applyBrakes(int brakeValue) {
        int newSpeed = speed + brakeValue;
        int suggestedSpeed;
        if (brakeValue > 0){
            System.out.println("The brake value can not be positive. Please, use negative value.");
        }else if (newSpeed < MINIMUM_SPEED) {
                suggestedSpeed = speed - MINIMUM_SPEED;
            System.out.println("The brake value is too high, please select the highest possible brake value: " + suggestedSpeed);
        }
        else{
            speed = newSpeed;
            System.out.println("The speed was descresed. The new speed is: " + speed);
        }
    }

    @Override
    public String toString() {
        return String.format("RoadBike[ gear = %s, speed = %s]",
                gear, speed);
    }
}
