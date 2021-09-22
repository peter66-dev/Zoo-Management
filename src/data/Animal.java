/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import validation.Check;

/**
 *
 * @author Dell
 */
public abstract class Animal implements Comparable<Animal> {

    public String id;
    public String name;
    public int leg;
    public double weight;
    public String characteristic;

    public Animal() {
        id = "";
        name = "";
        leg = 0;
        weight = 0;
        characteristic = "";
    }

    public Animal(String id, String name, int leg, double weight, String characteristic) {
        this.id = id;
        this.name = name;
        this.leg = leg;
        this.weight = weight;
        this.characteristic = characteristic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public abstract void input();

    public abstract void showinfo();

    public abstract String toStringMySelf();

    public void update() {
        name = Check.getAName("Enter animal's Name: ", "Name has just alphabet, please !!!");
        weight = Check.getADouble("Enter animal'Weight: ",
                "Weight's animal is a double number and in 0-2000kg, please !!!", 0, 2000);
        characteristic = Check.getAName("Enter animal's Characteristic: ",
                "Don't have any special character, please !!!");
    }

    @Override
    public int compareTo(Animal o) {
        return this.id.compareToIgnoreCase(o.id);
    }
}
