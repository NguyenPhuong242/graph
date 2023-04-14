import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        try {
            File file = new File("graph.txt");
            Scanner scanner = new Scanner(file);
            int Nodes = scanner.nextInt();
            List<List<Way>> adjList = new ArrayList<>();
            for (int i = 0; i < Nodes; i++) {
                adjList.add(new ArrayList<>());
            }
    
            while (scanner.hasNextInt()) {
                int depart = scanner.nextInt();
                int arrive = scanner.nextInt();
                int distance = scanner.nextInt();
                adjList.get(depart).add(new Way(depart, arrive, distance));
            }
    
            int start = 0;
            int stop = 1;
            List<Integer> shortestDistance = Graph.MinGraph(start, stop, adjList);
            List<List<Integer>> allWays = Graph.totalway(start, stop, adjList);
            System.out.println(shortestDistance);
            System.out.println("---------------");
            System.out.println(allWays);
    
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
    }
}
