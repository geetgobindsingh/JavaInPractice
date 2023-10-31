package leetcode.medium;

import ds.graph.AdjListGraph;
import ds.graph.BFS;
import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfConnectedComponentInAnUnDirectedGraph {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');

        vertexList.addAll(Arrays.asList(new Vertex[]{a, b, c, d, e, f, g, h}));

        Graph graph = new AdjListGraph(vertexList);

        graph.addEdge(a, b);
        graph.addEdge(a, c);

        graph.addEdge(b, a);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(b, e);

        graph.addEdge(c, a);
        graph.addEdge(c, b);
        graph.addEdge(c, d);

        graph.addEdge(d, b);
        graph.addEdge(d, c);
        graph.addEdge(d, e);

        graph.addEdge(e, b);
        graph.addEdge(e, d);

        graph.addEdge(f, g);
        graph.addEdge(f, h);

        graph.addEdge(g, f);

        graph.addEdge(h, f);

        graph.display();

        BFS obj = new BFS();
        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                obj.BFS(graph, v);
                System.out.println();
            }
        }
    }
}
