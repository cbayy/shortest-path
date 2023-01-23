package shortestPath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GraphPanel extends JPanel {

    int adjMatrix[][];
    final int border = 200;
    int edgePos[][];
    boolean painted = false;

    private int selectedNode = 0;

    public GraphPanel(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Coordinates: " + e.getX() + " : " + e.getY());
            }
        });
    }

    public void setAdjMatrix(int[][] adjMatrixNew){
        adjMatrix = adjMatrixNew;
        edgePos = new int[adjMatrix.length][2];
    }

    //Function which draws the graph and the route to the screen
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        if (adjMatrix != null) {
            paintNodes(g, g2D);
            paintEdges(g, g2D);
        }
    }

    private void paintNodes(Graphics g, Graphics2D g2D){
        //Loops through the adjacency matrix, calculates positions on the frame for the nodes of the graph and paints them to screen
        for (int i = 0; i < adjMatrix.length; i++) {
            g.setColor(Color.darkGray);
            int xPos = 0;
            int yPos = 0;
            if(painted==true) {
                Random rand = new Random();
                xPos = rand.nextInt(800);
                yPos = rand.nextInt(600);
            }else{
                xPos = edgePos[i][0];
                yPos = edgePos[i][1];
            }
            g2D.fillOval(xPos, yPos, 50, 50);

            g.setColor(Color.white);
            g2D.drawString(String.valueOf(i), xPos + 20, yPos + 20);
            edgePos[i][0] = xPos;
            edgePos[i][1] = yPos;
        }
    }

    private void paintEdges(Graphics g, Graphics2D g2D){
        //Loops through the adjacency matrix and paints each edge and the weight of each edge
        painted = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if(adjMatrix[i][j] > 0) {
                    g.setColor(Color.red);
                    g2D.drawLine(edgePos[i][0] + 25, edgePos[i][1] + 25, edgePos[j][0] + 25, edgePos[j][1] + 25);
                    g2D.drawString(String.valueOf(adjMatrix[i][j]),(edgePos[i][0] + edgePos[j][0])/2 + 25, (edgePos[i][1] + edgePos[j][1])/2 +25);
                }
            }
        }
    }
}
