//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minimumSum(string s) {
        // code here
        int ans =0;
        
        int n=s.size();
        
        // the loop to make half the string ideal palindromic if possible
        
        for(int i=0; i<n/2; i++)
        {
            if(s[i] == '?' && s[n-i-1] != '?'){
                s[i] = s[n-i-1];
            }
            else if( (s[i] != s[n-i-1] )&& (s[i]!='?' && s[n-i-1] != '?' ) ){
                return -1;
            }
            // this loop will make the half palindrome string if possible
        }
        
        // find the minimum sum difference
        
        char prevChar='.';
        
        for(int i=0;i<n/2;i++){
            if(s[i]!='?'){
                if(prevChar=='.'){
                    prevChar=s[i];
                }else if(s[i]!=prevChar){
                    ans+=abs(s[i]-prevChar);
                }
                prevChar=s[i];
            }
        }
        
        // for final result we include the right part also 
        // so we simply multiply by 2 in ans
        
        return 2*ans;
        
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;

        Solution ob;
        int ans = ob.minimumSum(s);
        cout << ans;
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends