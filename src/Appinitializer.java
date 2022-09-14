import java.util.Scanner;

public class Appinitializer {
    static String[] id = new String[50];
    static String[] name = new String[50];
    static int[] pfMarks = new int[50];
    static int[] dbmsMarks = new int[50];
    static int available = 0;
    static int store = 0;

    public static void main(String[] args) {
        Marks();
        homePage();
    }

    public static void homePage() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("|  \t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t  |");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        System.out.println("[1] Add New Student\t\t\t\t[2]  Add New Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t\t[4]  Update Student Details");
        System.out.println("[5] Update Marks\t\t\t\t[6]  Delete Student");
        System.out.println("[7] Print Student Details\t\t\t[8]  Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals\t\t[10] Best in Database Management System");

        System.out.println();
        System.out.print("Enter an option continue >");
        int option = input.nextInt();
        System.out.println();


        switch (option) {
            case 1:
                addNewStudent();
                break;

            case 2:
                addNewStudentWithMark();
                break;

            case 3:
                addMarks();
                break;

            case 4:
                updateDetails();
                break;

            case 5:
                updateMarks();
                break;

            case 6:
                deleteStudent();
                break;

            case 7:
                printStudentDetails();
                break;

            case 8:
                printStudentRanks();
                break;

            case 9:
                bestInPF();
                break;

            case 10:
                bestInDBMS();
                break;

            default:
                System.out.print("Invalid Option");

        }
    }

    private static int searchStudent(String key) {
        for (int i = 0; i < available; i++) {
            if (key.equals(id[i])) {
                return i;
            }
        }
        return -1;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    private static int[] sort(int[] total) {
        int[] indexArray = new int[50];
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = -1;
        }
        for (int j = 0; j < available; j++) {
            int maxIndex = 0;
            int max = 0;
            for (int i = 0; i < available; i++) {
                if (total[i] > max) {
                    max = total[i];
                    maxIndex = i;
                }
            }
            total[maxIndex] = -1;
            indexArray[j] = maxIndex;
        }
        return indexArray;
    }

    private static int[] sortAvg(double[] average) {
        int[] tempArray = new int[100];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = -1;
        }

        for (int j = 0; j < available; j++) {
            int maxIndex = 0;
            double max = Double.MIN_VALUE;
            for (int i = 0; i < available; i++) {
                if (average[i] > max) {
                    max = average[i];
                    maxIndex = i;
                }
            }
            average[maxIndex] = -1;
            tempArray[j] = maxIndex;
        }
        return tempArray;
    }

    private static void Marks() {
        for (int i = 0; i < pfMarks.length; i++) {
            pfMarks[i] = -1;
            dbmsMarks[i] = -1;
        }
    }

    private static int Index3(int[] indexArray) {
        int x = 0;
        for (int i = 0; i < available; i++) {
            if (indexArray[i] == 0) {
                x++;
            }
        }
        int count = x;
        if (count == 0) {
            return 0;
        } else {
            count--;
            return count;
        }
    }

    public static void addNewStudent() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        while (true) {
            System.out.print("Enter Student Id\t: ");
            String nowId = input.next();

            int index = searchStudent(nowId);
            if (index == -1) {
                id[available] = nowId;

                System.out.print("Enter Student Name\t: ");
                name[available] = input.next();

                available++;
                break;
            } else {
                System.out.println("The Student ID Already Exists");
                System.out.println();
            }
        }

        System.out.println();
        System.out.print("Student has added been successfully. Do you want to added a new student(Y/N ): ");
        String command = input.next();

        switch (command) {
            case "Y":
            case "y":
                addNewStudent();
                break;
            case "N":
            case "n":
                homePage();
            default:
                System.out.println("Invalid entry");
        }

    }

    public static void addNewStudentWithMark() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tADD NEW STUDENT WITH MARK\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();
        while (true) {
            System.out.print("Enter Student Id\t: ");
            String nowId = input.next();

            int index = searchStudent(nowId);
            if (index == -1) {
                id[available] = nowId;

                System.out.print("Enter Student Name\t: ");
                name[available] = input.next();
                System.out.println();

                while (true) {
                    System.out.print("Enter Programming Fundamentals Mark\t: ");
                    int temppfMark = input.nextInt();
                    if (temppfMark > 100 || temppfMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        pfMarks[available] = temppfMark;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter Database Management System Mark	: ");
                    int tempdbmsMark = input.nextInt();
                    input.nextLine();

                    if (tempdbmsMark > 100 || tempdbmsMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        dbmsMarks[available] = tempdbmsMark;
                        break;
                    }
                }

                available++;
                break;
            } else {
                System.out.println("The Student ID Already Exists");
                System.out.println();
            }
        }

        System.out.println();
        System.out.print("Student has added been successfully. Do you want to added a new student(Y/N ): ");
        String command = input.next();

        switch (command) {
            case "Y":
            case "y":
                addNewStudentWithMark();
                break;
            case "N":
            case "n":
                homePage();
            default:
                System.out.println("Invalid entry");
        }

    }

    public static void addMarks() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tADD MARK\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student Id\t: ");
        String tempId = input.nextLine();
        int index = searchStudent(tempId);

        while (true) {
            if (index == -1) {
                System.out.print("Invalid Student Id. Do You Want To Search Again ?(Y/N) :");
                String command = input.nextLine();

                if (command.equals("Y") || command.equals("y")) {
                    System.out.print("Enter Student Id\t: ");
                    tempId = input.nextLine();
                    index = searchStudent(tempId);
                } else if (command.equals("N") || command.equals("n")) {
                    homePage();
                } else {
                    System.out.println("Invalid entry");
                }

            } else {
                System.out.println("Student Name\t\t: " + name[index]);
                if (pfMarks[index] != -1 & dbmsMarks[index] != -1) {
                    System.out.println("This Student's marks have been alerady added.\n If you want to update the marks,please use [4] update marks option ");
                    System.out.println();
                    System.out.print("Do you want to add marks for another Student ? (Y/N)");
                    String command = input.nextLine();

                    switch (command) {
                        case "Y":
                        case "y":
                            addMarks();
                            break;
                        case "N":
                        case "n":
                            homePage();
                        default:
                            System.out.println("Invalid entry");
                    }
                }

                while (true) {
                    System.out.print("Enter Programming Fundamentals Mark\t: ");
                    int temppfMark = input.nextInt();

                    if (temppfMark > 100 || temppfMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        pfMarks[index] = temppfMark;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter Database Management System Mark	: ");
                    int tempdbmsMark = input.nextInt();
                    input.nextLine();
                    if (tempdbmsMark > 100 || tempdbmsMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        dbmsMarks[index] = tempdbmsMark;
                        break;
                    }
                }

                System.out.print("Mark have been added .do you wont to add marks for another student (Y/N)");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        addMarks();
                        break;
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
                break;
            }
        }
    }

    public static void updateDetails() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student Id\t: ");
        String tempId = input.nextLine();
        int index = searchStudent(tempId);

        while (true) {
            if (index == -1) {
                System.out.print("Invalid Student Id. Do You Want To Search Again ?(Y/N) :");
                String command = input.nextLine();

                if (command.equals("Y") || command.equals("y")) {
                    System.out.print("Enter Student Id\t: ");
                    tempId = input.nextLine();
                    index = searchStudent(tempId);
                } else if (command.equals("N") || command.equals("n")) {
                    homePage();
                } else {
                    System.out.println("Invalid entry");
                }

            } else {
                System.out.println("Student Name\t\t: " + name[index]);
                System.out.print("Enter the New Student Name  :");
                String newName = input.nextLine();
                name[index] = newName;

                System.out.print("Student details has been update successfully.\n Do you want to update another student details ? (Y/N)");
                String command = input.next();

                switch (command) {
                    case "Y":
                    case "y":
                        updateDetails();
                        break;
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            }


        }
    }

    public static void updateMarks() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tUPDATE MARKS\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID  :");
        String tempID = input.nextLine();
        int index = searchStudent(tempID);
        if (index != -1) {
            System.out.println("Student Name  : " + name[index]);
            System.out.println();

            if (pfMarks[index] == 0 & dbmsMarks[index] == 0) {
                System.out.print("This student's marks yet to be added.\n Do you want to update the marks of another student ? (Y/N)  :");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        updateMarks();
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            } else {
                System.out.println("Programming Fundamental Marks :" + pfMarks[index]);
                System.out.println("Database Management System Marks :" + dbmsMarks[index]);
                System.out.println();
                while (true) {
                    System.out.print("Enter new Programming Fundamentals Mark :");
                    int newpfMark = input.nextInt();

                    if (newpfMark > 100 || newpfMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        pfMarks[index] = newpfMark;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter new Database Management System Mark	: ");
                    int newdbmsMark = input.nextInt();

                    if (newdbmsMark > 100 || newdbmsMark < 0) {
                        System.out.println("Invalid Mark,Please Enter Correct Mark");
                    } else {
                        dbmsMarks[index] = newdbmsMark;
                        break;
                    }
                }
                input.nextLine();
                System.out.print("Mark have been updated successfully.\n Do you want to update marks for another student ? (Y/N)");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        updateMarks();
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            }
        } else {
            System.out.print("Invlid Student ID. Do You Want to search again (Y/N)");
            String command = input.nextLine();

            switch (command) {
                case "Y":
                case "y":
                    updateMarks();
                case "N":
                case "n":
                    homePage();
                default:
                    System.out.println("Invalid entry");
            }

        }

    }

    public static void deleteStudent() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tDELETE STUDENT\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();
        while (true) {
            System.out.print("Enter Student ID  :");
            String tempID = input.nextLine();
            int index = searchStudent(tempID);
            if (index != -1) {
                id[index] = null;
                name[index] = null;
                pfMarks[index] = -1;
                dbmsMarks[index] = -1;
                store++;

                System.out.println("Student has been deleted successfully. \n Do you want to delete another student ? (Y/N)");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        deleteStudent();
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again ? (Y/N)");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        continue;
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            }
        }
    }

    public static void printStudentDetails() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();
        while (true) {
            System.out.print("Enter Student ID  :");
            String tempID = input.nextLine();
            int index = searchStudent(tempID);

            if (index != -1) {
                System.out.println("Student Name :" + name[index]);
                System.out.println();

                if (pfMarks[index] == -1 & dbmsMarks[index] == -1) {
                    System.out.print("Marks yet to be added.\nDo you want to search another student details? (Y/N) :");
                    String command = input.nextLine();

                    switch (command) {
                        case "Y":
                        case "y":
                            printStudentDetails();
                            break;
                        case "N":
                        case "n":
                            homePage();
                        default:
                            System.out.println("Invalid entry");
                    }
                } else {
                    int[] total = new int[100];
                    for (int i = 0; i < available; i++) {
                        total[i] = (pfMarks[i] + dbmsMarks[i]);
                    }
                    int[] newIndex = sort(total);
                    int rank = 0;

                    for (int i = 0; i < available - store; i++) {
                        if (newIndex[i] == index) {
                            rank = i + 1;
                        }
                    }

                    System.out.println("+-----------------------------------+---------------+");
                    System.out.printf("|%-35s|%15d|\n", "Programming Fundamentals Marks", pfMarks[index]);
                    System.out.printf("|%-35s|%15d|\n", "Database Management System Marks", dbmsMarks[index]);
                    System.out.printf("|%-35s|%15d|\n", "Total Marks", pfMarks[index] + dbmsMarks[index]);
                    System.out.printf("|%-35s|%15.2f|\n", "Avg. Marks", (pfMarks[index] + dbmsMarks[index]) / 2.0);
                    System.out.printf("|%-35s|%15s|\n", "Rank", rank);
                    System.out.println("+-----------------------------------+---------------+");
                    System.out.println();

                    System.out.print("DoYou want to search another student details ? (Y/N) :");
                    String command = input.nextLine();

                    switch (command) {
                        case "Y":
                        case "y":
                            printStudentDetails();
                        case "N":
                        case "n":
                            homePage();
                        default:
                            System.out.println("Invalid entry");
                    }
                }
            } else {
                System.out.print("Invalid student ID . Do you want to search again ?(Y/N) :");
                String command = input.nextLine();

                switch (command) {
                    case "Y":
                    case "y":
                        continue;
                    case "N":
                    case "n":
                        homePage();
                    default:
                        System.out.println("Invalid entry");
                }
            }
        }
    }

    private static void printStudentRanks() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tPRINT STUDENT RANKS\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println();
        int[] total = new int[100];
        for (int i = 0; i < available; i++) {
            total[i] = (pfMarks[i] + dbmsMarks[i]);
        }
        int[] Index2 = sort(total);

        double[] average = new double[100];
        for (int i = 0; i < available; i++) {
            average[i] = (pfMarks[i] + dbmsMarks[i]) / 2.0;
        }

        double[] avg = new double[100];
        for (int i = 0; i < available; i++) {
            avg[i] = average[i];
        }
        int[] indexArray = sortAvg(average);
        int numbers = Index3(indexArray);

        System.out.println("+-------+-------+---------------+--------------+-----------+");
        System.out.format("|%-7s|%-7s|%-15s|%-14s|%-11s|\n", "Rank", "ID", "Name", "Total Marks", "Avg. Marks");
        System.out.println("+-------+-------+---------------+--------------+-----------+");
        for (int i = 0; i < available - numbers; i++) {
            if (pfMarks[indexArray[i]] != -1 | dbmsMarks[indexArray[i]] != -1) {
                System.out.format("|%-7d|%-7s|%-15s|%14d|%11.2f|\n", (i + 1), id[indexArray[i]], name[indexArray[i]], (pfMarks[indexArray[i]] + dbmsMarks[indexArray[i]]), avg[indexArray[i]]);
            }
        }
        System.out.println("+-------+-------+---------------+--------------+-----------+");

        System.out.println();
        System.out.print("Do you want to go back to the Main Menu : (Y/N) ");

        String command = input.nextLine();

        switch (command) {
            case "Y":
            case "y":
                homePage();
            case "N":
            case "n":
                printStudentDetails();
            default:
                System.out.println("Invalid entry");
        }

    }

    private static void bestInPF() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        int[] pf = new int[100];
        for (int i = 0; i < available; i++) {
            pf[i] = pfMarks[i];
        }
        int[] arrayIndex = sort(pf);

        System.out.println("+-------+---------------+-----------+-----------+");
        System.out.format("|%-7s|%-15s|%-11s|%-11s|\n", "ID", "Name", "PF Marks", "DBMS Marks");
        System.out.println("+-------+---------------+-----------+-----------+");
        for (int i = 0; i < available - store; i++) {
            System.out.format("|%-7s|%-15s|%-11d|%-11s|\n", id[arrayIndex[i]], name[arrayIndex[i]], pfMarks[arrayIndex[i]], dbmsMarks[arrayIndex[i]]);
        }
        System.out.println("+-------+---------------+-----------+-----------+");

        System.out.println();
        System.out.print("Do you want to go back to the Main Menu : (Y/N) ");
        String command = input.nextLine();
        switch (command) {
            case "Y":
            case "y":
                homePage();
            case "N":
            case "n":
                printStudentDetails();
            default:
                System.out.println("Invalid entry");
        }

    }

    private static void bestInDBMS() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();

        int[] dbms = new int[100];
        for (int i = 0; i < available; i++) {
            dbms[i] = dbmsMarks[i];
        }
        int[] arrayIndex = sort(dbms);

        System.out.println("+-------+---------------+-----------+-----------+");
        System.out.format("|%-7s|%-15s|%-11s|%-11s|\n", "ID", "Name", "DBMS Marks", "PF Marks");
        System.out.println("+-------+---------------+-----------+-----------+");
        for (int i = 0; i < available - store; i++) {
            System.out.format("|%-7s|%-15s|%-11d|%-11s|\n", id[arrayIndex[i]], name[arrayIndex[i]], dbmsMarks[arrayIndex[i]], pfMarks[arrayIndex[i]]);
        }
        System.out.println("+-------+---------------+-----------+-----------+");

        System.out.println();
        System.out.print("Do you want to go back to the Main Menu : (Y/N) ");
        String command = input.next();

        switch (command) {
            case "Y":
            case "y":
                homePage();
            case "N":
            case "n":
                printStudentDetails();
            default:
                System.out.println("Invalid entry");
        }

    }

}



