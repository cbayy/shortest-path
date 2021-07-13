package shortestPath;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PathMain {

    private final JFrame frame;
    private final GraphPanel gpPanel;

    public static void main(String[] args){

        /*
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] line = input.split(" ");

        int test = Integer.parseInt(line[0]);
         */


        PathMain pm = new PathMain();
        pm.run();
    }

    public PathMain(){
        frame = new JFrame("Graph Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,800);
        gpPanel = new GraphPanel();
        frame.add(gpPanel);
        frame.setVisible(true);
    }


    public void run(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();

        /*
        while(true){
            String text = in.nextLine();
            if(text.equals("stop")){
                break;
            }

            input.add(text);
        }

         */
        Graph g = new Graph();
        g.adjMatrix = new int[6][6];
        /*
        for(String s: input){
            String[] line = s.split(" ");
            int v = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            g.addEdge(v,w,d);
        }


         */
        g.addEdge(0,1,18);
        g.addEdge(0,2,12);
        g.addEdge(1,0,22);
        g.addEdge(1,3,6);
        g.addEdge(2,1,16);
        g.addEdge(2,3,14);
        g.addEdge(3,0,31);
        g.addEdge(4,0,31);
        g.addEdge(0,5,2);

        System.out.println(g.adjMatrix.length);
        g.shortestPath(0);
        gpPanel.setAdjMatrix(g.adjMatrix);
        System.out.println(g.adjMatrix.length);
        frame.repaint();
        gpPanel.repaint();
    }
}
