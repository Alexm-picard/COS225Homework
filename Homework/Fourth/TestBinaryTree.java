class TestBinaryTree{    
    public static void main(String[] Args){
        BinaryTreeNode temp = new BinaryTreeNode<>(8);
        BinaryTreeNode temp1 = new BinaryTreeNode<>(3);
        BinaryTreeNode temp2 = new BinaryTreeNode<>(10);
        BinaryTreeNode temp3 = new BinaryTreeNode<>(1);
        BinaryTreeNode temp4 = new BinaryTreeNode<>(6);
        BinaryTreeNode temp5 = new BinaryTreeNode<>(14);
        BinaryTreeNode temp6 = new BinaryTreeNode<>(4);
        BinaryTreeNode temp7 = new BinaryTreeNode<>(7);
        BinaryTreeNode temp8 = new BinaryTreeNode<>(13);
        BinaryTree test = new BinaryTree<>(temp);
        temp.setLeft(temp1);
        temp.setRight(temp2);
        System.out.println(temp.toString());
    }
}