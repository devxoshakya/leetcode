class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        chomu(root, li);
        return li;
    }
    public void chomu(TreeNode root, List<Integer> li){
        if(root==null){
            return;
        }
        chomu(root.left,li);
        chomu(root.right,li);
        li.add(root.val);
    }
}