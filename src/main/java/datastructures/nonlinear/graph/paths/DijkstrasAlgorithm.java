package datastructures.nonlinear.graph.paths;

import java.util.*;

public class DijkstrasAlgorithm {

  public void shortesPath(Graph graph, Graph.Vertex startNode) {
    // Total Costs
    Map<String, Integer> totalCosts = new HashMap<>();
    Map<String, String> previousNode = new HashMap<>();
    MinVertexPriorityQueue minQueue = new MinVertexPriorityQueue(graph.vertices.size());
    Set<String> visited = new HashSet<>();

    // Initial node
    totalCosts.put(startNode.name, 0);
    minQueue.push(startNode);

    // Initialize costs for all nodes to Infinity.
    for (Graph.Vertex vertex : graph.vertices.keySet()) {
      if (!vertex.name.equals(startNode.name)) {
        totalCosts.put(vertex.name, Integer.MAX_VALUE);
      }
    }

    while (!minQueue.isEmpty()) {
      Graph.Vertex newSmallest = minQueue.poll();
      visited.add(newSmallest.name);

      List<Graph.Vertex> adjacentVertices = graph.vertices.get(newSmallest);

      for (Graph.Vertex adjacent : adjacentVertices) {
        if (!visited.contains(adjacent.name)) {
          int newDistance = newSmallest.weight + adjacent.weight;
          if (newDistance < totalCosts.get(adjacent.name)) {
            totalCosts.put(adjacent.name, newDistance);
            previousNode.put(adjacent.name, newSmallest.name);
            adjacent.weight = newDistance;
            minQueue.push(adjacent);
          }
        }
      }
    }

    // Print total cost:
    totalCosts.forEach((k, v) -> {
      System.out.println(k + " = " + v);
    });
  }

  public static void main(String... args) {
    DijkstrasAlgorithm algorithm = new DijkstrasAlgorithm();

    Graph graph = new Graph();
    graph.addVertex("sf",
        Arrays.asList(new Graph.Vertex("seattle", 3), new Graph.Vertex("idaho", 5)));
    graph.addVertex("seattle", Arrays
        .asList(new Graph.Vertex("sf", 3), new Graph.Vertex("idaho", 1),
            new Graph.Vertex("chicago", 2)));
    graph.addVertex("chicago", Arrays
        .asList(new Graph.Vertex("idaho", 3), new Graph.Vertex("seattle", 2),
            new Graph.Vertex("nyc", 4)));
    graph.addVertex("idaho", Arrays
        .asList(new Graph.Vertex("sf", 5), new Graph.Vertex("seattle", 1),
            new Graph.Vertex("nyc", 6), new Graph.Vertex("chicago", 3)));
    graph.addVertex("nyc",
        Arrays.asList(new Graph.Vertex("idaho", 3), new Graph.Vertex("chicago", 4)));

    algorithm.shortesPath(graph, new Graph.Vertex("sf", 0));
  }
}
