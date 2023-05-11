public class BinaryTreeSum {

    // Node of each tree
    public static class treeNode{
        int key;
        treeNode left;
        treeNode right;

        public treeNode(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

  
    // Root of tree
    public treeNode root;

    public BinaryTreeSum(){
        root = null;
    }

  
    public int calculateSum(treeNode temp){
        int sum = 0;
        int sumLeft =  0;
        int sumRight = 0;

        // Check if tree is empty
        if(root == null){
            return 0;
        }
        else {
            // Calculate the nodes on the left
            if(temp.left != null)
                sumLeft = calculateSum(temp.left);

            // Calculate the nodes on the right
            if(temp.right != null)
                sumRight = calculateSum(temp.right);

            // Calculate the total nodes
            sum = temp.key + sumLeft + sumRight;
            return sum;
        }
    }
  

    public static void main(String[] args) {

        BinaryTreeSum btSum = new BinaryTreeSum();
        //Add nodes to the binary tree
        btSum.root = new treeNode(10);
        btSum.root.left = new treeNode(5);
        btSum.root.right = new treeNode(12);
        btSum.root.left.left = new treeNode(4);
        btSum.root.right.left = new treeNode(11);
        btSum.root.right.right = new treeNode(13);

        // Display the sum of all the nodes in the given binary tree
        System.out.println("Sum of all keys of binary tree: " + btSum.calculateSum(btSum.root));
    }
}
