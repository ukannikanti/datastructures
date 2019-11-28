package datastructures.nonlinear.graph.implementation;

public class WeightedAdjacencyMatrix {
  private int adjMatrix[][];
  private boolean directGraph;

  public WeightedAdjacencyMatrix(boolean directGraph, int numVertices) {
    this.directGraph = directGraph;
    adjMatrix = new int[numVertices][numVertices];
  }

  public void addEdge(int sourceIndex, int destinationIndex, int weight) {
    if (directGraph) {
      adjMatrix[sourceIndex - 1][destinationIndex - 1] = weight;
    } else {
      adjMatrix[sourceIndex - 1][destinationIndex - 1] = weight;
      adjMatrix[destinationIndex - 1][sourceIndex - 1] = weight;
    }
  }

  public int[][] getAdjMatrix() {
    return adjMatrix;
  }
}
