

/**
 * @version: V1.0
 * @author: HanYuXing
 * @date: 2021-08-23 9:08
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //给二分搜索树添加元素
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public E mininum() {
        if (root == null) {
            return null;
        }

        Node res = root.left;
        while (res.left != null) {
            res = res.left;
        }

        return res.e;
    }

    public E maxnum() {
        if (root == null) {
            return null;
        }

        Node res = root.right;
        while (res.right != null) {
            res = res.right;
        }

        return res.e;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    //中序遍历以Node为根的二分搜索树，递归算法
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        System.out.println(node.e);

        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public E removeMin() {
        E res = mininum();
        root = removeMin(root);
        return res;
    }

    public Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E res = maxnum();
        root = removeMax(root);
        return res;
    }

    public Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    public Node remove(Node node,E e){
        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            remove(node.right, e);
            return node;
        }else {
            if (node.left == null){

            }
        }
        return null;
    }

    public static void main(String[] args) {
        BST<Integer> b = new BST<>();
        b.add(5);
        b.add(3);
        b.add(6);
        b.add(8);
        b.add(4);
        b.add(2);
        b.preOrder();
        b.removeMin();
        System.out.println();
        b.preOrder();
    }
}
