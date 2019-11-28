package datastructures.nonlinear.graph.travesral;

import datastructures.linear.queue.QueueArray;
import datastructures.nonlinear.graph.implementation.AdjacencyMatrix;

public class BFS {
  private AdjacencyMatrix adjacencyMatrix;
  private QueueArray<Integer> queueArray;
  private int[] bfs;
  private boolean[] visited;

  public BFS() {
    adjacencyMatrix = new AdjacencyMatrix(false, 5);
    adjacencyMatrix.addEdge(0, 1);
    adjacencyMatrix.addEdge(0, 2);
    adjacencyMatrix.addEdge(0, 3);
    adjacencyMatrix.addEdge(1, 2);
    adjacencyMatrix.addEdge(2, 4);

    queueArray = new QueueArray(5);
    visited = new boolean[5];
    bfs = new int[5];
  }

  public void traversal() {
    queueArray.enqueue(0);
    visited[0] = true;
    int count = 0;

    while (!queueArray.isEmpty()) {
      int vertex = queueArray.dequeue();
      bfs[count] = vertex;

      int[] edges = adjacencyMatrix.getEdges(vertex);

      for (int i = 0; i < edges.length; i++) {
        int edge = edges[i];
        if (edge > 0) {
          if (!visited[edge]) {
            queueArray.enqueue(edge);
            visited[edge] = true;
          }
        }
      }

      count++;
    }

    for (int i=0; i< bfs.length; i++){
      System.out.println(bfs[i]+"   ");
    }
  }

  public static void main(String... args) {
    BFS bfs = new BFS();
    bfs.traversal();
  }
}
