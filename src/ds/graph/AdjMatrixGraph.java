package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixGraph extends Graph {

    private final boolean[][] matrix;

    public AdjMatrixGraph(List<Vertex> vertices) {
        super(vertices);
        this.matrix = new boolean[vertices.size()][vertices.size()];
    }

    public void addEdge(Vertex a, Vertex b) {
        this.matrix[vertices.indexOf(a)][vertices.indexOf(b)] = true;
        this.matrix[vertices.indexOf(b)][vertices.indexOf(a)] = true;
    }

    @Override
    public boolean isEdge(Vertex a, Vertex b) {
        return this.matrix[vertices.indexOf(a)][vertices.indexOf(b)] || this.matrix[vertices.indexOf(a)][vertices.indexOf(b)];
    }

    public void removeEdge(Vertex a, Vertex b) {
        this.matrix[vertices.indexOf(a)][vertices.indexOf(b)] = false;
        this.matrix[vertices.indexOf(b)][vertices.indexOf(a)] = false;
    }

    public List<Vertex> getListOfAdjVertices(Vertex v) {
        List<Vertex> result = new ArrayList<>();
        int indexOfVertex = vertices.indexOf(v);
        for (int index = 0; index < vertices.size(); ++index) {
            if (this.matrix[indexOfVertex][index]) {
                result.add(vertices.get(index));
            }
        }
        return result;
    }

    @Override
    public void display() {
        System.out.print("  ");
        for (Vertex v : vertices) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
        for (int index_i = 0; index_i < vertices.size(); ++index_i) {
            System.out.print(vertices.get(index_i).getLabel() + " ");
            for (int index_j = 0; index_j < vertices.size(); ++index_j) {
                System.out.print(this.matrix[index_i][index_j] ?  1 : 0 );
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
