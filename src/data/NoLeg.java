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
public class NoLeg extends Animal {

    public NoLeg() {
        super();
    }

    public NoLeg(String id, String name, double weight, String characteristic) {
        super(id, name, 0, weight, characteristic);
    }

    @Override
    public void input() {
        name = Check.getAName("Enter animal's Name: ", "Name has just alphabet, please !!!").trim();
        weight = Check.getADouble("Enter animal's Weight: ",
                "Weight's Animal is a double number and in 0-2000kg, please !!!", 0, 2000);
        characteristic = Check.getAName("Enter animal's Characteristic: ",
                "Don't have any special character, please !!!").trim();
    }

    @Override
    public void showinfo() {
        String msg = new String();
        msg = String.format("|%-10s|%-15s|%5d|%30s|%14.2f|", id, name, leg, characteristic, weight);
        System.out.println(msg);
    }

    @Override
    public String toStringMySelf() {
        return id + ";" + name + ";" + leg + ";" + characteristic + ";" + weight;
    }

}
