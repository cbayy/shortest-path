package shortestPath;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {

    int adjMatrix[][];

    public GraphPanel(){

    }

    public void setAdjMatrix(int[][] adjMatrixNew){
        adjMatrix = adjMatrixNew;
    }


    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        if (adjMatrix != null) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for(int j = 0; j < adjMatrix.length; j++) {
                    g2D.fillOval(i * 200, j* 50, 50, 50);
                    g2D.drawString(String.valueOf(i), i * 200, 50);
                }
            }
        }
    }
}
