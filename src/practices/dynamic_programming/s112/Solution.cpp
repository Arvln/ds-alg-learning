class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        return dp(root, root, targetSum);
    }
    bool dp(TreeNode* root, TreeNode*parent, int targetSum)
    {
        if (parent==nullptr) return false;
        if (root==nullptr&&root==parent->left)
            return parent->right==nullptr&&targetSum==0;
        if (root==nullptr&&root==parent->right)
            return parent->left==nullptr&&targetSum==0;

        return dp(root->left, root, targetSum-root->val)||dp(root->right, root, targetSum-root->val);
    }
};