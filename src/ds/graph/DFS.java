package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');

        vertexList.addAll(Arrays.asList(new Vertex[]{a, b, c, d, e, f}));

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

        graph.display();

        DFS obj = new DFS();
        obj.DFS(graph, a);
//        System.out.println(obj.DFS(graph, a, b));
    }

    public boolean DFS(Graph g, Vertex start) {
        start.setVisited(true);
        System.out.print(start.getLabel() + " ");
        List<Vertex> adjList = g.getListOfAdjVertices(start);
        for (Vertex adjV : adjList) {
            if (!adjV.isVisited()) {
                return DFS(g, adjV);
            }
        }
        return true;
    }

    public boolean DFS(Graph g, Vertex start, Vertex end) {
        start.setVisited(true);
        if (end.isVisited()) {
            return true;
        }
        System.out.print(start.getLabel() + " ");
        List<Vertex> adjList = g.getListOfAdjVertices(start);
        for (Vertex adjV : adjList) {
            if (!adjV.isVisited()) {
                return DFS(g, adjV, end);
            }
        }
        return false;
    }
}
