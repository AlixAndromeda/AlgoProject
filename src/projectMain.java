import java.util.Scanner;

public class projectMain {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Simple Welcome

        System.out.println("The following program is designed to help you plan your journey in Vancouver");
        System.out.println("Press any key to continue!");
        scanner.hasNextLine();

        // User input commands
        System.out.println("Please select one of the following options by enetering a number 1,2,3 or 0 to quit. " +
        "\nPress '1' Search for a bus stop. " +
        "\nPress '2' Find the shortest path between 2 stops. " +
        "\nPress '3' Search for all trips with a given arrival time. " +
        "\nPress '0' If you would like to quit.");

        int choice;
        choice = scanner.next().charAt(0);
        switch (choice) {

            //User quits
            case '0':
                System.out.println("Thank you for using our program. Have a safe journey!");
                break;


            //User chooses option 1
            case '1':
                boolean number1 = true;
                System.out.println("You have chosen option 1!");
                System.out.println("Please enter the bus stop you are looking, enter 'back' to return to main menu or press 0 to quit");
                if (scanner.hasNextLine()) {
                    String busStops = scanner.nextLine();
                    String userInput = scanner.nextLine();
                    if (userInput == ("0")) {
                        number1 = false;
                        System.out.println("Thank you for using our program. Have a safe journey!");
                        break;
                    } else if (userInput.equalsIgnoreCase("back")) {
                        System.out.println("Press '1' Search for a bus stop.");
                        System.out.println("Press '2' Find the shortest path between 2 stops.");
                        System.out.println("Press '3' Search for all trips with a given arrival time.");
                        System.out.println("Press '0' If you would like to quit ");
                        number1 = false;
                    } else if (busStops.length() != 2) {
                        System.out.println("ERROR! Please enter two stops");
                    } else if (busStops.length() == 2) {
                    }
                }

            //User chooses option 2
            case '2':

            //User chooses option 3
            case '3':
                scanner.nextLine();
                boolean number3 = true;
                System.out.println("You have chosen option 3!");
                System.out.println("Please enter the arrival time you wish to search for!" + "\nPlease note that this has to be in" +
                        " the format HH:MM:SS. Enter 'Back' to go back to the main menu or press '0' to quit");

        }
    }


}