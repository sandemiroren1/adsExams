import java.util.*;

class Solution {
  /**
   * @param g
   *     The graph to search in.
   * @param v
   *     The vertex to start searching from.
   * @param n
   *     The number of edges n that can be traversed from v.
   * @return The number of vertices that are reachable from v (including v), using at most n edges.
   */
  static int countVertices(Graph g, Vertex v, int n) {
   if(n==0){
     return 1;
   }

   Queue<Vertex> que= new LinkedList<>();
   que.add(v);
   HashSet<Vertex> colored= new HashSet<>();
   colored.add(v);
   int increment=0;
   LinkedList<Vertex> backup= new LinkedList<>();
   while(n>0){
     
     while(!que.isEmpty()){
      Vertex temp= que.poll();
      for(Vertex e:g.getNeighbours(temp)){
        if(!colored.contains(e)){
          colored.add(e);
          backup.add(e);
          increment++;
        }
      }
    }
    que=backup;
    backup=new LinkedList<>();
    n--;

   }
   return increment+1;
  }
}
