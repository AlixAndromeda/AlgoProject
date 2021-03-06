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

        System.out.println("----------------------------------------------------------------------------" +
                "\nThe following program is designed to help you plan your journey in Vancouver" + "\n----------------------------------------------------------------------------"
        );
        System.out.println("Press any key to continue!");
        scanner.hasNextLine();

        // User input commands
        System.out.println("Please select one of the following options by entering a number 1,2,3 or 0 to quit. " +
                "\nPress '1' Search for a bus stop. " +
                "\nPress '2' Find the shortest path between 2 stops. " +
                "\nPress '3' Search for all trips with a given arrival time. " +
                "\nPress '0' If you would like to quit.");

        boolean theChoice = false;

        int choice;
        choice = scanner.next().charAt(0);
        switch (choice) {

            //User quits
            case '0':
                theChoice = true;
                System.out.println("Thank you for using our program. Have a safe journey!");
                break;

            //User chooses option 1
            case '1':
                theChoice = true;
                System.out.println("You have chosen option 1!");
                System.out.println("Please enter the bus stop you are looking, or type quit to quit");
                if (scanner.hasNext()) {
                    String userInput = scanner.next();
                    if (userInput.equalsIgnoreCase("quit")) {
                        System.out.println("Thank you for using our program. Have a safe journey!");
                        break;
                    } else {
                        TST<Integer> TSTArray = new TST<>(); //Initializing Array
                        try {
                            FileReader readFile = new FileReader("stops.txt"); // Reading File
                            BufferedReader bufferedReader = new BufferedReader(readFile);
                            boolean fileEnd = false;
                            int i = 0;
                            while (!fileEnd) {
                                String stopLine = bufferedReader.readLine();
                                if (stopLine != null) {
                                    String[] stopData = stopLine.split(","); //Splitting the headings
                                    String stopID = stopData[0];
                                    String stopCode = stopData[1];
                                    String stopName = stopData[2];
                                    String stopDesc = stopData[3];
                                    String stopLat = stopData[4];
                                    String stopLon = stopData[5];
                                    String zoneID = stopData[6];
                                    String stopURL = stopData[7];

                                    StringBuilder theString = new StringBuilder();
                                    theString.append(stopData[2]);
                                    if (theString.substring(0, 2).equals("WB") || theString.substring(0, 2).equals("SB") ||
                                            theString.substring(0, 2).equals("NB") || theString.substring(0, 2).equals("EB")) {

                                        String string = theString.substring(0, 2);
                                        theString.delete(0, 3);
                                        theString.append(" ").append(string);
                                    }
                                    String nameOfStop;
                                    nameOfStop = theString.toString();

                                    TSTArray.place(nameOfStop, i++);
                                } else {
                                    fileEnd = true;
                                }
                            }
                            bufferedReader.close();
                            readFile.close();
                        } catch (IOException e) {
                        }

                            ArrayList<String> matches = TSTArray.keysWithPrefix(userInput.toUpperCase());
                            for (int x = 0; x < matches.size(); x++)
                                System.out.println(matches.get(x)); //outputting the info
                            if (matches.isEmpty()) {
                                System.out.println("Sorry we found no matches");

                            }
                            System.out.println("Have a safe journey!");
                        }
                    }

                break;


            //User chooses option 2
            case '2':
                System.out.println("This part of the app is still in progress!");
                break;

            default:
                System.out.println("Sorry you need to enter 0,1,2,3. Please try again");
                break;

                //User chooses option 3
            case '3':
                theChoice = true;
                System.out.print("You have chosen option 3!" + "\n" + "Please enter your desired arrival time, note that this has to be entered in the format HH:MM:SS");
                System.out.println("Or type 'quit' to exit the program");
                DateFormat userTimeInput = new SimpleDateFormat("HH:MM:SS");
                boolean userChoice = false;
                Scanner userInput = new Scanner(System.in);

                while (!userChoice) {
                    String userTimeChosen = userInput.nextLine();
                        try {
                            userTimeInput.parse(userTimeChosen);
                            if (arrivalTime.theResult(userTimeChosen))
                                userChoice = true;
                        } catch (ParseException e) {
                            System.out.println("You have entered an incorrect format, please make sure you use the HH:MM:SS format");
                            userChoice = false; //Error handling
                        }
                    }
                    userInput.close();
                }
        }
    }

