/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dao.File_DAO;
import java.util.TreeSet;
import validation.Check;

/**
 *
 * @author Dell
 */
public class AnimalList {
    
    public TreeSet<Animal> list;
    
    public AnimalList() {
        list = new TreeSet<>();
    }
    
    public AnimalList(TreeSet<Animal> list) {
        this.list = list;
    }
    
    public TreeSet<Animal> getList() {
        return list;
    }
    
    public void setList(TreeSet<Animal> list) {
        this.list = list;
    }
    
    public void loadAnimal(String filename) {
        list = File_DAO.loadData(filename);
        if (!list.isEmpty()) {
            System.out.println("Loading successfully!");
        } else {
            System.out.println("Nothing to load!");
        }
    }
    
    public boolean checkExist(String id) {
        boolean check = false;
        for (Animal a : list) {
            if (a.id.equalsIgnoreCase(id)) {
                return true;
            }
        }
        return check;
    }
    
    public Animal getAnimalByID(String id) {
        if (!list.isEmpty()) {
            for (Animal a : list) {
                if (a.id.equalsIgnoreCase(id)) {
                    return a;
                }
            }
        }
        return null;
    }
    
    public boolean addAnimal(Animal a) {
        String id;
        do {
            id = Check.getAnID("Enter animal's ID: ",
                    "Format ID: aaxxxx, a is alphabet, x is number please !!!");
            if (checkExist(id)) {
                System.out.println("Sorry, this AnimalID has existed in system !");
            }
        } while (checkExist(id));
        a.setId(id);
        if (a instanceof NoLeg) {
            a.input();
        } else if (a instanceof TwoLegCanFly) {
            a.input();
        } else if (a instanceof TwoLegNoFly) {
            a.input();
        } else if (a instanceof FourLeg) {
            a.input();
        } else {
            System.out.println("This type Animal is not supported!");
        }
        return list.add(a);
    }
    
    public void updateAnimal(String idInput) {
        if (!list.isEmpty()) {
            for (Animal a : list) {
                if (a.id.equalsIgnoreCase(idInput)) {
                    a.update();
                    System.out.println("Updating successfully!");
                    System.out.println(" ID         Name              Leg                 Characteristic         Weight          Swings        Fly");
                    a.showinfo();
                    return;
                }
            }
            System.out.println("This animal does not exist in list!");
        } else {
            System.out.println("Nothing to update!");
        }
    }
    
    public void deleteAnimal(String idInput) {
        int flag = 0;
        if (!list.isEmpty()) {
            
            Animal a = getAnimalByID(idInput);
            if (a != null) {
                flag = 1;
            }
            
            if (flag == 1) {
                String answer = new String();
                answer = Check.getAnswer("Are you sure to delete this animal? <Yes/No>",
                        "Just yes or no answer, please !!!");
                if (answer.equalsIgnoreCase("yes")) {
                    if (list.remove(a)) {
                        System.out.println("Deleting successfully!");
                    } else {
                        System.out.println("Deleting failed!");
                    }
                } else {
                    System.out.println("OKAY! This animal still exist in list !");
                }
            } else {
                System.out.println("This animal does not exist in list!");
            }
        } else {
            System.out.println("Nothing to delete");
        }
    }
    
    public TreeSet<Animal> searchByName(String nameInput) {
        TreeSet<Animal> tmpList = new TreeSet<>();
        for (Animal a : list) {
            if (a.name.equalsIgnoreCase(nameInput)) {
                tmpList.add(a);
            }
        }
        return tmpList;
    }
    
    public TreeSet<Animal> searchByWeight(double weightInput) {
        TreeSet<Animal> tmpList = new TreeSet<>();
        for (Animal a : list) {
            if (a.weight == weightInput) {
                tmpList.add(a);
            }
        }
        return tmpList;
    }
    
    public void showNoLeg() {
        int flag = 0;
        System.out.println(" ID         Name              Leg                 Characteristic          Weight");
        for (Animal o : list) {
            if (o instanceof NoLeg) {
                o.showinfo();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Don't have any animal no leg in list!");
        }
    }
    
    public void showTwoLegNoFly() {
        int flag = 0;
        System.out.println(" ID         Name              Leg                 Characteristic         Weight          Swings        Fly");
        for (Animal o : list) {
            if (o instanceof TwoLegNoFly) {
                o.showinfo();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Don't have any animal bipedal and flightless in list!");
        }
    }
    
    public void showTwoLegCanFly() {
        int flag = 0;
        System.out.println(" ID         Name              Leg                 Characteristic         Weight          Swings        Fly");
        for (Animal o : list) {
            if (o instanceof TwoLegCanFly) {
                o.showinfo();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Don't have any animal bipedal and flying in list!");
        }
    }
    
    public void showFourLeg() {
        int flag = 0;
        System.out.println(" ID         Name              Leg                 Characteristic         Weight");
        for (Animal o : list) {
            if (o instanceof FourLeg) {
                o.showinfo();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Don't have any animal four leg in list!");
        }
    }
    
    public void showAll() {
        System.out.println(" ID         Name              Leg                 Characteristic         Weight          Swings        Fly");
        for (Animal a : list) {
            a.showinfo();
        }
    }
    
    public void showAll(TreeSet<Animal> tmp) {
        System.out.println(" ID         Name              Leg                 Characteristic         Weight          Swings        Fly");
        for (Animal a : tmp) {
            a.showinfo();
        }
    }
    
    public void storeAnimal(String filename) {
        File_DAO.writeData(filename, list);
    }
}
