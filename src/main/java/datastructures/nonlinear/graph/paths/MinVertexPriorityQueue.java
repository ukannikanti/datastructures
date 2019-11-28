package datastructures.nonlinear.graph.paths;

public class MinVertexPriorityQueue {
  MinVertexHeapTree minIntHeapTree;

  public MinVertexPriorityQueue(int capacity) {
    minIntHeapTree = new MinVertexHeapTree(capacity);
  }

  public void push(Graph.Vertex element) {
    minIntHeapTree.add(element);
  }

  public Graph.Vertex poll() {
    return minIntHeapTree.poll();
  }

  public boolean isEmpty() {
    return minIntHeapTree.isEmpty();
  }
}
