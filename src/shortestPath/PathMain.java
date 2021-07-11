package shortestPath;

import java.util.Scanner;

public class PathMain {

    public static void main(String[] args){

        /*
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] line = input.split(" ");

        int test = Integer.parseInt(line[0]);
         */

        Graph g = new Graph();
        g.adjMatrix = new int[6][6];

        g.addEdge(0,1,18);
        g.addEdge(0,2,12);
        g.addEdge(1,0,22);
        g.addEdge(1,3,6);
        g.addEdge(2,1,16);
        g.addEdge(2,3,14);
        g.addEdge(3,0,31);
        g.addEdge(4,0,31);
        g.addEdge(0,5,2);


        g.shortestPath(0);

        
    }
}
