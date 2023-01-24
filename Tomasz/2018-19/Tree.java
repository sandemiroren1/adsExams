class Solution {
  /**
   * Counts the number of nodes in the tree at a certain level.
   *
   * @param tree
   *     The binary tree to count nodes in.
   * @param level
   *     The specified level to count nodes in.
   * @return the number of nodes at that level, or 0 if tree is null.
   */
  
  public static int countNodesAtLevel(BinaryTree tree, int level) {
    if(tree == null)
      return 0;
    
    return dfs(tree, 0, level);

    }
    public static int dfs(BinaryTree tree, int depth, int level) {
      int result = 0;
      if(tree == null)
        return 0;
      if(depth == level)
        result++;
      result+=dfs(tree.getLeft(), depth+1, level);
      result+=dfs(tree.getRight(), depth+1, level);
    return result;
    }
}
