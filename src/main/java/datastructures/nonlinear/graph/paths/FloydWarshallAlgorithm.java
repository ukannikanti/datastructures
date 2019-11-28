package datastructures.nonlinear.graph.paths;

import datastructures.nonlinear.graph.implementation.WeightedAdjacencyMatrix;

public class FloydWarshallAlgorithm {

  public void shortesPath(int[][] adjacentMatrix, int numberOfVertices) {
    for (int k = 0; k < numberOfVertices; k++) {
      for (int i = 0; i < numberOfVertices; i++) {
        for (int j = 0; j < numberOfVertices; j++) {
          if (adjacentMatrix[i][j] > adjacentMatrix[i][k] + adjacentMatrix[k][j]) {
            adjacentMatrix[i][j] = adjacentMatrix[i][k] + adjacentMatrix[k][j];
          }
        }
      }
    }

  }

  public static void print2D(int matrix[][]) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String... args) {
    WeightedAdjacencyMatrix weightedAdjacencyMatrix = new WeightedAdjacencyMatrix(true, 4);
    weightedAdjacencyMatrix.addEdge(1, 1, 0);
    weightedAdjacencyMatrix.addEdge(1, 2, 3);
    weightedAdjacencyMatrix.addEdge(1, 3, 9999);
    weightedAdjacencyMatrix.addEdge(1, 4, 7);

    weightedAdjacencyMatrix.addEdge(2, 1, 8);
    weightedAdjacencyMatrix.addEdge(2, 2, 0);
    weightedAdjacencyMatrix.addEdge(2, 3, 2);
    weightedAdjacencyMatrix.addEdge(2, 4, 9999);

    weightedAdjacencyMatrix.addEdge(3, 1, 5);
    weightedAdjacencyMatrix.addEdge(3, 2, 9999);
    weightedAdjacencyMatrix.addEdge(3, 3, 0);
    weightedAdjacencyMatrix.addEdge(3, 4, 1);

    weightedAdjacencyMatrix.addEdge(4, 1, 2);
    weightedAdjacencyMatrix.addEdge(4, 2, 9999);
    weightedAdjacencyMatrix.addEdge(4, 3, 9999);
    weightedAdjacencyMatrix.addEdge(4, 4, 0);

    print2D(weightedAdjacencyMatrix.getAdjMatrix());

    FloydWarshallAlgorithm algorithm = new FloydWarshallAlgorithm();
    algorithm.shortesPath(weightedAdjacencyMatrix.getAdjMatrix(), 4);

    System.out.println("\n After finding shortest paths for all pairs");
    print2D(weightedAdjacencyMatrix.getAdjMatrix());

  }
}
