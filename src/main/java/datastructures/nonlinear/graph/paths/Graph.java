package datastructures.nonlinear.graph.paths;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  Map<Vertex, List<Vertex>> vertices = new HashMap<>();

  public void addVertex(String vertexName, List<Vertex> adjacentVertices) {
    vertices.put(new Vertex(vertexName, 0), adjacentVertices);
  }

  static class Vertex {
    String name;
    int weight;

    public Vertex(String name, int weight) {
      this.name = name;
      this.weight = weight;
    }

    public String getName() {
      return name;
    }

    public int getWeight() {
      return weight;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;

      if (obj == null || obj.getClass() != this.getClass())
        return false;

      // type casting of the argument.
      Vertex vertex = (Vertex) obj;

      return (vertex.name.equals(this.name));
    }

    @Override
    public int hashCode() {
      return this.name.hashCode();
    }
  }

  public void printGraph() {
    vertices.forEach((k, v) -> {
      System.out.println(k + " is connected to -> ");
      v.stream().forEach(value -> System.out.print(value.name + ":" + value.weight + ",  "));
      System.out.println("");
    });
  }

  public static void main(String... args) {
    Graph graph = new Graph();
    graph.addVertex("sf", Arrays.asList(new Vertex("seattle", 3), new Vertex("idaho", 5)));
    graph.addVertex("seattle",
        Arrays.asList(new Vertex("sf", 3), new Vertex("idaho", 1), new Vertex("chicago", 2)));
    graph.addVertex("chicago",
        Arrays.asList(new Vertex("idaho", 3), new Vertex("seattle", 2), new Vertex("nyc", 4)));
    graph.addVertex("idaho", Arrays
        .asList(new Vertex("sf", 5), new Vertex("seattle", 1), new Vertex("nyc", 6),
            new Vertex("chicago", 3)));
    graph.addVertex("nyc", Arrays.asList(new Vertex("idaho", 3), new Vertex("chicago", 4)));
    graph.printGraph();
  }
}
