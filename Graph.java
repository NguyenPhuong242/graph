import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class Graph {

    List<List<Way>> totalWay;
    List<Integer> ListDistances;

    public Graph(List<List<Way>> totalWay, List<Integer> ListDistances){
        this.totalWay = totalWay;
        this.ListDistances = ListDistances;

    }

    public static List<List<Integer>> totalway(int start, int stop, List<List<Way>> adjList) {
        List<List<Integer>> Ways = new ArrayList<>();
        List<Integer> currentWay = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        totalwayHelper(start, stop, adjList, visited, currentWay, Ways);
        return Ways;
    }

    public static List<Integer> MinGraph(int start, int stop, List<List<Way>> adjList) {
        PriorityQueue<Way> pq = new PriorityQueue<>((a, b) -> a.getDistance() - b.getDistance());
        int[] distance = new int[adjList.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] previous = new int[adjList.size()];
        Arrays.fill(previous, -1);
        boolean[] visited = new boolean[adjList.size()];
    
        distance[start] = 0;
        pq.offer(new Way(start, start, 0));
    
        while (!pq.isEmpty()) {
            Way current = pq.poll();
    
            if (visited[current.getArrive()]) {
                continue;
            }
    
            visited[current.getArrive()] = true;
            distance[current.getArrive()] = current.getDistance();
    
            for (Way neighbor : adjList.get(current.getArrive())) {
                if (!visited[neighbor.getArrive()]) {
                    int newDistance = current.getDistance() + neighbor.getDistance();
                    if (newDistance < distance[neighbor.getArrive()]) {
                        pq.offer(new Way(current.getArrive(), neighbor.getArrive(), newDistance));
                        distance[neighbor.getArrive()] = newDistance;
                        previous[neighbor.getArrive()] = current.getArrive();
                    }
                }
            }
        }
    
        System.out.println("Min distance: "+ distance[stop]);
       
        List<Integer> Ways = new ArrayList<>();
        int node = stop;
        while (node != start) {
            Ways.add(node);
            node = previous[node];
            if (node == -1) {
                System.out.println("There is no path from " + start + " to " + stop);
                return new ArrayList<>();
            }
        }
        Ways.add(start);
        Collections.reverse(Ways);
        return Ways;
    }
    //possible for less ways
    private static void totalwayHelper(int current, int stop, List<List<Way>> adjList, boolean[] visited, List<Integer> currentWay, List<List<Integer>> Ways) {
        visited[current] = true;
        currentWay.add(current);
    
        if (current == stop) {
            Ways.add(new ArrayList<>(currentWay));
        } else {
            for (Way neighbor : adjList.get(current)) {
                if (!visited[neighbor.getArrive()]) {
                    totalwayHelper(neighbor.getArrive(), stop, adjList, visited, currentWay, Ways);
                }
            }
        }
    
        currentWay.remove(currentWay.size() - 1);
        visited[current] = false;
    }

}
