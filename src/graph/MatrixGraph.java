package graph;

import java.util.ArrayList;

public class MatrixGraph extends AbstractGraph {
    //entries in matrix are 1.0 or 0.0
    //1.0 indicates an edge.
    //0.0 indicates no edge
    
    private double[][] matrix;
    
    public MatrixGraph(int nV, boolean direct){
        super(nV, direct);
        matrix = new double[nV][nV];
        for (int row = 0; row < nV; row++)
            for (int col = 0; col < nV; col++)
                    matrix[row][col] = 0.0;        
    }

    public boolean isEdge(int source, int dest) {
        //complete this method
        return (matrix[source][dest] == 1.0);
    }

    public void insert(Edge edge) {
        //complete this method
        // if graph is undirected, insert two edges
        // otherwise, insert just one edge
        int source = edge.getSource();
        int dest = edge.getDestination();
        matrix[source][dest] = 1.0;
        if (!isDirected()){
            matrix[dest][source] = 1.0;
        }
    }

    public void remove(Edge edge) {
        //complete this method
        // as for insert method
        int source = edge.getSource();
        int dest = edge.getDestination();
        matrix[source][dest] = 0.0;
        if (!isDirected()){
            matrix[dest][source] = 0.0;
        }
    }

    public ArrayList<Integer> bfs(int startVertex){
        return null;
    }

    public ArrayList<Integer> dfs(int startVertex){
        return null;
    }

    public void breadthFirstTraversal(int start){
	//Output the vertices in breadth first order
    }
    
    public void depthFirstTraversal(int start){
        //Output the vertices in depth first order
    }    
}
