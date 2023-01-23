package weblab;

import java.util.*;

class Solution {

    /**
     * Returns the length of the shortest path between vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The length of the shortest path between a and b, or -1 if no such path exists.
     */
    public static int shortestPath(Graph g, Vertex a, Vertex b) {
        boolean[] visited = new boolean[g.getAllVertices().size()];
        Arrays.fill(visited, false);

        Map<Vertex, VertexNumPair> distances = new HashMap<>();
        distances.put(a, new VertexNumPair(null, 0));

        AdaptablePQ queue = new AdaptablePQ();
        queue.insertOrReplace(a, 0);

        while(!queue.isEmpty()) {
            VertexNumPair pair = queue.removeMin();
            if(b.equals(pair.getVertex()))
                return pair.getNum();

            visited[pair.getVertex().getId()] = true;
            for(VertexNumPair childPair : pair.getVertex().getNeighbours()) {
                Vertex childVertex = childPair.getVertex();
                if(visited[childVertex.getId()])
                    continue;

                int pairLength = pair.getNum() + childPair.getNum();
                if(distances.containsKey(childVertex))
                    if(distances.get(childVertex).getNum() <= pairLength)
                        continue;

                distances.put(childVertex, new VertexNumPair(pair.getVertex(), pairLength));
                queue.insertOrReplace(childVertex, pairLength);
            }
        }

        return -1;
    }

}