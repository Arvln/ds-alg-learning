package avl_tree;

public class AVLTree {
    private static class Node {
        private int key;
        private Object value;
        private Node left;
        private Node right;
        private int height = 1;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private int height(Node current) {
        return current == null ? 0 : current.height;
    }

    private void updateHeight(Node current) {
        current.height = Integer.max(height(current.left), height(current.right)) + 1;
    }

    /**
     *
     * @param current
     * @return -1 | 0 | 1 -> balance, > 1 left overload, < -1 right overload
     */
    private int balanceFactor(Node current) {
        return height(current.left) - height(current.right);
    }

    private Node leftRotate(Node current) {
        Node right = current.right;
        current.right = right.left;
        right.left = current;
        updateHeight(right);
        updateHeight(current);
        return right;
    }

    private Node rightRotate(Node current) {
        Node left = current.left;
        current.left = left.right;
        left.right = current;
        updateHeight(left);
        updateHeight(current);
        return left;
    }

    private Node leftRightRotate(Node current) {
        current.left = leftRotate(current.left);
        return rightRotate(current);
    }

    private Node rightLeftRotate(Node current) {
        current.right = rightRotate(current.right);
        return leftRotate(current);
    }

    private Node balance(Node current) {
        if (current == null) return null;

        int balanceFactor = balanceFactor(current);

        if (balanceFactor > 1 && balanceFactor(current.left) >= 0) {
            current = rightRotate(current);
        } else if (balanceFactor > 1 && balanceFactor(current.left) < 0) {
            current = leftRightRotate(current);
        } else if (balanceFactor < -1 && balanceFactor(current.right) > 0) {
            current = rightLeftRotate(current);
        } else if (balanceFactor < -1 && balanceFactor(current.right) <= 0) {
            current = leftRotate(current);
        }

        return current;
    }

    private Node root;

    private Node executePut(Node current, int key, Object value) {
        if (current == null) return new Node(key, value);

        if (key < current.key) {
            current.left = executePut(current.left, key, value);
        } else if (current.key < key) {
            current.right = executePut(current.right, key, value);
        } else {
            current.value = value;
            return current;
        }

        updateHeight(current);
        return balance(current);
    }

    public void put(int key, Object value) {
        root = executePut(root, key, value);
    }

    private Node executeRemove(Node current, int key) {
        if (current == null) return null;

        if (key < current.key) {
            current.left = executeRemove(current.left, key);
        } else if (current.key < key) {
            current.right = executeRemove(current.right, key);
        } else {
            Node successor = current.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            successor.right = executeRemove(current.right, successor.key);
            successor.left = current.left;
            current = successor;
        }

        updateHeight(current);
        return balance(current);
    }

    public void remove(int key) {
        root = executeRemove(root, key);
    }
}
