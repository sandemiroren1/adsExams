import java.util.*;

class Solution {

  /**
   * Counts the number of vertices in the same connected component as v in graph g.
   * This is done using depth first search.
   *
   * Returns 0 if the graph or vertex is null
   *
   * @param g
   *     The graph to count vertices in.
   * @param v
   *     The vertex to start counting at.
   * @return the number of vertices in the same connected component.
   */
  public static int countVertices(Graph g, Graph.Vertex v) {
    if(g == null || v == null)
      return 0;

    Set<Graph.Vertex> found = new HashSet<>();
    found.add(v);

    Queue<Graph.Vertex> queue = new ArrayDeque<>();
    queue.add(v);

    while(!queue.isEmpty()) {
      Graph.Vertex vertex = queue.remove();
      g.getNeighbours(vertex).forEach(child -> {
        if(!found.add(child))
          return;

        queue.add(child);
      });
    }

    return found.size();
  }

}