//package geekbrains.oop;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("kot");
        cat.toRun(150);
        cat.toFloat(55);
        cat.toJump(1.5);
        System.out.print("\n");

        Dog dog = new Dog("pes");
        dog.toRun(300);
        dog.toFloat(12);
        dog.toJump(0.3);
        System.out.print("\n");

        Dog dog1 = new Dog("pes-1");
        dog1.toRun(450);
        dog1.toFloat(10);
        dog1.toJump(0.7);
    }
}

abstract class Animal{
    private String name;
    private int distance_length;
    private int float_distance;
    private double jump_height;


    public void toRun(int x){
        if(distance_length > x) {
            System.out.println(name + " run: true");
        } else {
            System.out.println(name + " run: false max: " + distance_length + "m)");
        }
    }

    public void toFloat(int x){
        if(float_distance > x) {
            System.out.println(name + " float: true");
        } else {
            System.out.println(name + " float: false max: " + float_distance + "m)");
        }
    }

    public void toJump(double x){
        if(jump_height > x) {
            System.out.println(name + " jump: true");
        } else {
            System.out.println(name + " jump: false max: " + jump_height + "m)");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDistance_length(int distance_length) {
        if(distance_length > 0){
            this.distance_length = distance_length;
        } else {
            System.out.println(name + " - wrong distance");
        }
    }

    public int getDistance_length() {
        return distance_length;
    }

    public void setFloat_distance(int float_distance) {
        if(float_distance > 0) {
            this.float_distance = float_distance;
        } else {
            System.out.println(name + " - wrong float distance");
        }
    }

    public int getFloat_distance() {
        return float_distance;
    }

    public void setJump_height(double jump_height) {
        if(jump_height > 0) {
            this.jump_height = jump_height;
        } else {
            System.out.println(name + " - wrong jump");
        }
    }

    public double getJump_height() {
        return jump_height;
    }
}

class Cat extends Animal{
    Cat(String name){
        setName(name);
        setDistance_length((int)((Math.random() * 151) + 100));
        setJump_height(2);
    }

    @Override
    public void toFloat(int x){
        System.out.println("The cat isn't able to swim!");
    }
}

class Dog extends Animal{
    Dog(String name){
        setName(name);
        setDistance_length((int)((Math.random() * 251) + 350));
        setFloat_distance((int)((Math.random() * 11) + 5));
        setJump_height(0.5);
    }
}