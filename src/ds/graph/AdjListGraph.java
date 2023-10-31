package ds.graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AdjListGraph extends Graph {

    private final HashMap<Vertex, LinkedList<Vertex>> linkedHashMap;

    public AdjListGraph(List<Vertex> vertices) {
        super(vertices);
        this.linkedHashMap = new HashMap<Vertex, LinkedList<Vertex>>();
    }

    @Override
    public void addEdge(Vertex a, Vertex b) {
        if (!this.linkedHashMap.containsKey(a)) {
            this.linkedHashMap.put(a, new LinkedList<>());
        }

        LinkedList<Vertex> vertexLinkedList = this.linkedHashMap.get(a);
        int indexOfB = vertexLinkedList.indexOf(b);
        if (indexOfB < 0) {
            vertexLinkedList.add(b);
            this.linkedHashMap.put(a, vertexLinkedList);
        }
    }

    @Override
    public  boolean isEdge(Vertex a, Vertex b) {
        if (!this.linkedHashMap.containsKey(a)) {
            this.linkedHashMap.put(a, new LinkedList<>());
        }

        LinkedList<Vertex> vertexLinkedList = this.linkedHashMap.get(a);
        int indexOfB = vertexLinkedList.indexOf(b);
        return indexOfB > -1;
    }

    @Override
    public  void removeEdge(Vertex a, Vertex b) {
        if (!this.linkedHashMap.containsKey(a)) {
            this.linkedHashMap.put(a, new LinkedList<>());
        }

        LinkedList<Vertex> vertexLinkedList = this.linkedHashMap.get(a);
        int indexOfB = vertexLinkedList.indexOf(b);
        if (indexOfB > -1) {
            vertexLinkedList.remove(indexOfB);
            this.linkedHashMap.put(a, vertexLinkedList);
        }
    }

    @Override
    public  List<Vertex> getListOfAdjVertices(Vertex v) {
        LinkedList<Vertex> result = new LinkedList<>();
        if (!this.linkedHashMap.containsKey(v)) {
            this.linkedHashMap.put(v, result);
            return result;
        } else {
            return this.linkedHashMap.get(v);
        }
    }

    @Override
    public  void display() {
        for (Vertex v : vertices) {
            System.out.print(v.getLabel() + " => ");
            if (!this.linkedHashMap.containsKey(v)) {
                this.linkedHashMap.put(v, new LinkedList<>());
            }

            LinkedList<Vertex> vertexLinkedList = this.linkedHashMap.get(v);
            for (Vertex i : vertexLinkedList) {
                System.out.print(i.getLabel() + " => ");
            }
            System.out.print("NILL");
            System.out.println();
        }
    }
}
