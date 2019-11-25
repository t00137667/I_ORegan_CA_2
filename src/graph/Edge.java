package graph;

public class Edge {
    private int source;
    private int destination;
    
    public Edge(int s, int d){
        source = s;
        destination = d;        
    }
    
    public int getSource(){
        return source;
    }
    
    public int getDestination(){
        return destination;
    }
}
