package shortestPath;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GraphPanel extends JPanel {

    int adjMatrix[][];
    final int border = 200;
    int edgePos[][];
    boolean painted = false;

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
                g.setColor(Color.darkGray);
                int xPos = 0;
                int yPos = 0;
                if(painted==false) {
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
            painted = true;
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    if(adjMatrix[i][j] > 0) {
                        g.setColor(Color.red);
                        g2D.drawLine(edgePos[i][0] + 25, edgePos[i][1] + 25, edgePos[j][0] + 25, edgePos[j][1] + 25);
                        g2D.drawString(String.valueOf(adjMatrix[i][j] + 25),(edgePos[i][0] + edgePos[j][0])/2 + 25, (edgePos[i][1] + edgePos[j][1])/2 +25);
                    }
                }
            }

        }
    }
}
