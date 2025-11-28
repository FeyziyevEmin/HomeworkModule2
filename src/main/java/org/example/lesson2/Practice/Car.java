package org.example.lesson2.Practice;

public class Car {
    private int gear;
    private int speed;

    public Car(int gear,int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

   public static void changeGear(int gear){
        if (gear==1){
            System.out.println("going with 1");
        }
        if (gear==2){
            System.out.println("going with 2");
        }
        if (gear == 3 || gear == 4 || gear == 5){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "gear=" + gear +
                ", speed=" + speed +
                '}';
    }
}
