package practice;

import java.util.*;
import java.io.*;

public class dfs {

	// Assuming directed graphs
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		graph.add(list);
		list = new ArrayList<>();
		list.add(3);
		list.add(4);
		graph.add(list);
		graph.add(new ArrayList<>());
		graph.add(new ArrayList<>());
		graph.add(new ArrayList<>());

		dfs(graph);
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph) {
		boolean[] visited = new boolean[graph.size()];
		dfsUtil(graph, 0, visited);
	}

	public static void dfsUtil(ArrayList<ArrayList<Integer>> graph,
	 int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (Integer u : graph.get(v)) {
			if (!visited[u]) {
				dfsUtil(graph, u, visited);
			}
		}
	}
}





