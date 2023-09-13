package binary_search_tree;

import stack.LinkedListStack;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private static class Node {
        public int key;
        public Object value;
        public Node left;
        public Node right;


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

    private Node root;

    public Object get(int key) {
        Node current = root;

        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (current.key < key) {
                current = current.right;
            } else {
                return current.value;
            }
        }

        return null;
    }
    public Object min() { return min(root); }
    public Object min(Node current) {
        if (current == null) return null;

        while (current.left != null) {
            current = current.left;
        }

        return current.value;
    }
    public Object max() { return max(root); }
    public Object max(Node current) {
        if (current == null) return null;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }
    public Object predecessor(int key) {
        Node current = root;
        Node ancestorFromRight = null;

        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (current.key < key) {
                ancestorFromRight = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) return null;
        if (current.left == null) {
            return ancestorFromRight == null ? null : ancestorFromRight.value;
        } else {
            return max(current.left);
        }
    }
    public Object successor(int key) {
        Node current = root;
        Node ancestorFromLeft = null;

        while (current != null) {
            if (key < current.key) {
                ancestorFromLeft = current;
                current = current.left;
            } else if (current.key < key) {
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) return null;
        if (current.right == null) {
            return ancestorFromLeft == null ? null : ancestorFromLeft.value;
        } else {
            return min(current.right);
        }
    }
    public void put(int key, Object value) {
        Node current = root;
        Node parent = null;

        while (current != null) {
            if (key < current.key) {
                parent = current;
                current = current.left;
            } else if (current.key < key) {
                parent = current;
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value);

        if (parent == null) {
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    private void shift(Node parent, Node removed, Node child) {
        if (parent == null) {
            root = child;
        } else if (removed == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public Object delete1(int key) {
        Node current = root;
        Node parent = null;

        while (current != null) {
            if (key < current.key) {
                parent = current;
                current = current.left;
            } else if (current.key < key) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) return null;

        if (current.left == null) {
            shift(parent, current, current.right);
        } else if (current.right == null) {
            shift(parent, current, current.left);
        } else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (current != successorParent) {
                shift(successorParent, successor, successor.right);
                successor.right = current.right;
            }

            shift(parent, current, successor);
            successor.left = current.left;
        }

        return current.value;
    }

    private Node deleteHelper(Node current, int key) {
        if (current == null) return null;

        if (key < current.key) {
            current.left = deleteHelper(current.left, key);
            return current;
        }
        if (current.key < key) {
            current.right = deleteHelper(current.right, key);
            return current;
        }

        if (current.left == null) {
            return current.right;
        } else if (current.right == null) {
            return current.left;
        } else {
            Node successor = current.right;

            while (successor.left != null) {
                successor = successor.left;
            }
            successor.right = deleteHelper(current.right, successor.key);
            successor.left = current.left;

            return successor;
        }
    }

    public void delete2(int key) {
        root = deleteHelper(root, key);
    }

    public List<Object> less(int key) {
        Node current = root;
        LinkedListStack<Node> stack = new LinkedListStack<>();
        ArrayList<Object> result = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                Node prev = stack.pop();

                if (prev.key < key) {
                    result.add(prev.value);
                } else {
                    break;
                }

                current = prev.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        return result;
    }

    public List<Object> greater(int key) {
        Node current = root;
        LinkedListStack<Node> stack = new LinkedListStack<>();
        ArrayList<Object> result = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                Node prev = stack.pop();

                if (prev.key > key) {
                    result.add(prev.value);
                } else {
                    break;
                }

                current = prev.left;
            } else {
                stack.push(current);
                current = current.right;
            }
        }

        return result;
    }

    public List<Object> between(int start, int end) {
        Node current = root;
        LinkedListStack<Node> stack = new LinkedListStack<>();
        ArrayList<Object> result = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                Node prev = stack.pop();

                if (prev.key > end) break;
                if (prev.key >= start) {
                    result.add(prev.value);
                }

                current = prev.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        return result;
    }
}
