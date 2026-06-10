class Solution {

    static void solve(char[] a,int s,int e){
     if(s>=e){
        return ;
     }

     char temp=a[s];
     a[s]=a[e];
     a[e]=temp;
     solve(a,s+1,e-1);
    }

    public void reverseString(char[] s) {
        solve(s,0,s.length-1);
    }
}