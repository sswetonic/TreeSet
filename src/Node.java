
public class Node<E extends Comparable<E>> {
    private E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getChild(E data) {
        int comparison = data.compareTo(this.data);
        if (comparison == 0) {
            return this;
        } else if (comparison < 0 && this.left != null) {
            return this.left.getChild(data);
        } else if (this.right != null) {
            return this.right.getChild(data);
        } else {
            return null;
        }
    }

    public void addLeft(Node<E> child) {
        this.left = child;
    }

    public void addRight(Node<E> child) {
        this.right = child;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

