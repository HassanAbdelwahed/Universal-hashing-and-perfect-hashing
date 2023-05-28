package trees;


public class RedBlackTree <Key extends Comparable<Key>> implements mySet<Key>{
    public class Node {
        Key key;
        int color;
        Node left;
        Node right;
        Node parent;
    }
    Node root;
    Node NiL;
    int numkeys = 0;
    public  RedBlackTree(){
        Node nilNode = new Node();
        nilNode.color = 0;
        //nilNode.key =  null;
        this.NiL = nilNode;
        this.root = NiL;
    }
    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree ();
        /*bst.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(15);
        rbt.insert(25);
        rbt.insert(12);
        rbt.insert(5);
        rbt.insert(3);
        rbt.insert(8);
        rbt.insert(27);
        rbt.insert(40);
        rbt.insert(50);
        rbt.insert(45);
        rbt.insert(9);
/*
        rbt.insert(41);
        rbt.insert(38);
        rbt.insert(31);
        rbt.insert(12);
        rbt.insert(19);
        rbt.insert(8);
        rbt.deleteNode(8);
        rbt.deleteNode(12);
        rbt.deleteNode(19);
        rbt.deleteNode(31);
        rbt.deleteNode(38);
        rbt.printTree();*/
        try {
            System.out.println(rbt.insert("A"));
            System.out.println(rbt.insert("A"));
            rbt.insert("B");
            rbt.insert("C");
            rbt.insert("D");
            rbt.insert("E");
            rbt.insert("F");
            rbt.insert("G");
            //bst.deleteNode(40);
            System.out.println("de " + rbt.deleteNode(4));
            System.out.println(rbt.Search("Gassan"));
            System.out.println("height of tree: " + rbt.height(rbt.root));
            System.out.println("size of tree: " + rbt.getSize());
            rbt.printTree();
        }catch (Exception e){
            System.out.print("Failure => ");
            System.out.println(e.getMessage());
        }

    }
    public void printTree() {
        print(this.root, "", true);
    }
    public int getSize(){
        return numkeys;
    }
    public int height(Node node){
        if (node == NiL){
            return 0;
        }else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }


    @Override
    public boolean Insert(Key key) {
        return insert(key);
    }

    @Override
    public boolean Delete(Key key) {
        return deleteNode(key);
    }

    public boolean Search(Key key){
        Node ro = root;
        while (ro != NiL){
            if (key.compareTo(ro.key) < 0){
                ro = ro.left;
            } else if (key.compareTo(ro.key) > 0) {
                ro = ro.right;
            }else {
                return true;
            }
            /*
            if (key < ro.key){
                ro = ro.left;
            } else if (key > ro.key) {
                ro = ro.right;
            }else {
                return true;
            }*/
        }
        // node does not exist
        return false;
    }

    @Override
    public int Size() {
        return numkeys;
    }

    @Override
    public int Height() {
        return height(root) - 1;
    }


    private void print(Node root, String indent, boolean last) {
        if (root != NiL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.key + "(" + sColor + ")");
            print(root.left, indent, false);
            print(root.right, indent, true);
        }
    }

    public Node LeftRotate (Node x){
        Node y = x.right;
        x.right = y.left;
        if (y.left != NiL)
            y.left.parent = x;

        Node p = x.parent;
        y.parent = p;
        if (p == null){             //x is the root
            root = y;
        } else if (p.left == x) {   //x is the left child
            p.left = y;
        }else {                     // x is right child
            p.right = y;
        }

        y.left = x;
        x.parent = y;
        return y;
    }
    public Node RightRotate(Node y){
        Node x = y.left;
        y.left = x.right;
        if (x.right != NiL){
            x.right.parent = y;
        }
        Node p = y.parent;
        x.parent = p;
        if (p == null){
            root = x;
        }else if (p.right == y){
            p.right = x;
        }else {
            p.left = x;
        }
        x.right = y;
        y.parent = x;
        return x;
    }

    public boolean insert(Key key){
        //make node with color red
        Node node = new Node();
        node.parent = null;
        node.key = key;
        node.left = NiL;
        node.right = NiL;
        node.color = 1;
        //check if tree is empty
        /*if (root == null){
            node.color = 0; //black
            root = node;
            return true;
        }*/
        Node temp = root;
        Node leaf  = null;
        //until leaf (NIL) is reached.
        while (temp != NiL){
            leaf = temp;
            if (key.compareTo(temp.key) > 0){
                temp = temp.right;
            } else if (key.compareTo(temp.key) < 0) {
                temp = temp.left;
            }else {
                return false;
            }
           /*
          if (key > temp.key){ //greater
              temp = temp.right;
          }else if (key < temp.key){
              temp = temp.left;
          }else { // equal
              return false;
          }*/
        }
        node.parent = leaf;
        //check if key is smaller or greater than leaf node
        if (leaf == null){
            root = node;
        }else if(key.compareTo(leaf.key) < 0){
            leaf.left = node;
        }else if (key.compareTo(leaf.key) > 0){
            leaf.right = node;
        }
        /*
        if (leaf == null){
            root = node;
        }else if(key < leaf.key){
            leaf.left = node;
        }else if (key > leaf.key){
            leaf.right = node;
        }*/
        numkeys++;
        if (node.parent == null){
            node.color = 0;
            return true;
        }
        CheckInsertion(node);
        return true;
    }
    public void CheckInsertion(Node newNode){

        if (newNode.parent.parent == null){
            return;
        }
        //fix the violations if the parent of the new node is red.
        while (newNode.parent.color == 1){
            Node gP = newNode.parent.parent;
            if(gP.left == newNode.parent){      // the parent of the newNode is a left child of its parent
                if (gP.right != null && gP.right.color == 1){ //case 1  => when the uncle of newNode is also red.
                    // shift the red color upward until there is no violation
                    gP.right.color = 0;         //uncle is black
                    gP.left.color = 0;          // parent is black
                    gP.color = 1;               // grandparent is red
                    newNode = gP;               // fix grandParent

                }else {                         //  case 2 => the uncle of newNode is black and the newNode is the right child
                    // or case 3 => the uncle of newNode is black and the newNode is the left child.
                    if (newNode == newNode.parent.right){ //case 2
                        newNode = newNode.parent;
                        LeftRotate(newNode);
                    }
                    // case 3
                    // color the parent of the newNode black and its grandparent red
                    newNode.parent.color = 0;
                    newNode.parent.parent.color = 1;
                    RightRotate(newNode.parent.parent); // right rotation on the grandparent
                }
            }else {                                     // the parent of the newNode is a right child of its parent
                if(gP.left != null && gP.left.color == 1){  //case 1
                    gP.right.color = 0;
                    gP.left.color = 0;
                    gP.color = 1;
                    newNode = gP;
                } else {
                    if (newNode == newNode.parent.left) {  //case 2
                        newNode = newNode.parent;
                        RightRotate(newNode);
                    }
                    // case 3
                    newNode.parent.color = 0;
                    newNode.parent.parent.color = 1;
                    LeftRotate(newNode.parent.parent);
                }
            }
            // all cases fixed
            if (newNode == root) {
                break;
            }
        }
        root.color = 0;
    }

    public boolean deleteNode(Key key){
        int origrinalColor;
        Node x , y = null;
        Node z = NiL;
        Node ro = root;
        while (ro != NiL){

            if (key.compareTo(ro.key) < 0){         // search in left subtree
                ro = ro.left;
            } else if (key.compareTo(ro.key) > 0) { // search in right subtree
                ro = ro.right;
            }else {
                // found key in tree
                z = ro;
                break;
            }
            /*
            if (key < ro.key){
                ro = ro.left;
            } else if (key > ro.key) {
                ro = ro.right;
            }else {
                z = ro;
                break;
            }*/
        }
        // node does not exist
        if (ro == NiL){
            return false;
        }

        y = z;
        origrinalColor = y.color;
        if (z.left == NiL){             // no children or right  // z does not have left child so the right child or  of z take the position of z.
            x = z.right;
            Transplant(z, x);
        } else if (z.right == NiL) {    // z does not have right child so the left child of z take the position of z.
            x = z.left;
            Transplant(z, x);
        }else {                         //  replace z with the minimum of the right subtree of z
            y = minimum(z.right);
            origrinalColor = y.color;
            x = y.right;                // node to replace y when y is deleted to replace z

            if (y.parent == z){         //  y is the direct child of z
                x.parent = y;
            }else {                     // transplant the right subtree of y to y
                Transplant(y, y.right);
                y.right = z.right;      // change the right of y to right of z
                y.right.parent = y;
            }
            Transplant(z, y);           // transplant y to z whether y is direct child or not
            y.left = z.left;            // put the left of z to left of y and color y as z.
            y.left.parent = y;
            y.color = z.color;
        }
        if(origrinalColor == 0){        // node y is black       //  fix the violation if the original color of y was black
            CheckDeletion(x);
        }
        numkeys--;
        return true;
    }
    void  CheckDeletion(Node node){
        Node w;
        // fixing the problem of double black
        // node in while loop represents double black
        while (node != null && node != root && node.color == 0){
            if (node == node.parent.left){          // double black node is the left child of its parent
                // w is node's sibling
                w = node.parent.right;
                if (w.color == 1){                   // if w is red
                    w.color = 0;                    // switch the colors of w and its parent and then left rotate the parent of node
                    node.parent.color = 1;
                    LeftRotate(node.parent);
                    w = node.parent.right;
                }
                // w is black and its both children are black.
                if (w.left.color == 0 && w.right.color == 0){
                    w.color = 1;
                    node = node.parent;             // now node parent is the double black node
                }else {
                    // case 3 => w is black and its right child is black and left child is red.
                    // or case 4 =>  w is black and its right child is red.
                    if (w.right.color == 0){        // case 3
                        w.left.color = 0;
                        w.color = 1;
                        RightRotate(w);
                        w = node.parent.right;
                    }
                    // case 4
                    w.color = node.parent.color;
                    node.parent.color = 0;
                    w.right.color = 0;
                    LeftRotate(node.parent);
                    node = root;
                }
            }else {                             // double black node is the right child of its parent
                w = node.parent.left;
                if (w.color == 1){
                    w.color = 0;
                    node.parent.color = 1;
                    RightRotate(node.parent);
                    w = node.parent.left;
                }
                if (w.left.color == 0 && w.right.color == 0){
                    w.color = 1;
                    node = node.parent;
                }else {
                    if (w.left.color == 0){
                        w.right.color = 0;
                        w.color = 1;
                        LeftRotate(w);
                        w = node.parent.left;
                    }
                    w.color = node.parent.color;
                    node.parent.color = 0;
                    w.left.color = 0;
                    RightRotate(node.parent);
                    node = root;
                }
            }
        }
        // If node is red and black, we can simply color it black
        // or if node is root, we can simply remove the one extra black
        if (node != null){
            node.color = 0;
        }

    }

    public Node minimum(Node n){
        if(n.left == NiL)
            return n;
        else
            return minimum(n.left);
    }

    public void Transplant(Node x, Node y){
        if (x.parent == null){                  //x is the root
            root = y;
        } else if (x == x.parent.left) {        //if x is the left child
            x.parent.left = y;
        }else if (x == x.parent.right){         // x is the right child
            x.parent.right = y;
        }
        if(y != null){
            y.parent = x.parent;
        }

    }
}
