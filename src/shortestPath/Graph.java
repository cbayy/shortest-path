package shortestPath;

public class Graph {

    private int adjMatrix[][];
    int vertices;

    public void addEdge(int v, int w, int d){
        adjMatrix[v][w] = d;
    }

}
