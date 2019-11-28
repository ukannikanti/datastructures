package datastructures.nonlinear.graph.paths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordAlgorithm {

  public void shortesPath(List<Edge> edges, int numberOfvertices, int start) {
    Map<Integer, Integer> totalCosts = new HashMap<>();
    totalCosts.put(start, 0);

    for (int i = 2; i <= numberOfvertices; i++) {
      totalCosts.put(i, Integer.MAX_VALUE);
    }

    // relax edges repeatedly
    for (int j = 1; j < numberOfvertices; j++) {
      for (int i = 0; i < edges.size(); i++) {
        Edge edge = edges.get(i);

        int sourceCost = totalCosts.get(edge.source);
        int newCost = sourceCost + edge.weight;

        if (newCost < totalCosts.get(edge.destination)) {
          totalCosts.put(edge.destination, newCost);
        }
      }
    }

    //  check for negative-weight cycles

    for (int i = 0; i < edges.size(); i++) {
      Edge edge = edges.get(i);

      int sourceCost = totalCosts.get(edge.source);
      int newCost = sourceCost + edge.weight;

      if (newCost < totalCosts.get(edge.destination)) {
        System.out.println("Negative edges found!!");
      }
    }


    totalCosts.forEach((k, v) -> {
      System.out.println(k + "=" + v);
    });
  }

  static class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
      this.destination = destination;
      this.source = source;
      this.weight = weight;
    }
  }

  public static void main(String... args) {
    BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm();

    // 1
    Edge edge1 = new Edge(1, 2, 6);
    Edge edge11 = new Edge(1, 3, 5);
    Edge edge12 = new Edge(1, 4, 5);

    // 2
    Edge edge2 = new Edge(2, 5, -1);

    // 3
    Edge edge3 = new Edge(3, 2, -2);
    Edge edge31 = new Edge(3, 5, 1);

    //4
    Edge edge4 = new Edge(4, 3, -2);
    Edge edge41 = new Edge(4, 6, -1);

    //5
    Edge edge5 = new Edge(5, 7, 3);

    //6
    Edge edge6 = new Edge(6, 7, 3);

    List<Edge> edges =
        Arrays.asList(edge1, edge11, edge12, edge2, edge3, edge31, edge4, edge41, edge5, edge6);

    //algorithm.shortesPath(edges, 7, 1);


    // Negative edges cycle test
    Edge n1 = new Edge(1, 2, 4);
    Edge n11 = new Edge(1, 4, 5);

    Edge n2 = new Edge(2, 4, 5);

    Edge n3 = new Edge(3, 2, -10);

    Edge n4 = new Edge(4, 3, 3);

    List<Edge> negativeEdgesCycle =
        Arrays.asList(n1, n11, n2, n3, n4);

    algorithm.shortesPath(negativeEdgesCycle, 4, 1);
  }
}
