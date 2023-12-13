import java.lang.Math;
import java.util.Comparator;
public class BinaryTree<E> implements Comparator<E> {
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
    	if(this.isEmpty()){
            return -1;
        }
        if (node == null) {
    		return 0;
    	}
        if(heightOfSubTree(node.getLeft()) >= heightOfSubTree(node.getRight())){
    	    return 1 + heightOfSubTree(node.getLeft());
        }else{
            return 1 + heightOfSubTree(node.getRight());
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
        if (node == null) {
            return 0;
        }
    
        int left = isBalancedRecursive(node.getLeft());
        if (left == -1) {
            return -1;
        }
    
        int right = isBalancedRecursive(node.getRight());
        if (right == -1) {
            return -1;
        }
    
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
    
    //Time complexity is O(n) due to worst case being a linked list
    //Only made sence when adding BinaryTreeNode<E> node into arguments
    //or else how would it know which branch to insert into
    public void insertIntoShorterSubtree(E new_data, BinaryTreeNode<E> node){
        if(root == null){
            root = new BinaryTreeNode<>(new_data);
            return;
        }
        if(node.getLeft() == null){
            node.setLeft(new BinaryTreeNode<>(new_data));
            return;
        }
        if(node.getRight() == null){
            node.setRight(new BinaryTreeNode<>(new_data));
            return;
        }
        int leftHeight = heightOfSubTree(node.getLeft());
        int rightHeight = heightOfSubTree(node.getRight());

        if (leftHeight <= rightHeight) {
        // If left subtree is shorter or equal, go down the left subtree
            insertIntoShorterSubtree(new_data, node.getLeft());
        } else {
        // If right subtree is shorter, go down the right subtree
            insertIntoShorterSubtree(new_data, node.getRight());
        }
    }
    //Time complexity is O(n) due to the worst case being a nearly complete binary tree and 
    //needs to go through each node in breadth first order
    public void insertIntoFirstAvailablePosition(E new_data) {
        BinaryTreeNode<E> temp = new BinaryTreeNode<>(new_data);
        SinglyLinkedQueue<BinaryTreeNode<E>> q = new SinglyLinkedQueue<>();
        
        if (root == null) {
            root = temp; // Set the new node as the root if the tree is empty
            return;
        }
    
        q.enqueue(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<E> current_node = q.dequeue();
            
            if (current_node.getLeft() == null) {
                current_node.setLeft(temp);
                return; // Inserted into the first available position, exit the method
            } else {
                q.enqueue(current_node.getLeft());
            }
            
            if (current_node.getRight() == null) {
                current_node.setRight(temp);
                return; // Inserted into the first available position, exit the method
            } else {
                q.enqueue(current_node.getRight());
            }
        }
    }
    
    //Time complexity is O(n) as worst case is a unbalanced tree
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
        // Check if the current node's value is within the specified range
        if ((min != null && compare(min, node.getData()) <= 0) ||
            (max != null && compare(max, node.getData()) >= 0)) {
            return false;
        }
    
        // Recursively check left subtree with updated max value
        // Recursively check right subtree with updated min value
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


    //Time complexity is O(n) due to travirsing the string and the worst case being
    // a linked list
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        toStringR(root, 0, result);
        
        return result.toString();
    }
    private void toStringR(BinaryTreeNode<E> root, int depth, StringBuilder result){
        if (root == null) {
            return;
        }

        for(int i = 0; i < (depth); i++){
            result.append("    ");
        }
        result.append("(").append(depth).append(")").append(root.getData()).append("\n");
        if (root.getLeft() != null || root.getRight() != null) {
            if (root.getLeft() == null) {
                for(int i = 0; i < (depth+1); i++){
                    result.append("    ");
                }
                result.append("(").append(depth+1).append(")").append("null\n");
            } else {
                toStringR(root.getLeft(), depth + 1, result);
            }

            if (root.getRight() == null) {
                for(int i = 0; i < (depth+1); i++){
                    result.append("    ");
                }
                result.append("(").append(depth+1).append(")").append("null\n");
            } else {
                toStringR(root.getRight(), depth + 1, result);
            }
        }
        
        
    }
    @Override
    public int compare(E num1, E num2) {
        return ((Integer) num1).compareTo((Integer) num2);
    }
}
