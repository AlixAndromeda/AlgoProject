
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class arrivalTime {

    public static boolean theOutput(String output)
    {
        ArrayList<String> data = dataIntake();
        ArrayList<String> theOutput = paths(output, data);
        Collections.sort(theOutput);

        if (theOutput.isEmpty()) {
            System.out.println("there doesn't exist any routes");
            return false;
        }
        System.out.println(theOutput.size() + "Here you go");

        int i = 0;
        if (i < theOutput.size()) do {
            System.out.println(theOutput.get(i));
            i++;
        } while (i < theOutput.size());
        return true;
    }


    public static ArrayList<String> dataIntake()
    {
        ArrayList<String> dataIntake = new ArrayList<String>();
        SimpleDateFormat theClock = new SimpleDateFormat("HH:mm:ss");
        String maxTime = "24:00:00";
        try
        {
            String temp;
            BufferedReader fileRead = new BufferedReader(new FileReader("stop_times.txt"));
            Date theLimit = theClock.parse(maxTime);
            fileRead.readLine();

            if ((temp = fileRead.readLine()) == null) {
            }
            else
            {
                if (temp.isEmpty()) {
                } else {
                    String[] temp2 = temp.split(",");
                    Date time = theClock.parse(temp2[1]);
                    if (time.getTime() < theLimit.getTime())
                        dataIntake.add(temp);
                }
                if ((temp = fileRead.readLine()) != null) {
                    do {
                        if (!temp.isEmpty()) {
                            String[] temp2 = temp.split(",");
                            Date time = theClock.parse(temp2[1]);
                            if (time.getTime() < theLimit.getTime()) {
                                dataIntake.add(temp);
                            }
                        }
                    } while ((temp = fileRead.readLine()) != null);
                }
            } fileRead.close();
        }  catch (IOException | ParseException e) {
            System.out.println(e);
        } return dataIntake;
    }

    public static ArrayList<String> paths(String stop, ArrayList<String> data) {
        SimpleDateFormat theTime = new SimpleDateFormat("HH:mm:ss");
        ArrayList<String> paths = new ArrayList<String>();
        int i = 0, dataSize = data.size();
        while (i<dataSize) {
            String theData = data.get(i);
            String[] clockSplitter = theData.split(",");
            try {
                Date theClock = theTime.parse(clockSplitter[1]);
                Date clockThe = theTime.parse(stop);
                if (theClock.getTime() == clockThe.getTime()) {
                    paths.add(theData);
                }
            } catch (ParseException e) {
            }
            i++;
        }
        return paths;
    }


}
