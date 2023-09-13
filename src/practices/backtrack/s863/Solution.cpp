class Solution {
    vector<int> ret;
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        dfs(root, target, k);
        return ret;
    }
    int dfs (TreeNode* root, TreeNode* target, int k)
    {
        if (root==NULL) return -1;
        if (root==target)
        {
            fetch(root, k);
            return 0;
        }

        int depth1=dfs(root->left, target, k);
        if (depth1!=-1)
        {
            if (depth1==k-1) ret.push_back(root->val);
            else fetch(root->right, k-depth1-2);

            return depth1+1;
        }

        int depth2=dfs(root->right, target, k);
        if (depth2!=-1)
        {
            if (depth2==k-1) ret.push_back(root->val);
            else fetch(root->left, k-depth2-2);

            return depth2+1;
        }

        return -1;
    }
    void fetch(TreeNode* root, int depth)
    {
        if (root==NULL) return;
        if (depth==0)
        {
            ret.push_back(root->val);
            return;
        }

        fetch(root->left, depth-1);
        fetch(root->right, depth-1);
    }

    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<int, vector<int>> g;
        dfsGraph(root, g);

        vector<int> ret;
        unordered_set<int> visited;
        queue<int> q;
        q.push(target->val);
        visited.insert(target->val);
        int step=0;
        while(!q.empty()&&step<=k)
        {
            int size=q.size();
            while(size--)
            {
                int cur=q.front();
                q.pop();

                if (step==k)
                    ret.push_back(cur);

                for (int next : g[cur]) {
                    if (visited.find(next)!=visited.end()) continue;
                    q.push(next);
                    visited.insert(next);
                }
            }
            step++;
        }

        return ret;
    }
    void dfsGraph(TreeNode* root, unordered_map<int, vector<int>>& g)
    {
        if (root==NULL) return;

        if (root->left!=NULL)
        {
            g[root->val].push_back(root->left->val);
            g[root->left->val].push_back(root->val);
        }
        if (root->right!=NULL)
        {
            g[root->val].push_back(root->right->val);
            g[root->right->val].push_back(root->val);
        }

        dfsGraph(root->left, g);
        dfsGraph(root->right, g);
    }
};