package view;

import view.menu.ProfessionsMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validator {
        int size;
        Scanner scanner;

    public Validator(int size) {
        this.size = size;
    }

    public int choice(String choice) {
        while (!isNumeric(choice)) {
            System.out.println("Error, try again!");
            scanner = new Scanner(System.in);
            choice = scanner.nextLine();
        }
        return Integer.parseInt(choice);
    }

    public static boolean isNumeric(String string) {
        if(string == null || string.equals("")) {
            return false;
        }

        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error, try again!");
        }
        return false;
    }

    public <Date> boolean isValidDateFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = (Date) sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                return true;
            }
        } catch (ParseException ex) {
            System.out.println("Invalid format");
        }
        return false;
    }
}
