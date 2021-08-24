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

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }


    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else return contains(node.right, e);
    }

    public E mininum(){
        if (root == null)
            return null;

        Node res = root.left;
        while(res.left!=null){
            res = res.left;
        }

        return res.e;
    }

    public static void main(String[] args) {
        BST<Integer> b = new BST<>();
        b.add(10);
        b.add(5);
        b.add(3);
        b.add(1);
        b.add(4);
        b.add(2);
        b.add(11);
        System.out.println(b.contains(4));
        System.out.println(b.mininum());
    }
}
