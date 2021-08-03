package shortestPath;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PathMain {

    private final JFrame frame;
    private final GraphPanel gpPanel;
    private final JPanel txtPanel;

    public static void main(String[] args){
        PathMain pm = new PathMain();
        pm.run();
    }

    public PathMain(){
        frame = new JFrame("Graph Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(new BorderLayout());
        gpPanel = new GraphPanel();
        txtPanel = new JPanel();
        frame.add(gpPanel, BorderLayout.CENTER);
        frame.add(txtPanel, BorderLayout.EAST);
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
        JTextArea textArea = new JTextArea();
        Graph g = new Graph(textArea);
        g.adjMatrix = new int[10][10];

        grid(g);
        /*
        for(String s: input){
            String[] line = s.split(" ");
            int v = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            g.addEdge(v,w,d);
        }



        g.addEdge(0,1,18);
        g.addEdge(0,2,12);
        g.addEdge(1,3,6);
        g.addEdge(2,1,16);
        g.addEdge(2,3,14);
        g.addEdge(3,0,31);
        g.addEdge(4,0,31);
        g.addEdge(0,5,2);
        */
        System.out.println(g.adjMatrix.length);
        g.shortestPath(0);
        gpPanel.setAdjMatrix(g.adjMatrix);
        System.out.println(g.adjMatrix.length);
        frame.repaint();
        gpPanel.repaint();

        txtPanel.add(textArea);

        SwingUtilities.updateComponentTreeUI(frame);
    }


    public void grid(Graph g){
        int ROW = 10;
        int COL = 10;

        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                if((row > 0) && (row < ROW-1) && (col > 0) && (col < COL-1)){
                    System.out.println("Making edge between " + row + " and " + col);
                    g.addEdge(row, col, 1);

                    g.addEdge(row-1, col, 1);
                    g.addEdge(row+1, col, 1);
                    g.addEdge(row, col+1, 1);
                    g.addEdge(row, col-1, 1);
                }
            }
        }
    }
}
