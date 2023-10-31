package leetcode.hard;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary obj = new ReconstructItinerary();
        displayList(obj.findItinerary(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        ))); //"JFK","MUC","LHR","SFO","SJC"
//        displayList(obj.findItinerary(Arrays.asList(
//                Arrays.asList("JFK", "SFO"),
//                Arrays.asList("JFK", "ATL"),
//                Arrays.asList("SFO", "ATL"),
//                Arrays.asList("ATL", "JFK"),
//                Arrays.asList("ATL", "SFO")
//        ))); //"JFK","ATL","JFK","SFO","ATL","SFO"
//        displayList(obj.findItinerary(Arrays.asList(
//                Arrays.asList("JFK", "KUL"),
//                Arrays.asList("JFK", "NRT"),
//                Arrays.asList("NRT", "JFK")
//        ))); //"JFK","NRT","JFK","KUL"
    }

    private static void displayList(List<String> itinerary) {
        for (String d : itinerary) {
            System.out.print(d + " ");
        }
        System.out.print("\n");
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        displayList(findItinerary2(tickets));
        LinkedList<String> ans = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();

        for (final List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs(graph, "JFK", ans);
        return ans;
    }

    private void dfs(Map<String, Queue<String>> graph, final String u, LinkedList<String> ans) {
        final Queue<String> arrivals = graph.get(u);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(graph, arrivals.poll(), ans);
        }
        ans.addFirst(u);
    }

    public List<String> findItinerary2(List<List<String>> tickets) { // wrong sol
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String s = ticket.get(0);
            String d = ticket.get(1);
            graph.putIfAbsent(s, new PriorityQueue<>());
            graph.get(s).offer(d);
        }

        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer("JFK");
        while (q.size() > 0) {
            String node = q.poll();
            result.add(node);
            if (graph.get(node) == null || graph.get(node).isEmpty()) {
                // do nothing
            } else {
                while (!graph.get(node).isEmpty() && (graph.get(graph.get(node).peek()) == null || graph.get(graph.get(node).peek()).isEmpty())) {
                    q.offer(graph.get(node).poll());
                }
                if (!graph.get(node).isEmpty()) {
                    q.offer(graph.get(node).poll());
                }
            }
        }
        return result;
    }
}
