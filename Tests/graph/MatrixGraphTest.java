package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixGraphTest {

    @Test
    void bfs() {
        MatrixGraph graph = new MatrixGraph(6, true);

        graph.insert(new Edge(0,1));
        graph.insert(new Edge(0,3));
        graph.insert(new Edge(1,2));
        graph.insert(new Edge(1,4));
        graph.insert(new Edge(3,6));
        graph.insert(new Edge(6,5));

        List<Integer> vertexList = graph.bfs(0);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(5);

        assertEquals(expectedList,vertexList);
    }

    @Test
    void dfs() {
        MatrixGraph graph = new MatrixGraph(6, true);

        graph.insert(new Edge(0,1));
        graph.insert(new Edge(0,3));
        graph.insert(new Edge(1,2));
        graph.insert(new Edge(1,4));
        graph.insert(new Edge(3,6));
        graph.insert(new Edge(6,5));

        List<Integer> vertexList = graph.bfs(0);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(3);
        expectedList.add(6);
        expectedList.add(5);

        assertEquals(expectedList,vertexList);
    }
}