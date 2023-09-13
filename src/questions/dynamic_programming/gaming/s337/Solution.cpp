/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    unordered_map<TreeNode*, int> memo1, memo0;
public:
    int rob(TreeNode* root) {
        return dfs(root, 1);
    }
    int dfs(TreeNode* root, int flag)
    {
        if (root==NULL) return 0;
        if (flag==0&&memo0.find(root)!=memo0.end())
        {
            return memo0[root];
        }
        if (flag==1&&memo1.find(root)!=memo1.end())
        {
            return memo1[root];
        }

        if (flag==0)
        {
            memo0[root]= dfs(root->left, 1)+dfs(root->right, 1);
            return memo0[root];
        }
        else
        {
            int opt1=root->val+dfs(root->left, 0)+dfs(root->right, 0);
            int opt2=dfs(root->left, 1)+dfs(root->right, 1);

            memo1[root]= max(opt1, opt2);
            return memo1[root];
        }
    }
};