public class TreeSet<E extends Comparable<E>> {
    private Node<E> root;

    public TreeSet(E rootData) {
        this.root = new Node<>(rootData);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void insert(E data) {
        insert(this.root, data);
    }

    public Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            node = new Node<>(data);
            return node;
        }
        if (node.getData().compareTo(data) > 0) {
            node.addLeft(insert(node.left, data));
        } else {
            node.addRight(insert(node.right, data));
        }
        return node;
    }

    public void delete(E data) {
        delete(root, data);
    }

    public Node<E> delete(Node<E> node, E data) {
        if (node == null) {
            throw new RuntimeException("cannot delete.");
        } else {
            if (data.compareTo(node.getData()) < 0) {
                node.left = delete(node.left, data);
            }
            else if (data.compareTo(node.getData()) > 0) {
                node.right = delete(node.right, data);
            }
            else {
                if (node.left== null) {
                    return node.right;
                }
                else if (node.right == null) {
                    return node.left;
                }
                else {
                    // get data from the rightmost node in the left subtree
                    node.setData(node.left.getData());
                    // delete the rightmost node in the left subtree
                    node.left = delete(node.left, node.getData());
                }
            }
            return node;
        }
    }
    public String toString() {
        return toString(root);
    }
    private String toString(Node<E> root) {
        String result = "";
        if (root == null) {
            return "";
        }
        result += toString(root.left);
        result += root.getData().toString() + " ";
        result += toString(root.right);
        return result + "";
    }

}

