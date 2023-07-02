
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Tien Dep Trai
 */
public class KeyBoardIO {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInteger(final String contentMessage, final String errorMessage) {
        int number;
        while (true) {
            try {
                System.out.println(contentMessage + " ");
                number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage + "\n");
            }
        }
    }

    public static int getInteger(final String contentMessage, String errorMessage, int firstLimited, int endLimited) {
        if (firstLimited > endLimited) {
            int swapInt = firstLimited;
            firstLimited = endLimited;
            endLimited = swapInt;
        }
        int number;
        while (true) {
            try {
                System.out.print(contentMessage);
                number = Integer.parseInt(sc.nextLine());
                if (number < firstLimited || number > endLimited) {
                    throw new IllegalArgumentException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage + "\n");
            } catch (IllegalArgumentException e) {
                System.err.println(errorMessage + "\n");
            }
        }
    }

    public static int getPositiveInteger(final String contentMessage, final String errorMessage) {
        int positiveInt;
        while (true) {
            try {
                System.out.println(contentMessage + " ");
                positiveInt = Integer.parseInt(sc.nextLine());
                if (positiveInt <= 0) {
                    throw new IllegalArgumentException();
                }
                return positiveInt;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage + "\n");
            } catch (IllegalArgumentException e) {
                System.err.println(errorMessage + "\n");
            }
        }
    }

    public static double getDouble(final String contentMessage, final String errorMessage) {
        double doubleNumber;
        while (true) {
            try {
                System.out.println(contentMessage + " ");
                doubleNumber = Double.parseDouble(sc.nextLine());
                return doubleNumber;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage + "\n");
            }
        }
    }

    public static double getPositiveDouble(final String contentMessage, final String errorMessage) {
        double positiveDouble;
        while (true) {
            try {
                System.out.println(contentMessage + " ");
                positiveDouble = Double.parseDouble(sc.nextLine());
                if (positiveDouble <= 0) {
                    throw new IllegalArgumentException();
                }
                return positiveDouble;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage + "\n");
            } catch (IllegalArgumentException e) {
                System.err.println(errorMessage + "\n");
            }
        }
    }

    public static String getNormalizedString(String string) {

        string = string.trim();
        string = string.replaceAll("\\s+", " ");
        return string;
    }

    public static String getName(final String announcement, final String errorAnouncement) {
        String normalizedString;
        boolean match = true;
        while (true) {
            System.out.println(announcement);

            normalizedString = sc.nextLine().trim().toLowerCase();
            normalizedString = normalizedString.replaceAll("\\s+", " ");
            match = normalizedString.matches("^[a-zA-Z\\s]*$");

            if (normalizedString.length() == 0 || !match) {
                System.err.println(errorAnouncement);
            } else {
                String[] temp = normalizedString.split(" ");
                normalizedString = "";
                for (int i = 0; i < temp.length; i++) {
                    normalizedString += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                    if (i == temp.length - 1) {
                        break;
                    }
                    normalizedString += " ";
                }

                return normalizedString;
            }
        }
    }

    public static String getName(final String name) {

        String normalizedString = getNormalizedString(name).toLowerCase();

        if (normalizedString.length() != 0) {
            String[] temp = normalizedString.split(" ");
            normalizedString = "";
            for (int i = 0; i < temp.length; i++) {
                normalizedString += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                if (i == temp.length - 1) {
                    break;
                }
                normalizedString += " ";
            }

            return normalizedString;
        }

        return null;
    }

    public static boolean getQuestion(final String announcement, final String erorr, final String choose1, final String choose2) {
        while (true) {
            try {
                System.out.println(announcement);
                String string = sc.nextLine();
                String choice = KeyBoardIO.getNormalizedString(string);
                if (choice.equalsIgnoreCase(choose1)) {
                    return true;
                } else if (choice.equalsIgnoreCase(choose2)) {
                    return false;
                } else {
                    throw new IllegalArgumentException ();
                }

            } catch (IllegalArgumentException  e) {
                System.err.println(erorr + "\n");
            }
        }
    }

    public static String getId(final String announcement, final String erorr, final String formatInput) {
        String id;
        boolean match = true;
        while (true) {
            System.out.println(announcement);

            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(formatInput);

            if (id.length() == 0 || !match) {
                System.err.println(erorr + "\n");
            } else {
                return id;
            }
        }
    }
}
