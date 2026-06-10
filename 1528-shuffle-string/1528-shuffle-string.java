class Solution {
    public String restoreString(String s, int[] a) {
      char[] b=new char[s.length()];

      for(int i=0;i<s.length();i++){
        b[a[i]]=s.charAt(i);
      }
      return new String(b);
    }
}