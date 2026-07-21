class Solution {
    public int noOf(int arr[] , int val){
        int cows = 1;
        int dis = arr[0];
        for(int num : arr){
           if(num - dis >= val){
               dis = num;
               cows++;
           }
        }
        return cows;
    }
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 1;
        int n = arr.length;
        int high = arr[n-1]-arr[0];
        
        while(low <= high){
            int mid = (low + high)/2;
            int cows = noOf(arr,mid);
            if(cows >= k){
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return high;    
    }
}