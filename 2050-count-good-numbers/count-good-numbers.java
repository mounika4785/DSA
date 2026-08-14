class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
     long even = (n+1) / 2 ;
     long odd = n / 2;
     long result = power(5,even);
     result = (result * (power(4,odd)))%mod;
     return (int)result;
    }
    public long power(long base , long expo){
        long res = 1;
        while(expo > 0){
            if(expo % 2 == 1){
               res = (res * base)%mod;
            }
            base = (base * base)%mod;
            expo /= 2;
        }
    
    return res;
}
}