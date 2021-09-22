/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Check {

    static Scanner scan = new Scanner(System.in);

    public static int getAnInteger(String msg, String errorMsg, int min, int max) {
        int number;
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }

        while (true) {
            try {
                System.out.println(msg);
                number = Integer.parseInt(scan.nextLine());
                if (!(number >= min && number <= max)) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAName(String msg, String errorMsg) {
        String name = new String();
        String pattern = "[a-zA-Z].+";
        while (true) {
            try {
                System.out.println(msg);
                name = scan.nextLine();
                if (!name.matches(pattern)) {
                    throw new Exception();
                }
                return toUpperFirstCharacter(name);
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getACharacteristic(String msg, String errorMsg) {
        String str = new String();
        while (true) {
            try {
                System.out.println(msg);
                str = scan.nextLine();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return toUpperFirstCharacter(str);
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAnID(String msg, String errorMsg) {
        String id = new String();
        String pattern = "[a-zA-Z]{2}[0-9]{4}";
        while (true) {
            try {
                System.out.println(msg);
                id = scan.nextLine();
                if (!id.matches(pattern)) {
                    throw new Exception();
                }
                return id.toUpperCase();
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String msg, String errorMsg, double min, double max) {
        double number;
        if (min > max) {
            double t = min;
            min = max;
            max = t;
        }
        while (true) {
            try {
                System.out.println(msg);
                number = Double.parseDouble(scan.nextLine());
                if (!(number >= min && number <= max)) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAString(String msg, String errorMsg) {
        String s = new String();
        while (true) {
            try {
                System.out.println(msg);
                s = scan.nextLine();
                if (s.isEmpty()) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getAnswer(String msg, String errorMsg) {
        String answer = new String();
        while (true) {
            try {
                System.out.println(msg);
                answer = scan.nextLine();
                answer = answer.trim();
                if (!(answer.equalsIgnoreCase("yes")
                        || answer.equalsIgnoreCase("no"))) {
                    throw new Exception();
                }
                return toUpperFirstCharacter(answer);
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String toUpperFirstCharacter(String s) {
        String[] stringArr = s.split(" ");
        String result = new String();
        for (String e : stringArr) {
            e = e.toLowerCase();
            e = e.substring(0, 1).toUpperCase() + e.substring(1);
            result = result.concat(e + " ");
        }
        return result.trim();
    }

}
