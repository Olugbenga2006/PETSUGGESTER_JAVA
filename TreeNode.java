//Tree class
class TreeNode{
    TreeNode right,left;
    String value;
    // a public constructor for a leaf node
    public TreeNode(String value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    //a public constructor for a tree node
    public TreeNode(String value, TreeNode left, TreeNode right){
        this.value=value;
        this.left=left;
        this.right=right;
    }
    // print method which prints the value of a node, and is adjusted for question and answer
    public void  print(){
        if (getLeft()!= null && getRight()!=null){
            System.out.println(value + "[y/n]");}
        else {
            System.out.println(value);
        }

    }
    public void setleaf(String value){
        this.value= value;
    }
    // a setter method to modify a node
    public void setnode(String value, TreeNode leftnode, TreeNode rightnode){
        this.value= value;
        this.left=leftnode;
        this.right=rightnode;
    }
    public TreeNode getLeft() {
        if (left == null) {
            return null;
        }return left;}


    public TreeNode getRight() {
        if (right == null) {
            return null;
        }return right;
    }
    // a method used to see if a node is not a leaf

    public boolean isLeaf(){
        Boolean a=false;
        if(left==null && right==null){
            a=true;
        }
        return a;
    }
}
