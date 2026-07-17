class Solution {
    public int maxProfit(int[] arr) {
        int max = 0;
        int n = arr.length;
        int d = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i]< d)
              d = arr[i];
            else 
              profit = arr[i]-d;
            max = Math.max(max,profit);
        }
        return max;
    }
}