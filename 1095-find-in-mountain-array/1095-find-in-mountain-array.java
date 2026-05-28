/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int t, MountainArray mountainArr) {
        int  peak =findMaxInMountainArray(mountainArr);
        int firstTry=orderAgnosticSearch(mountainArr,t,0,peak,true);
        if(firstTry!=-1){
            return firstTry;
        }
    return orderAgnosticSearch(mountainArr,t,peak+1,mountainArr.length()-1,false);
    }

     static int orderAgnosticSearch(MountainArray a,int t,int s,int e ,boolean isAsc){
        while(s<=e){
            int m=s+(e-s)/2;
            int midVal=a.get(m);
            if(midVal==t){
                return m;
            }
            
            if(isAsc){

                if(midVal>t){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }else{
                if(midVal<t){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }
        }return -1;
    }

     static int findMaxInMountainArray(MountainArray a) {
        int s = 0;
        int e = a.length() - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (a.get(m) > a.get(m+1)) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}