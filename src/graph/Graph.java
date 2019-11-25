package graph;

public interface Graph {
    //returns the number of vertices
    int getNumVertices(); 
    
    // determine if this is a directed graph
    boolean isDirected(); 
    
   // determine if an edge exists between source and destination
    boolean isEdge(int source, int dest);
    
    void insert(Edge edge);
    
    void remove(Edge edge);
}