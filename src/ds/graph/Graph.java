package ds.graph;

import java.util.List;

public abstract class Graph {
    protected final List<Vertex> vertices;

    protected Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public abstract void addEdge(Vertex a, Vertex b);

    public  abstract boolean isEdge(Vertex a, Vertex b);

    public  abstract void removeEdge(Vertex a, Vertex b);

    public  abstract List<Vertex> getListOfAdjVertices(Vertex v);

    public  abstract void display();
}
