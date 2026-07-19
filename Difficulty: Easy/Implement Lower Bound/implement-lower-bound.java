class Solution {
    int lowerBound(int[] arr, int target) {
        int i = 0;
        int h = arr.length-1;
        int ans = arr.length;
        while(i <= h){
            int mid = (i+h)/2;
            if(arr[mid] >= target){
                ans = mid;
                h = mid -1; 
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }
}
