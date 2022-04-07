import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class shortestPath {

    private String stop_times, transfers;
    public double[][] adjacencyMatrix = new double[12479][12479];

    shortestPath(String stop_times, String transfers) {
        this.stop_times = stop_times;
        this.transfers = transfers;
    }

    private void makeAdjacenyMatrix() {

        for (int index = 0; index < adjacencyMatrix.length; index++) {
            for (int count = 0; count < adjacencyMatrix[index].length; count++)
                if (index != count) {
                    adjacencyMatrix[index][count] = Double.NaN;
                }
            else adjacencyMatrix[index][count] = 0;
        }
    }
}
