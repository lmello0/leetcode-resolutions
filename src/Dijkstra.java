import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<String, Integer> distances = new HashMap<>();

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        minHeap.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!minHeap.isEmpty()) {
            Map.Entry<String, Integer> current = minHeap.poll();

            String currentNode = current.getKey();
            int currentDistance = current.getValue();

            if (currentDistance > distances.get(currentNode)) {
                continue;
            }

            Map<String, Integer> neighbours = graph.get(currentNode);

            if (neighbours != null) {
                for (Map.Entry<String, Integer> neighbour : neighbours.entrySet()) {
                    String neighbourNode = neighbour.getKey();

                    int weight = neighbour.getValue();
                    int newDistance = currentDistance + weight;

                    if (newDistance < distances.get(neighbourNode)) {
                        distances.put(neighbourNode, newDistance);
                        minHeap.add(new AbstractMap.SimpleEntry<>(neighbourNode, newDistance));
                    }
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        graph.put("A", Map.of("B", 1, "C", 4));
        graph.put("B", Map.of("A", 1, "C", 2, "D", 5));
        graph.put("C", Map.of("A", 4, "B", 2, "D", 1));
        graph.put("D", Map.of("B", 5, "C", 1));

        Map<String, Integer> distances = dijkstra(graph, "A");

        System.out.println(distances);
    }
}
