package weblab;

class Solution {

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     * @param tree BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static boolean isRedBlackTree(BinaryTree tree) {
        if(tree == null)
            return true;

        if(!isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return false;

        if(!tree.isBlack() || !validChildren(tree))
            return false;

        return height(tree) != -1;
    }

    /**
     * Check if a Binary Tree is a Binary Search Tree without duplicates
     *
     * @param tree Binary Tree
     * @param lower lower bound
     * @param upper upper bound
     */
    public static boolean isBST(BinaryTree tree, int lower, int upper) {
        if(tree == null)
            return true;

        if(tree.getValue() <= lower || tree.getValue() >= upper)
            return false;

        if(!isBST(tree.getLeft(), lower, tree.getValue()))
            return false;

        return isBST(tree.getRight(), tree.getValue(), upper);
    }

    /**
     * Verify the colour property of the Red Black Tree
     *
     * @param tree Binary Tree
     */
    public static boolean validChildren(BinaryTree tree) {
        if(tree == null)
            return true;

        if(tree.isRed()) {
            if(tree.hasLeft() && tree.getLeft().isRed())
                return false;

            if(tree.hasRight() && tree.getRight().isRed())
                return false;
        }

        return validChildren(tree.getLeft()) && validChildren(tree.getRight());
    }

    /**
     * Check height property for Red Black Tree
     *
     * @param tree Binary Tree
     */
    public static int height(BinaryTree tree) {
        if(tree == null)
            return 1;

        int leftHeight = height(tree.getLeft());
        int rightHeight = height(tree.getRight());
        if(leftHeight == -1 || leftHeight != rightHeight)
            return -1;

        if(tree.isBlack())
            return leftHeight + 1;

        return leftHeight;
    }

}