import java.util.*;

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
    if (tree == null) return 0;
    List<Integer> list = helper(tree,new ArrayList<Integer>(),0);
    int m = 0;
    for(int i = 0; i<list.size();i++){
      if (list.get(i) == level) m++;
    }
    return m;

  }

  private static List<Integer> helper(BinaryTree tree, List<Integer> list, int h){
    if (tree.hasLeft()) helper(tree.getLeft(), list, h+1);
    list.add(h);
    if (tree.hasRight()) helper(tree.getRight(),list,h+1);
    return list;
  }

}