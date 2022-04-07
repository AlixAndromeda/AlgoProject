import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class projectMain {
    public static void main(String[] args) {


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
                System.out.println("You have chosen option 1!");
                System.out.println("Please enter the bus stop you are looking, enter 'back' to return to main menu or type quit to quit");
                if (scanner.hasNext()) {
                    String userInput = scanner.next();
                    if (userInput.equalsIgnoreCase("quit")) {
                        System.out.println("Thank you for using our program. Have a safe journey!");
                        break;
                    } else if (userInput.equalsIgnoreCase("back")) {
                        break;
                    } else {
                        TST<Integer> TST = new TST<>();
                        try {
                            FileReader readFile = new FileReader("stops.txt");
                            BufferedReader bufferedReader = new BufferedReader(readFile);
                            boolean fileEnd = false;
                            int i = 0;
                            while (!fileEnd) {
                                String stopLine = bufferedReader.readLine();
                                if (stopLine != null) {
                                    String[] stopData = stopLine.split(",");
                                    String stopID = stopData[0];
                                    String stopCode = stopData[1];
                                    String stopName = stopData[2];
                                    String stopDesc = stopData[4];
                                    String stopLat = stopData[5];
                                    String stopLon = stopData[6];
                                    String zoneID = stopData[7];
                                    String stopURL = stopData[8];
                                    TST.put(stopName, i++);
                                } else {
                                    fileEnd = true;
                                }
                            }
                            bufferedReader.close();
                            readFile.close();
                        } catch (IOException e) {
                        }
                        ArrayList<String> Peepeepoopoo = TST.keysWithPrefix(userInput.toUpperCase());
                        for (int x = 0; x < Peepeepoopoo.size(); x++) {
                            System.out.println(Peepeepoopoo.get(x));
                        }
                    }
                } break;


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
