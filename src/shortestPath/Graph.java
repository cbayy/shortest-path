package shortestPath;

public class Graph {

    private int adjMatrix[][];
    int vertices;

    public void addEdge(int v, int w, int d){
        adjMatrix[v][w] = d;
    }

    public void shortestPath(int source){
        vertices = adjMatrix.length;

        boolean known[] = new boolean[vertices];
        int distance[] = new int[vertices];
        int previous[] = new int[vertices];

        /*
        Initialise each of the arrays with their starting values.
         */
        for(int i = 0; i < vertices; i++){
            known[i] = false;
            distance[i] = Integer.MAX_VALUE;
            previous[i] = Integer.parseInt(null);
        }
        distance[source] = 0;

        for(int i = 0; i < vertices; i++){
            int smallest = smallestDistance(known, distance);
            known[smallest] = true;

            for (int j = 0; j < vertices; j++){
                if(adjMatrix[smallest][j] > 0){
                    int newD = adjMatrix[smallest][j] + distance[smallest];

                    if(newD > distance[j]){
                        distance[j] = newD;
                        previous[j] = smallest;
                    }
                }
            }
        }
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

}
