/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import data.Animal;
import data.AnimalList;
import data.FourLeg;
import data.NoLeg;
import data.TwoLegCanFly;
import data.TwoLegNoFly;
import java.util.TreeSet;
import validation.Check;

/**
 *
 * @author Dell
 */
public class Program {

    public static void main(String[] args) {
        int choice;
        AnimalList obj = new AnimalList();
        do {
            Menu();
            choice = Check.getAnInteger("Your choice is: ",
                    "Choose 1-8 options please !!!", 1, 8);
            switch (choice) {

                case 1: {
                    obj.loadAnimal("Animal.txt");
                    if (!obj.getList().isEmpty()) {
                        obj.showAll();
                    }
                    break;
                }

                case 2: {
                    int flag = 1;
                    do {
                        MenuAdd();
                        int choiceIn = Check.getAnInteger("Your choice is: ",
                                "Choose 1-4 options, please !!!", 1, 4);
                        switch (choiceIn) {

                            case 1: {
                                NoLeg obj1 = new NoLeg();
                                if (obj.addAnimal(obj1)) {
                                    System.out.println("Adding successfully!");
                                } else {
                                    System.out.println("Adding failed! This ID has existed!");
                                }

                                break;
                            }

                            case 2: {
                                MenuTwoLeg();
                                choiceIn = Check.getAnInteger("Your choice is: ",
                                        "Just choose 1 in 2 options, please !!!", 1, 2);
                                switch (choiceIn) {
                                    case 1: {
                                        TwoLegNoFly obj2 = new TwoLegNoFly();
                                        if (obj.addAnimal(obj2)) {
                                            System.out.println("Adding successfully !");
                                        } else {
                                            System.out.println("Adding failed! This ID has existed!");
                                        }
                                        break;
                                    }

                                    case 2: {
                                        TwoLegCanFly obj3 = new TwoLegCanFly();
                                        if (obj.addAnimal(obj3)) {
                                            System.out.println("Adding successfully !");
                                        } else {
                                            System.out.println("Adding failed! This ID has existed!");
                                        }
                                        break;
                                    }
                                }

                                break;
                            }

                            case 3: {
                                FourLeg obj4 = new FourLeg();
                                if (obj.addAnimal(obj4)) {
                                    System.out.println("Adding successfully !");
                                } else {
                                    System.out.println("Adding failed! This ID has existed!");
                                }
                                break;
                            }
                        }
                        String answer = new String();
                        answer = Check.getAnswer("Do you wanna continue to add animal ? <Yes/No>",
                                "Just yes or no answer, please !!!");
                        if (answer.equalsIgnoreCase("yes")) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    } while (flag == 1);

                    break;
                }

                case 3: {
                    String idInput = new String();
                    idInput = Check.getAnID("Enter animal's ID you wanna update: ",
                            "Format ID: aaxxxx, a is alphabet, x is number please !!!");
                    obj.updateAnimal(idInput);
                    break;
                }

                case 4: {
                    String idInput = new String();
                    idInput = Check.getAnID("Enter animal's ID you wanna delete: ",
                            "Format ID: aaxxxx, a is alphabet, x is number please !!!");
                    obj.deleteAnimal(idInput);
                    break;
                }

                case 5: {
                    Menu5();
                    int choiceIn = Check.getAnInteger("Your choice is: ",
                            "Just choose 1 in 2 options, please !!!", 1, 2);
                    switch (choiceIn) {
                        case 1: {
                            if (obj.getList().isEmpty()) {
                                System.out.println("Nothing in list!");
                            } else {
                                TreeSet<Animal> tmpList = new TreeSet<>();
                                String nameInput = new String();
                                nameInput = Check.getAName("Enter animal's Name you wanna search: ",
                                        "Name's Animal is not empty, please !!!");
                                tmpList = obj.searchByName(nameInput);
                                if (!tmpList.isEmpty()) {
                                    obj.showAll(tmpList);
                                } else {
                                    System.out.println("Can't find this animal!");
                                }
                            }
                            break;
                        }

                        case 2: {
                            if (obj.getList().isEmpty()) {
                                System.out.println("Nothing in list!");
                            } else {
                                double weightInput;
                                weightInput = Check.getADouble("Enter animal's weight you wanna search: ",
                                        "Weight's animal is a double number and in 0-2000kg, please !!!", 0, 2000);
                                TreeSet<Animal> result = new TreeSet<>();
                                result = obj.searchByWeight(weightInput);
                                if (result.isEmpty()) {
                                    System.out.println("Can't find any animal!");
                                } else {
                                    obj.showAll(result);
                                }
                            }
                            break;
                        }
                    }
                    break;
                }

                case 6: {
                    if (obj.getList().isEmpty()) {
                        System.out.println("Nothing in list");
                    } else {
                        Menu6();
                        int choiceIn = Check.getAnInteger("Your choice is: ",
                                "Just choose 1 in 2 options, please !!!", 1, 2);
                        switch (choiceIn) {
                            case 1: {
                                MenuTypeAnimal();
                                choice = Check.getAnInteger("Your choice is: ",
                                        "Just choose 1-4 options, please !!!", 1, 4);
                                switch (choice) {
                                    case 1: {
                                        obj.showNoLeg();
                                        break;
                                    }
                                    case 2: {
                                        obj.showTwoLegNoFly();
                                        break;
                                    }
                                    case 3: {
                                        obj.showTwoLegCanFly();
                                        break;
                                    }
                                    case 4: {
                                        obj.showFourLeg();
                                        break;
                                    }
                                }
                                break;
                            }

                            case 2: {
                                obj.showAll();
                                break;
                            }
                        }
                    }

                    break;
                }

                case 7: {
                    obj.storeAnimal("Animal.txt");
                    break;
                }

                case 8: {
                    System.out.println("Good bye!");
                    break;
                }

            }
        } while (choice != 8);
    }

    public static void Menu() {
        System.out.println("1. Load data from file");
        System.out.println("2. Add a new animal");
        System.out.println("3. Update an animal");
        System.out.println("4. Delete an animal");
        System.out.println("5. Search animal");
        System.out.println("6. Show animal list");
        System.out.println("7. Store data to file");
        System.out.println("8. Quit");
    }

    public static void MenuAdd() {
        System.out.println("Group 1: No leg");
        System.out.println("Group 2: Two legs");
        System.out.println("Group 3: Four legs");
    }

    public static void MenuTwoLeg() {
        System.out.println("1. No Fly");
        System.out.println("2. Fly");
    }

    public static void Menu5() {
        System.out.println("1. Search by name");
        System.out.println("2. Search by weight");
    }

    public static void Menu6() {
        System.out.println("1. Show by type");
        System.out.println("2. Show all animal");
    }

    public static void MenuTypeAnimal() {
        System.out.println("Group 1: No leg");
        System.out.println("Group 2: Two legs - No fly");
        System.out.println("Group 3: Two legs - Can fly");
        System.out.println("Group 4: Four legs");
    }
}
