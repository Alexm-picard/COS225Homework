import java.lang.Math;
public class BinaryTree<E extends Comparable<E>> {
    private BinaryTreeNode<E> root;
    
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryTreeNode<E> node) {
        root = node;
    }

    public BinaryTreeNode<E> getRoot() { return root; }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void randomInsert(E new_data) {
        BinaryTreeNode<E> new_node = new BinaryTreeNode<E>(new_data);
        if (root == null) {
            root = new_node;
        } else {
            randomInsertRecursive(new_node, root);
        }
    }

    private void randomInsertRecursive(BinaryTreeNode<E> new_node, BinaryTreeNode<E> node) { 
        double r;
        if (node.getLeft() == null) {
            node.setLeft(new_node);
        } else if (node.getRight() == null) {
            node.setRight(new_node);
        } else {
            r = Math.random();
            if (r < 0.5) {
                randomInsertRecursive(new_node, node.getLeft());
            } else {
                randomInsertRecursive(new_node, node.getRight());
            }
        }        
    }

    public void inorderPrint() { inorderPrintRecursive(root); System.out.println(); }
    private void inorderPrintRecursive(BinaryTreeNode<E> node) {
        if (node == null) { return; }
        inorderPrintRecursive(node.getLeft());
        System.out.print(node.getData() + " ");
        inorderPrintRecursive(node.getRight());
    }

    public void preorderPrint() { preorderPrintRecursive(root); System.out.println(); }
    private void preorderPrintRecursive(BinaryTreeNode<E> node) {
        if (node == null) { return; }
        System.out.print(node.getData() + " ");
        preorderPrintRecursive(node.getLeft());
        preorderPrintRecursive(node.getRight());
    }
    
    public void postorderPrint() { postorderPrintRecursive(root); System.out.println(); }
    private void postorderPrintRecursive(BinaryTreeNode<E> node) {
        if (node == null) { return; }
        postorderPrintRecursive(node.getLeft());
        postorderPrintRecursive(node.getRight());
        System.out.print(node.getData() + " ");
    }

    public void breadthFirstPrint() {
    	if (root == null) { return; }
        SinglyLinkedQueue<BinaryTreeNode<E>> q = new SinglyLinkedQueue<>();
        q.enqueue(root);
        BinaryTreeNode<E> current_node;
        while (!q.isEmpty()) {
            current_node = q.dequeue();
            System.out.print(current_node.getData() + " ");
            if (current_node.getLeft() != null) { q.enqueue(current_node.getLeft()); }
            if (current_node.getRight() != null) { q.enqueue(current_node.getRight()); }
        }
    }
    
    public void delete(E data) { root = deleteRecursive(data, root); }
    private BinaryTreeNode<E> deleteRecursive(E data, BinaryTreeNode<E> node) {
        BinaryTreeNode<E> current, inorder_successor;
        if (node == null) { return null; }
        node.setLeft(deleteRecursive(data, node.getLeft()));
        node.setRight(deleteRecursive(data, node.getRight()));
        if (data.equals(node.getData())) {
            if (node.getLeft() == null) { return node.getRight(); }
            if (node.getRight() == null) { return node.getLeft(); }
            if (node.getRight().getLeft() == null) {
                node.getRight().setLeft(node.getLeft());
                return node.getRight();
            }
            current = node.getRight();
            while (current.getLeft().getLeft() != null) { current = current.getLeft(); }
            inorder_successor = current.getLeft();
            current.setLeft(inorder_successor.getRight());
            inorder_successor.setLeft(node.getLeft());
            inorder_successor.setRight(node.getRight());
            return inorder_successor;
        }
       return node;
    }
    
    public boolean contains(E data) { return containsRecursive(data, root); }
    private boolean containsRecursive(E data, BinaryTreeNode<E> node) {
    	// Nayan Sawyer
    	if (node == null) {return false;}
    	return data.equals(node.getData()) || containsRecursive(data, node.getLeft()) || 
    			containsRecursive(data, node.getRight());
    }
 
    public int size() {
    	return sizeOfSubtree(root);
    }
    
    private int sizeOfSubtree(BinaryTreeNode<E> root) {
    	// David
    	if (root == null) {
    		return 0;
    	}
    	return 1 + sizeOfSubtree(root.getLeft()) + sizeOfSubtree(root.getRight());
    }
    public int height(){
        return heightOfSubTree(root);
    }
    //Time complexity is O(n) due to linear recurssion
    private int heightOfSubTree(BinaryTreeNode<E> node) {
    	if (root == null) {
    		return 0;
    	}
        if(heightOfSubTree(root.getLeft()) > heightOfSubTree(root.getRight())){
    	    return 1 + heightOfSubTree(root.getLeft());
        }else{
            return 1 + heightOfSubTree(root.getRight());
        }
    }
    public boolean isBalanced(){
        if(isBalancedRecursive(root) == -1){
            return false;
        }else{
            return true;
        }
    }
    //isBalancedReccursive implemented in O(n)
    private int isBalancedRecursive(BinaryTreeNode<E> node) {
    	if (root == null) {
    		return 0;
    	}
        int left = isBalancedRecursive(root.getLeft());
        if(left == -1){
            return -1;
        }
        int right = isBalancedRecursive(root.getRight());
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) >= 1){
            return -1;
        }else{
            return Math.max(left, right) + 1;
        }
    }
    //Time complexity is O(n^2) due to the two different reccursion calls
    //Only made sence when adding BinaryTreeNode<E> node into arguments
    //or else how would it know which branch to insert into
    public void insertIntoShorterSubtree(E new_data, BinaryTreeNode<E> node){
        BinaryTreeNode<E> temp = new BinaryTreeNode<>(new_data);
        if(root == null){
            root.setData(new_data);
        }
        if(root.getLeft() == null){
            root.setLeft(temp);
        }
        if(root.getRight() == null){
            root.setRight(temp);
        }
        if(heightOfSubTree(root.getLeft()) >= heightOfSubTree(root.getRight())){
            insertIntoShorterSubtree(new_data, root.getLeft());
        }else{
            insertIntoShorterSubtree(new_data, root.getRight());
        }
    }
    //Time complexity is log_2(n) due to the worst case being a nearly complete binary tree
    public void insertIntoFirstAvailablePosition(E new_data){
        BinaryTreeNode<E> temp = new BinaryTreeNode<>(new_data);
        SinglyLinkedQueue<BinaryTreeNode<E>> q = new SinglyLinkedQueue<>();
        BinaryTreeNode<E> current_node;
        if(root == null){
            root.setData(new_data);
        }
        if(root.getLeft() == null){
            root.setLeft(temp);
        }
        if(root.getRight() == null){
            root.setRight(temp);
        }
        q.enqueue(root);
        while (!q.isEmpty()) {
            current_node = q.dequeue();
            if (current_node.getLeft() != null) { 
                q.enqueue(current_node.getLeft()); 
            }else{
                current_node.setLeft(temp);
            }
            if (current_node.getRight() != null) {
                 q.enqueue(current_node.getRight()); 
            }else{
                current_node.setRight(temp);
            }
        }
    }
    //The time complexity is O(n) as the worst time is if the BinaryTree
    private void toStringRecursive(BinaryTreeNode<E> node){
        SinglyLinkedQueue<BinaryTreeNode<E>> q = new SinglyLinkedQueue<>();
        if (node == null) { System.out.print("No Binary Tree Nodes"); }
        for(int i = 0; i < q.size()*4; i++){
            System.out.print(" ");
        }
        System.out.print("(" +  q.size() + ")");
        System.out.println(node.getData());
        q.enqueue(node);
        preorderPrintRecursive(node.getLeft());
        preorderPrintRecursive(node.getRight());
    }
    public void deleteByPromotingInorderPredecessor(E data) {
        root = deleteRecursiveByPromotingInorderPredecessor(data, root);
    }

    private BinaryTreeNode<E> deleteRecursiveByPromotingInorderPredecessor(E data, BinaryTreeNode<E> node) {
        if (node == null) {
            return null;
        }

        node.setLeft(deleteRecursiveByPromotingInorderPredecessor(data, node.getLeft()));
        node.setRight(deleteRecursiveByPromotingInorderPredecessor(data, node.getRight()));

        if (data.equals(node.getData())) {
            if (node.getLeft() != null && node.getRight() != null) {
                BinaryTreeNode<E> predecessor = findInorderPredecessor(node.getLeft());
                node.setData(predecessor.getData());
                node.setLeft(deleteRecursiveByPromotingInorderPredecessor(predecessor.getData(), node.getLeft()));
            } else if (node.getLeft() != null) {
                return node.getLeft();
            } else if (node.getRight() != null) {
                return node.getRight();
            } else {
                return null;
            }
        }
        return node;
    }
    //The Time complexity is O(n) as it only needs to traverse the tree once to validate if it is a BST
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(BinaryTreeNode<E> node, E min, E max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.getData().compareTo(min) <= 0) ||
            (max != null && node.getData().compareTo(max) >= 0)) {
            return false;
        }

        return isBinarySearchTree(node.getLeft(), min, node.getData()) &&
               isBinarySearchTree(node.getRight(), node.getData(), max);
    }
    private BinaryTreeNode<E> findInorderPredecessor(BinaryTreeNode<E> node) {
        BinaryTreeNode<E> current = node;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    @Override
    public String toString(){
        System.out.println("test");
        toStringRecursive(root);
        System.out.println();
        return "Complete";
    }
    
}
