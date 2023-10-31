package ds.graph;

import java.util.*;

public class TopologicalSorting {
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

//        graph.addEdge(a, c);
//        graph.addEdge(b, c);
//
//        graph.addEdge(c, d);
//        graph.addEdge(c, e);
//
//        graph.addEdge(d, f);
//        graph.addEdge(e, f);
//
//        graph.addEdge(f, a);
        graph.addEdge(a, c);
        graph.addEdge(a, d);
        graph.addEdge(b, d);
        graph.addEdge(b, e);
        graph.addEdge(c, f);
        graph.addEdge(f, e);

        graph.display();

        TopologicalSorting topologicalSorting = new TopologicalSorting();
        topologicalSorting.sort(graph);
        System.out.println();
        DFS obj = new DFS();
        for (Vertex v : graph.vertices) {
            if (!v.isVisited()) {
                obj.DFS(graph, v);
            }
        }
    }

    private void sort(Graph graph) {
        int[] inDegrees = new int[graph.vertices.size()];
        for (Vertex v : graph.vertices) {
            List<Vertex> adjList = graph.getListOfAdjVertices(v);
            for (Vertex in : adjList) {
                inDegrees[graph.vertices.indexOf(in)]++;
            }
        }

        Queue<Vertex> queue = new PriorityQueue<>();
        int counter = 0;

        for (int index = 0; index < inDegrees.length; ++index) {
            if (inDegrees[index] == 0) {
                queue.add(graph.vertices.get(index));
            }
        }

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            counter++;
            System.out.print(v.getLabel() + " ");
            List<Vertex> adjList = graph.getListOfAdjVertices(v);
            for (Vertex in : adjList) {
                inDegrees[graph.vertices.indexOf(in)]--;
                if (inDegrees[graph.vertices.indexOf(in)] == 0) {
                    queue.add(in);
                }
            }
        }

        if (counter != graph.vertices.size()) {
            System.out.println("There is a Cycle in this graph.");
        }

    }
}
