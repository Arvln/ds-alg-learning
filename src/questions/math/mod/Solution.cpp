class Solution {
    int base=1337;
public:
    int pod_mod(int a, int b)
    {
        if (b==0) return 1;
        a%=base;

        if (b%2==1)
            return (a* pod_mod(a, b-1)) % base;
        else
        {
            int sub= pod_mod(a, b/2);
            return (sub*sub) % base;
        }
    }
    int superPow(int a, vector<int>& b) {
        if (b.empty()) return 1;

        int last=b.back();
        b.pop_back();
        int part_a=pod_mod(a, last);
        int part_b=pod_mod(superPow(a, b), 10);

        return (part_a * part_b) % base;
    }
};