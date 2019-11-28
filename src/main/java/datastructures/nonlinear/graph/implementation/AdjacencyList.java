package datastructures.nonlinear.graph.implementation;

import java.util.LinkedList;

public class AdjacencyList {
  private int numberOfVertices;
  private LinkedList<Integer> list[];

  public AdjacencyList(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
    this.list = new LinkedList[numberOfVertices];

    for (int i = 0; i < numberOfVertices; i++) {
      list[i] = new LinkedList<>();
    }
  }

  public void addEdge(int source, int destination) {
    //add edge
    list[source].addFirst(destination);

    //add back edge ((for undirected)
    list[destination].addFirst(source);
  }

  public void print() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < numberOfVertices; i++) {
      s.append(i + ": ");
      for (int j = 0; j < list[i].size(); j++) {
        s.append(list[i].get(j) + " ");
      }
      s.append("\n");
    }

    System.out.println(s.toString());
  }

  public static void main(String[] args) {
    AdjacencyList graph = new AdjacencyList(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.print();
  }
}
