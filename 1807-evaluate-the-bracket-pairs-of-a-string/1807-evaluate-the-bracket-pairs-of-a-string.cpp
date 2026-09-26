class Solution {
public:
    string evaluate(string s, vector<vector<string>>& k) {
          unordered_map<string, string> km;

        for (auto &a : k)
        {
        km[a[0]] = a[1];
        }
        string res;

        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '(')
            {
                int clIdx = s.find(')', i + 1);
                string key = s.substr(i + 1, clIdx - i - 1);
                if (km.count(key))
                {
                    res += km[key];
                }
                else
                {
                    res += '?';
                }
                i = clIdx;
            }
            else
            {
                res += s[i];
            }
        }
        return res;
    }
};