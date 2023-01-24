
  /**
   * Checks whether the given BinaryTree is a Red Black Tree.
   * @param tree BinaryTree to check.
   * @return True if the given tree is a Red Black Tree, false otherwise.
   */
  public static boolean isRedBlackTree(BinaryTree tree) {
      return tree.isBlack() && isBlackBalaced(tree) && isBST(tree, Integer.MAX_VALUE, Integer.MIN_VALUE) &&
      redProperty(tree);
  }

  private static boolean isBlackBalaced(BinaryTree tree){
      if (tree == null) return true;
      BinaryTree l = tree.getLeft();
      BinaryTree r = tree.getRight();
      if (Math.abs(height(l,0)-height(r,0))>0)
        return false;
      if (isBlackBalaced(l)&&isBlackBalaced(r)) return true;
      return false;
  }

  private static int height(BinaryTree tree, int h){
    if (tree == null) return h;
    if (tree.isRed()) return Math.max(height(tree.getLeft(), h), height(tree.getRight(),h));
    else return 1 + Math.max(height(tree.getLeft(), h), height(tree.getRight(),h));
  }

  private static boolean isBST(BinaryTree tree, int max, int min){
    if (tree == null) return true;
    if(tree.getValue()<=min || tree.getValue()>=max) return false;
    return isBST(tree.getLeft(), tree.getValue(),min) && isBST(tree.getRight(), max, tree.getValue());
  }

  private static boolean redProperty(BinaryTree tree){
    if (tree == null) return true;
    if (tree.hasLeft()){
      if (!tree.isBlack() && !tree.getLeft().isBlack())
        return false;
    }
    if (tree.hasRight()){
      if (!tree.isBlack() && !tree.getRight().isBlack())
        return false;
    }
    return redProperty(tree.getLeft()) && redProperty(tree.getRight());
  }
