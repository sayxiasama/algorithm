package tree;

/**
 * @ClassName:CustomBinaryTree
 * @Describe:
 * @Data:2020/5/1815:49
 * @Author:Ago
 * @Version 1.0
 */
public class CustomBinaryTree {
    private  TreeNode tree;

    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (data < p.getData()) {
                p = p.getLeft();
            } else if (data > p.getData()) {
                p = p.getRight();
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }
        TreeNode p = tree;
        while (p != null) {
            if (p.getData() < data) {
                if (p.getRight() == null) {
                    p.setRight(new TreeNode(data));
                    return;
                }
                p = p.getRight();
            } else {
                if (p.getLeft() == null) {
                    p.setLeft(new TreeNode(data));
                    return;
                }
                p = p.getLeft();
            }
        }
    }

    public void remove(int data){
        //tip:
        //case 1. 需要删除的结点为叶子节点, 将父结点中指向该删除结点的指针指为null
        //case 2. 需要删除的结点有一个结点(左子节点 || 右子节点), 将父结点中指向该删除结点的指针指为该结点的子节点
        /*
          case 3. 需要删除的结点有两个子节点(左 && 右)
            找到删除结点右子树中的最小的结点(即右子树中左树下的叶子节点) 将该结点替换指需要删除的结点位置,并删除这个最小节点
         */
        TreeNode p = tree;
        TreeNode pp = null;
        while(p != null && p.getData() != data){
            pp = p;
            if(p.getData() > data){
                p = p.getLeft();
            }else{
                p = p.getRight();
            }
        }
        if( p == null ){return;}

        //删除的结点有两个子节点
        if(p.getLeft() != null && p.getRight() != null) {
            TreeNode minP = p.getRight();
            TreeNode minPP = p;
            while(minP.getLeft() != null){
                minPP = minP;
                minP = minP.getLeft();
            }
            p.setData(minP.getData());
            p = minP;
            pp= minPP;
        }
        //删除的结点只有一个叶子节点或者只有一个子节点
        TreeNode child; //删除结点的子节点
        if(p.getLeft()!=null){
            child = p.getLeft();
        }else if(p.getRight() != null){
            child = p.getRight();
        }else{
            child = null;
        }

        if(pp == null ){
            tree = child;
        }else if(pp.getLeft() == p){
            pp.setLeft(child);
        }else{
            pp.setRight(child);
        }
    }


    //前序遍历
    public void preOrderPrint(TreeNode root){
        if(root == null ){return ;}
        System.out.println(root.getData());//打印本身
        if(root.getLeft() != null){
            preOrderPrint(root.getLeft());
        }
        if(root.getRight() != null ){
            preOrderPrint(root.getRight());
        }
    }

    //中序遍历
    public void inOrderPrint(TreeNode root){
        if(root == null){return;}
        if(root.getLeft() != null){
            inOrderPrint(root.getLeft());
        }
        System.out.println(root.getData());
        if(root.getRight() != null ){
            inOrderPrint(root.getRight());
        }
    }

    //后序遍历
    public void postOrderPrint(TreeNode root){
        if(root == null){return;}
        if(root.getLeft() != null){
            postOrderPrint(root.getLeft());
        }
        if(root.getRight() != null ){
            postOrderPrint(root.getRight());
        }
        System.out.println(root.getData());
    }

    public int finMin(){
        TreeNode p = tree;
        if(p == null ){return -1;}
        while(p.getLeft() != null){
            p = p.getLeft();
        }
        return p.getData();
    }

    public int finMax(){
        TreeNode p = tree;
        if(p == null ){return -1;}
        while(p.getRight() != null){
            p = p.getRight();
        }
        return p.getData();
    }


    public static void main(String[] args) {
        CustomBinaryTree tree = new CustomBinaryTree();
        tree.insert(50);
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(70);
        tree.insert(80);
        tree.insert(90);
        tree.insert(65);
//        tree.preOrderPrint(tree.tree);
        tree.inOrderPrint(tree.tree);
//        tree.postOrderPrint(tree.tree);
        System.out.println("-----------------------beforeRemove");
        tree.remove(70);
        tree.inOrderPrint(tree.tree);
//        System.out.println(tree.finMin());
//        System.out.println(tree.finMax());
    }

}
