/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import data.Animal;
import data.FourLeg;
import data.NoLeg;
import data.TwoLegCanFly;
import data.TwoLegNoFly;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 *
 * @author Dell
 */
public class File_DAO {

    public static TreeSet<Animal> loadData(String filename) {
        TreeSet<Animal> list = new TreeSet<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while (br.ready()) {
                String s = new String();
                Animal obj = null;
                s = br.readLine();
                String[] animal = s.split(";");
                if (animal.length == 5 || animal.length == 7) {
                    if (animal.length == 5) {
                        int leg;
                        leg = Integer.parseInt(animal[2]);
                        if (leg == 0) {
                            obj = new NoLeg(animal[0].toUpperCase(), animal[1], Double.parseDouble(animal[4]), animal[3]);
                        } else {
                            obj = new FourLeg(animal[0].toUpperCase(), animal[1], Double.parseDouble(animal[4]), animal[3]);
                        }
                    } else {
                        if (animal[6].equalsIgnoreCase("can fly")) {
                            obj = new TwoLegCanFly(animal[0].toUpperCase(), animal[1], Double.parseDouble(animal[4]), animal[3]);
                        } else {
                            obj = new TwoLegNoFly(animal[0].toUpperCase(), animal[1], Double.parseDouble(animal[4]), animal[3]);
                        }
                    }
                    if (obj != null) {
                        list.add(obj);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error at File_DAO " + e.toString());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error at Load data File_DAO close connection " + e.toString());
            }
        }
        return list;
    }

    public static void writeData(String filename, TreeSet<Animal> list) {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(filename);
            for (Animal a : list) {
                pw.println(a.toStringMySelf());
                pw.flush();
            }

        } catch (Exception e) {
            System.out.println("Error at write data File_DAO " + e.toString());
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                System.out.println("Error at Write data File_DAO close connection " + e.toString());
            }
        }
    }

}
