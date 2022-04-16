import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class projectMain {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        // Simple Welcome

        System.out.println("The following program is designed to help you plan your journey in Vancouver");
        System.out.println("Press any key to continue!");
        scanner.hasNextLine();

        // User input commands
        System.out.println("Please select one of the following options by entering a number 1,2,3 or 0 to quit. " +
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
                        TST<Integer> TSTArray = new TST<>();
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
                                    TSTArray.put(stopName, i++);
                                } else {
                                    fileEnd = true;
                                }
                            }
                            bufferedReader.close();
                            readFile.close();
                        } catch (IOException e) {
                        }
                        boolean found = false;
                        ArrayList<String> anythingelse = TSTArray.keysWithPrefix(userInput.toUpperCase());
                        System.out.println("We found the following matches for your search:");
                        for (int x = 0; x < anythingelse.size(); x++)
                            System.out.println(anythingelse.get(x));
                    }
                }
                break;


            //User chooses option 2
            case '2':


                //User chooses option 3
            case '3':
                System.out.print("You have chosen option 3!" + "\n" + "Please enter your desired arrival time, note that this has to be entered in the format HH:MM:SS");
                DateFormat userTimeInput = new SimpleDateFormat("HH:MM:SS");
                boolean userChoice = false;
                Scanner userInput = new Scanner(System.in);
                if (!userChoice) {
                    String userTimeChosen = userInput.nextLine();
                    try {
                        userTimeInput.parse(userTimeChosen);
                        if (arrivalTime.theOutput(userTimeChosen))
                        userChoice = true;
                    } catch (ParseException e) {
                        System.out.println("You have entered an incorrect format, please make sure you use the HH:MM:SS format");
                    }
                }
                userInput.close();
        }
    }
}



