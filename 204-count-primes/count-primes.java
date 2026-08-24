class Solution {
    public int countPrimes(int n) {
       boolean count[] = new boolean[n];
       int ans = 0;
       for(int i = 2 ; i < n ; i++){
         if(count[i])
           continue;
         ans += 1;
         for(long mult = (long)i*i ; mult  < n ; mult+=i){
            count[(int)mult] = true;
         }
       }
       return ans;
    }
}