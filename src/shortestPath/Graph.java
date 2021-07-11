package shortestPath;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    int adjMatrix[][];
    int vertices;

    public void addEdge(int v, int w, int d){
        adjMatrix[v][w] = d;
    }

    public void shortestPath(int source){
        vertices = adjMatrix.length;

        boolean known[] = new boolean[vertices];
        int distance[] = new int[vertices];
        Integer previous[] = new Integer[vertices];

        /*
        Initialise each of the arrays with their starting values.
         */
        for(int i = 0; i < vertices; i++){
            known[i] = false;
            distance[i] = Integer.MAX_VALUE;
            previous[i] = null;
        }
        distance[source] = 0;

        for(int i = 0; i < vertices; i++){
            int smallest = smallestDistance(known, distance);
            known[smallest] = true;

            for (int j = 0; j < vertices; j++){
                if(adjMatrix[smallest][j] > 0){
                    int newD = adjMatrix[smallest][j] + distance[smallest];

                    if(newD < distance[j]){
                        distance[j] = newD;
                        previous[j] = smallest;
                    }
                }
            }
        }
        printInfo(source, distance, previous);
    }

    int smallestDistance(boolean s[], int d[]){
        int min = Integer.MAX_VALUE;
        int vertex = 0;

        for(int i = 0; i < vertices; i++){
            if(s[i]==false && min>d[i]){
                min = d[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public void printInfo(int source, int[] key, Integer[] prev){
        for (int i = 0; i < vertices; i++){
            System.out.print("Shortest path to " + i + ":");
            try {
                printRoute(source, i, prev);
                System.out.println(": cost = " + key[i]);
            }catch (NullPointerException ex){
                System.out.println(" No valid route found");
            }
        }
    }

    public void printRoute(int source, int dest, Integer prev[]){
        ArrayList route = new ArrayList();
        prev[source] = source;
        int j = dest;

        if(j != source){route.add(j);}
        boolean end = false;
        while (end==false) {
            j = prev[j];
            route.add(j);
            if (j != prev[source]) {
            } else {
                end = true;
            }
        }
        Collections.reverse(route);
        route.forEach((n) ->{
            System.out.print(" " + n);
        });

    }

}
