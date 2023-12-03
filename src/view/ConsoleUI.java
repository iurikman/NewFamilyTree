package view;

import presenter.Presenter;
import view.menu.HabitsMenu;
import view.menu.MainMenu;
import view.menu.ProfessionsMenu;
import view.menu.SetMenu;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Boolean flag = true;
    private MainMenu mainMenu;
    private SetMenu setMenu;
    private ProfessionsMenu professionsMenu;
    private HabitsMenu habitsMenu;
    private Presenter presenter;
    private Scanner scanner;
    private int id = 0;
    private String memoryName = " ";
    private Validator validator;

    public ConsoleUI() {
        mainMenu = new MainMenu(this);
        setMenu = new SetMenu(this);
        professionsMenu = new ProfessionsMenu(this);
        habitsMenu = new HabitsMenu(this);
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        validator = new Validator(0);
    }

    public void start() {
        while (flag) {
            printMainMenu();
            scanMainMenu();
        }
    }

    public void scanMainMenu() {
        scanner = new Scanner(System.in);
        mainMenu.execute(validator.choice(scanner.nextLine()));
    }

    public void scanSetMenu() {
        scanner = new Scanner(System.in);
        setMenu.execute(validator.choice(scanner.nextLine()));
    }

    private void scanProfessionMenu() {
        scanner = new Scanner(System.in);
        setMenu.execute(validator.choice(scanner.nextLine()));
    }

    public void printMainMenu() {
        System.out.println(mainMenu.print());
    }

    public void printSetMenu() {
        System.out.println(setMenu.print());
    }

    public void addElement() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        presenter.addElement(name);
        System.out.println(name + " added to family tree.\n-----------------");
    }

    public void findByName() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        if (presenter.familyTreeIsExist() && presenter.elementIsExistByName(name)) {
            memoryName = name;
            id = presenter.sendByName(name).getID();
            presenter.findByName(name);
            System.out.println(name + " found. What do you want to do?");
            printSetMenu();
            scanSetMenu();
        } else System.out.println("Family tree is empty!");
    }

    public void findById() {
        System.out.println("ID:");
        String strId = scanner.nextLine();
        id = validator.choice(strId);
        if (presenter.elementIsExistByID(id)) {
            System.out.println(presenter.findByID(id));
            System.out.println("-----------------\n");
            memoryName = presenter.findByID(id).getName();
            printSetMenu();
            scanSetMenu();
        } else {
            System.out.println("Element is NOT exist!");
        }
    }

    public void printFamilyTree() {
        System.out.println("List of elements:\n-----------------");
        presenter.getFamilyTree();
        System.out.println("-----------------\n");
    }

    public void exit() {
        flag = false;
    }

    public void setAllInfo() {
        setGender();
        setBD();
        setMother();
        setFather();
        setChild();
        setProfession();
        setHabit();
    }

    public void getAllInfo() {
        presenter.getAllInfo(memoryName);
        printSetMenu();
        scanSetMenu();
    }

    public void setGender() {
        boolean genderFlag = true;
        System.out.println("M or F?");
        while (genderFlag) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("m")) {
                presenter.setGender(memoryName, 'm');
                genderFlag = false;
            } else if (gender.equalsIgnoreCase("f")) {
                presenter.setGender(memoryName, 'f');
                genderFlag = false;
            } else {
                System.out.println("Incorrect letter! Please try again:");
            }
        }
    }

    public void setBD() {
        System.out.println("BD (YYYY-MM-DD):");
        String bdScanned = scanner.nextLine();
        LocalDate bd = LocalDate.of(1990, 01, 01);
        if (validator.isValidDateFormat("yyyy-MM-dd", bdScanned)) {
            bd = LocalDate.parse(bdScanned);
        }
        presenter.setBD(memoryName, bd);
    }

    public void setMother() {
        System.out.println("Mother name: ");
        String motherName = scanner.nextLine();
        presenter.setMother(memoryName, motherName);
    }

    public void setFather() {
        System.out.println("Father name: ");
        String fatherName = scanner.nextLine();
        presenter.setFather(memoryName, fatherName);
    }

    public void setChild() {
        System.out.println("Child name: ");
        String childName = scanner.nextLine();
        presenter.setChild(memoryName, childName);
    }

    public void setHabit() {
        System.out.println("Choice the habit from list: ");
        System.out.println(habitsMenu.print());
        int habitIndex = validator.choice(scanner.nextLine());
        if (habitIndex < Habits.values().length - 1) {
            presenter.setHabit(memoryName, Arrays.stream(Habits.values()).toList().get(habitIndex - 1));
        }
    }

    public void setProfession() {
        System.out.println("Choice the profession from list: ");
        System.out.println(professionsMenu.print());
        int professionIndex = validator.choice(scanner.nextLine());
        if (professionIndex < Profession.values().length - 1) {
            presenter.setProfession(memoryName, Arrays.stream(Profession.values()).toList().get(professionIndex - 1));
        }


    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void save() {
        presenter.save();
    }

    public void read() {
        presenter.read();
    }

    public void back() {
        start();
    }
}
