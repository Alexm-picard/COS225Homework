
public class BinaryTree<E> {
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
        SinglyLinkedListQueue<BinaryTreeNode<E>> q = new SinglyLinkedListQueue<>();
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
}
