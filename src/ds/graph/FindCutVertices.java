package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindCutVertices {
    static int V = 7;
    static int time = 0;
    static Graph graph = null;
    static List<Vertex> vertexList = new ArrayList<>();

    public static void main(String[] args) {
// Create graphs given in above diagrams
        System.out.println("Articulation points in first graph ");

        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');

        vertexList.addAll(Arrays.asList(a, b, c, d, e, f, g));
        graph = new AdjListGraph(vertexList);
        graph.addEdge(a, b);
        graph.addEdge(a, d);
        graph.addEdge(b, a);
        graph.addEdge(b, c);
        graph.addEdge(c, b);
        graph.addEdge(c, d);
        graph.addEdge(c, g);
        graph.addEdge(d, a);
        graph.addEdge(d, c);
        graph.addEdge(d, e);
        graph.addEdge(d, f);
        graph.addEdge(g, c);
        graph.addEdge(e, d);
        graph.addEdge(e, f);
        graph.addEdge(f, d);
        graph.addEdge(f, e);
        AP();
        System.out.println();
    }

    static void AP() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i]) {
                System.out.print(vertexList.get(i).getLabel() + " ");
            }
    }

    static void APUtil(int parentVertexIndex, boolean[] visited, int[] d, int[] l, int[] parentIndexArray, boolean[] ap) {
        int children = 0;
        visited[parentVertexIndex] = true;
        d[parentVertexIndex] = l[parentVertexIndex] = time++;
        List<Vertex> list = graph.getListOfAdjVertices(vertexList.get(parentVertexIndex));
        Iterator<Vertex> iterator = list.iterator();
        while (iterator.hasNext()) {
            Vertex child = iterator.next();
            int childVertexIndex = vertexList.indexOf(child);
            if (!visited[childVertexIndex]) {
                children = children + 1;
                parentIndexArray[childVertexIndex] = parentVertexIndex;
                APUtil(childVertexIndex, visited, d, l, parentIndexArray, ap);

                l[childVertexIndex] = Math.min(l[childVertexIndex], l[parentVertexIndex]);

                // parent and root condition
                if (parentIndexArray[parentVertexIndex] == -1 && children > 1) {
                    ap[parentVertexIndex] = true;
                }
                // back edge condition
                if (parentIndexArray[parentVertexIndex] != -1 && l[children] >= d[parentVertexIndex]) {
                    ap[parentVertexIndex] = true;
                }
            } else if (childVertexIndex != parentIndexArray[parentVertexIndex]) {
                l[parentVertexIndex] = Math.min(l[parentVertexIndex], d[childVertexIndex]);
            }
        }
    }

}
