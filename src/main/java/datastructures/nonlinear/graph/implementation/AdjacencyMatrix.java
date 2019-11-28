package datastructures.nonlinear.graph.implementation;

public class AdjacencyMatrix {
  private boolean adjMatrix[][];
  private int numVertices;
  private boolean directGraph;

  public AdjacencyMatrix(boolean directGraph, int numVertices) {
    this.numVertices = numVertices;
    this.directGraph = directGraph;
    adjMatrix = new boolean[numVertices][numVertices];
  }

  public void addEdge(int sourceIndex, int destinationIndex) {
    if (directGraph) {
      adjMatrix[sourceIndex][destinationIndex] = true;
    } else {
      adjMatrix[sourceIndex][destinationIndex] = true;
      adjMatrix[destinationIndex][sourceIndex] = true;
    }
  }

  public void removeEdge(int sourceIndex, int destinationIndex) {
    if (directGraph) {
      adjMatrix[sourceIndex][destinationIndex] = false;
    } else {
      adjMatrix[sourceIndex][destinationIndex] = false;
      adjMatrix[destinationIndex][sourceIndex] = false;
    }
  }

  public boolean isEdge(int sourceIndex, int destinationIndex) {
    return adjMatrix[sourceIndex][destinationIndex];
  }

  public int[] getEdges(int index) {
    int[] edges = new int[numVertices];
    int count = 0;
    for (int j = 0; j < adjMatrix.length; j++) {
      if (adjMatrix[index][j]) {
        edges[count] = j;
        count++;
      }else {
        edges[count] = -1;
        count++;
      }
    }
    return edges;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < numVertices; i++) {
      s.append(i + ": ");
      for (boolean j : adjMatrix[i]) {
        s.append((j ? 1 : 0) + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

  public static void main(String args[]) {
    AdjacencyMatrix g = new AdjacencyMatrix(false, 4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(1, 0);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    System.out.print(g.toString());
  }
}
