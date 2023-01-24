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
      HashSet<Graph.Vertex> visited = new HashSet<>();
      return dfs(g, v, visited);
  }
  public static int dfs(Graph g, Graph.Vertex v,  HashSet<Graph.Vertex> visited) {
    int result = 1;
    visited.add(v);
    for(Graph.Vertex u : g.getNeighbours(v)) {
      if(!visited.contains(u))
        result += dfs(g, u, visited);
    }
    return result;

  }
}
