import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class shortestPath {

    private String stop_times, transfers;
    public double[][] adjacencyMatrix = new double[12479][12479];

    shortestPath (String stop_times, String transfers) {
        this.stop_times = stop_times;
        this.transfers = transfers;
    }
}

