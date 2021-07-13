package shortestPath;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GraphPanel extends JPanel {

    int adjMatrix[][];
    final int border = 200;
    int edgePos[][];

    public GraphPanel(){

    }

    public void setAdjMatrix(int[][] adjMatrixNew){
        adjMatrix = adjMatrixNew;
        edgePos = new int[adjMatrix.length][2];
    }


    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        if (adjMatrix != null) {
            for (int i = 0; i < adjMatrix.length; i++) {
                Random rand = new Random();
                int xPos = rand.nextInt(1000);
                int yPos = rand.nextInt(800);
                g2D.fillOval(xPos, yPos, 50, 50);
                g2D.drawString(String.valueOf(i), xPos, yPos);
                edgePos[i][0] = xPos;
                edgePos[i][1] = yPos;

            }
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    if(adjMatrix[i][j] > 0) {
                        g2D.drawLine(edgePos[i][0], edgePos[i][1], edgePos[j][0], edgePos[j][1]);
                    }
                }
            }

        }
    }
}
