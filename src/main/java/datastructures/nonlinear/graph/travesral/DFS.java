package datastructures.nonlinear.graph.travesral;

import datastructures.linear.stack.LinkedListStack;
import datastructures.nonlinear.graph.implementation.AdjacencyMatrix;

import java.util.ArrayList;
import java.util.List;

public class DFS {
  private AdjacencyMatrix adjacencyMatrix;
  private LinkedListStack<Integer> stack;
  private List<Integer> visited;

  public DFS() {
    adjacencyMatrix = new AdjacencyMatrix(false, 5);
    adjacencyMatrix.addEdge(0, 1);
    adjacencyMatrix.addEdge(0, 2);
    adjacencyMatrix.addEdge(0, 3);
    adjacencyMatrix.addEdge(1, 2);
    adjacencyMatrix.addEdge(2, 4);

    stack = new LinkedListStack<>();
    visited = new ArrayList<>();
  }

  public void traversal() {
    stack.push(0);

    while (!stack.isEmpty()) {
      int vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        int[] edges = adjacencyMatrix.getEdges(vertex);
        for (int i = 0; i < edges.length; i++) {
          if (edges[i] > 0) {
            stack.push(edges[i]);
          }
        }
      }
    }

    for (Integer integer : visited) {
      System.out.print(integer + " -> ");
    }
  }

  public static void main(String... args) {
    DFS dfs = new DFS();
    dfs.traversal();
  }
}
