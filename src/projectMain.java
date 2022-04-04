import java.util.Scanner;

public class projectMain {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Simple Welcome
        System.out.println("The following program is designed to help you plan your journey in Vancouver");
        System.out.println("Press any key to continue!");
        scanner.hasNextLine();


        // User input commands



        System.out.println("Please select one of the following options by enetering a number 1,2,3 or 0 to quit.");
        System.out.println("Press '1' Search for a bus stop.");
        System.out.println("Press '2' Find the shortest path between 2 stops.");
        System.out.println("Press '3' Search for all trips with a given arrival time.");
        System.out.println("Press '0' If you would like to quit ");

        int choice;
        choice = scanner.next().charAt(0);
        switch (choice) {
            case '0':
                System.out.println("Thank you for using our program!");
                break;
            case '1':

            case '2':

            case '3':

        }
    }


}