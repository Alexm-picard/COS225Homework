
public class BinaryTreeNode<E> {
	private E data;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode(E new_data) {
        data = new_data;
        left = right = null;
    }
    public E getData() { return data; }
    public BinaryTreeNode<E> getLeft() { return left; }
    public BinaryTreeNode<E> getRight() { return right; }
    public void setData(E new_data) { data = new_data; }
    public void setLeft(BinaryTreeNode<E> new_left) { left = new_left; }
    public void setRight(BinaryTreeNode<E> new_right) { right = new_right; }
}