public class BinaryTree {
    private Object root;
    private BinaryTree left, right;

    public BinaryTree(Object root) {

        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
        this(root);
        if (left != null)
            this.left = left;
        if (right != null)
            this.right = right;
    }
    public BinaryTree(BinaryTree that) {

        this.root = that.root;
        if (that.left != null)
            this.left = new BinaryTree(that.left);
        if (that.right != null)
            this.right = new BinaryTree(that.right);
    }
    public int pathLength() {
        if (left == null && right == null)
            return 0;
        if (left == null)
            return right.pathLength() + right.size();
        if (right == null)
            return left.pathLength() + left.size();
        return left.pathLength() + right.pathLength() + size() - 1;
    }
    public int size() {
        if (left == null && right == null)
            return 1;
        if (left == null)
            return 1 + right.size();
        right.size();
        if (right == null)
            return 1 + left.size();
        return 1 + left.size() + right.size();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (left != null)
            sb.append(left + ",");
        sb.append(root);
        if (right != null)
            sb.append("," + right);
        return sb + "]";
    }
    public void parentAll(Object x, String str) {
        if (root.equals(x)) {           // x가 root 노드이면 str 출력
            System.out.print(str);
            return;
        }
        if (left != null) {         // left 노드가 존재하면 재귀호출 str에 합쳐줌
            left.parentAll(x, str + root + " ");
        }
        if (right != null) {        // right 노드가 존재하면 재귀호출 str에 합쳐줌
            right.parentAll(x, str + root + " ");
        }
    }
}


