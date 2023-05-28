package trees;

import java.util.LinkedList;

public class AVLTree<Key extends Comparable<Key>> implements mySet<Key> {
    private Node root;
    private int size = 0;

    private class Node {
        private Key key;
        //        private Value val;
        private Node left, right;
        private int height;
        public Node(Key key) {
            this.key = key;
            this.height = 0;
        }
    }

    @Override
    public boolean Insert(Key key) {
        int oldSize = size;
        root = Insert(root, key);
        return oldSize != size;
    }

    private Node Insert(Node x, Key key) {
        if (x == null)      {this.size++;   return new Node(key);}

        int cmp = key.compareTo(x.key);
        if (cmp < 0)        {x.left = Insert(x.left, key);}
        else if (cmp > 0)   {x.right = Insert(x.right, key);}
//        else

        if (getBalanceFactor(x) > 1) {
            if (getBalanceFactor(x.left) == 1) {
                x = rotateRight(x);
            } else if (getBalanceFactor(x.left) == -1) {
                x.left = rotateLeft(x.left);
                x = rotateRight(x);
            }
        } else if (getBalanceFactor(x) < -1) {
            if (getBalanceFactor(x.right) == 1) {
                x.right = rotateRight(x.right);
                x = rotateLeft(x);
            } else if (getBalanceFactor(x.right) == -1) {
                x = rotateLeft(x);
            }
        }

        setHeight(x);
        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        setHeight(x);
        setHeight(h);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        setHeight(x);
        setHeight(h);
        return x;
    }

    private int getBalanceFactor(Node x) {
        if (x == null)      return 0;
        return height(x.left) - height(x.right);
    }

    private int max(int a, int b) {
        return a > b? a : b;
    }

    @Override
    public boolean Search(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0)   x = x.left;
            else if (cmp > 0)   x = x.right;
            else                return true;
        }
        return false;
    }

    private int height(Node x) {
        if (x == null)  return -1;
        return x.height;
    }

    private void setHeight(Node x) {
        if (x == null)  return;
        x.height = max(height(x.left), height(x.right)) + 1;
    }

    @Override
    public int Size(){
        return this.size;
    }

    @Override
    public int Height() {
        return height(root);
    }

    @Override
    public boolean Delete(Key key) {
        int oldSize = size;
        root = delete(root, key);
        return oldSize != size;
    }

    private Node delete(Node x, Key key) {
        if (x == null)      return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0)   {x.left = delete(x.left, key);}
        else if (cmp > 0)   {x.right = delete(x.right, key);}
        else {
            this.size--;
            if (x.right == null)    return x.left;
            if (x.left == null)     return x.right;

            Node t = x;
            x = min(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }

        if (getBalanceFactor(x) > 1) {
            if (getBalanceFactor(x.left) != -1) {   // if (getBalanceFactor(x.left) == 1)
                x = rotateRight(x);
            } else if (getBalanceFactor(x.left) == -1) {
                x.left = rotateLeft(x.left);
                x = rotateRight(x);
            }
        } else if (getBalanceFactor(x) < -1) {
            if (getBalanceFactor(x.right) == 1) {
                x.right = rotateRight(x.right);
                x = rotateLeft(x);
            } else {    // if (getBalanceFactor(x.right) == -1)
                x = rotateLeft(x);
            }
        }

        setHeight(x);
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)     return x.right;
        x.left = deleteMin(x.left);
        setHeight(x);
        return x;
    }

    public Node min(Node x) {
        if (x. left == null)    return x;
        else                    return min(x.left);
    }

    public Iterable<Key> keys() {
        LinkedList<Key> ans = new LinkedList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(Node x, LinkedList<Key> ans) {
        if (x == null)  return;
        inorder(x.left, ans);
        ans.add(x.key);
        inorder(x.right, ans);
    }

    public static void main(String[] args) {
        AVLTree<Integer> myTree = new AVLTree<>();
//          TreeSet<Integer> myTree = new TreeSet<>();
//        System.out.println(myTree.Insert("A"));
//        System.out.println(myTree.Insert("B"));
//        System.out.println(myTree.Insert("C"));
//        System.out.println(myTree.Insert("D"));
//        System.out.println(myTree.Insert("A"));
        System.out.println(myTree.Insert(1));
        System.out.println(myTree.Insert(2));
        System.out.println(myTree.Insert(3));
        System.out.println(myTree.Insert(4));
        System.out.println(myTree.Insert(1));
//        System.out.println(myTree.add(1));
//        System.out.println(myTree.add(2));
//        System.out.println(myTree.add(3));
//        System.out.println(myTree.add(4));
//        System.out.println(myTree.add(1));

        for (Integer i : myTree.keys()) {
            System.out.println(i);
        }
    }
}