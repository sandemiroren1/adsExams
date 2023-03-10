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
    Stack<Graph.Vertex> stack = new Stack<>();
    List<Graph.Vertex> visited = new ArrayList<>();
    if(g == null || v == null) return 0;
    stack.push(v);
    while(!stack.empty()){
      v = stack.pop();
      if(!visited.contains(v)){
        ArrayList<Graph.Vertex> n = (ArrayList)g.getNeighbours(v);
        while(n.size()>0){
          Graph.Vertex y = n.remove(0);
          if(!visited.contains(y)){
            stack.push(y);
          }
        }
        visited.add(v);
      }
    }
    return visited.size();
  }

}