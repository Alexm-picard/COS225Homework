class TestBinaryTree extends BinaryTree{    
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

        BinaryTreeNode temp9= new BinaryTreeNode<>(0);
        BinaryTreeNode tempA= new BinaryTreeNode<>(9);
        BinaryTree test = new BinaryTree<>(temp);
        temp.setLeft(temp1);
        temp.setRight(temp2);
        temp1.setLeft(temp3);
        temp1.setRight(temp4);
        temp4.setLeft(temp6);
        temp4.setRight(temp7);
        temp2.setRight(temp5);
        temp5.setLeft(temp8);
        //test.preorderPrint();
        //test.breadthFirstPrint();
        System.out.println(test.toString());
        System.out.println(test.height());
        System.out.println(test.isBalanced());
        System.out.println(test.isBinarySearchTree());
        test.insertIntoShorterSubtree(temp9.getData(), temp);
        test.insertIntoFirstAvailablePosition(tempA.getData());
        test.deleteByPromotingInorderPredecessor(temp);
        System.out.println(test.toString());
        
        //The resulting Binary Tree is a BSN as the 9 is less than 10 but bigger than 8
        //and the 0 is less than 0 so left is good.
    }
}