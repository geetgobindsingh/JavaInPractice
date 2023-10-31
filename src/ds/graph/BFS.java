package ds.graph;

import java.util.*;

public class BFS {

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

        BFS obj = new BFS();
//        obj.BFS(graph, b);
        System.out.print(obj.BFS(graph, a, f));
    }

    public boolean BFS(Graph g, Vertex start) {
        if (start.isVisited()) {
            return true;
        }
        Queue<Vertex> queue = new PriorityQueue<>();
        start.setVisited(true);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.getLabel() + " ");
            List<Vertex> adjList = g.getListOfAdjVertices(v);
            for (Vertex adjV : adjList) {
                if (!adjV.isVisited()) {
                    adjV.setVisited(true);
                    queue.add(adjV);
                }
            }
        }
        return true;
    }

    public boolean BFS(Graph g, Vertex start, Vertex end) {
        Queue<Vertex> queue = new PriorityQueue<>();
        start.setVisited(true);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.getLabel() + " ");
            List<Vertex> adjList = g.getListOfAdjVertices(v);
            for (Vertex adjV : adjList) {
                if (!adjV.isVisited()) {
                    if (adjV.getLabel() == end.getLabel()) {
                        System.out.print(adjV.getLabel() + " ");
                        return true;
                    }
                    adjV.setVisited(true);
                    queue.add(adjV);
                }
            }
        }
        return false;
    }
}
