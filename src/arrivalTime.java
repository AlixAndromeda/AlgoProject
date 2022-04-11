
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class arrivalTime {

    public static boolean theOutput(String output)
    {
        ArrayList<String> data = dataIntake();

    }
    public static ArrayList<String> dataIntake() {
        String maxTime = "24:00:00";
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:MM:SS");
        ArrayList<String> dataIntake = new ArrayList<String>();

        try {
            FileReader readFile = new FileReader("stop_times.txt");
            BufferedReader bufferedReader = new BufferedReader(readFile);
            boolean fileEnd = false;
            int i = 0;
            while (!fileEnd) {
                String stopTime = bufferedReader.readLine();
                if (stopTime != null) {
                    String[] stopData = stopTime.split(",");
                    Date theClock = timeFormat.parse(stopData[1]);
                }
            }

            bufferedReader.close();
            readFile.close();
        } catch (IOException | ParseException e) {
        }
    }
    public static ArrayList<String> paths(String stop, ArrayList<String> data){


        SimpleDateFormat theTime = new SimpleDateFormat("HH:MM:SS");
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
