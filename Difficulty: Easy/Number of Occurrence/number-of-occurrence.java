class Solution {
    int countFreq(int[] arr, int target) {
        int first = firstocc(arr,target);
        int  last = lastocc(arr,target);
        if(last != -1 )
        return last-first+1;
        else
        return 0;
    }
    int firstocc(int[] arr, int target){
    int low = 0;
    int n = arr.length;
    int high = n - 1;
    int ans = 0;
    while(low <= high){
      int mid = (low+high)/2;
      if(arr[mid]==target){
          ans = mid;
          high = mid -1 ;
      }
      else if(arr[mid]>target)
           high = mid - 1;
      else
           low = mid + 1;
    }
    return ans;
}
int lastocc(int[] arr, int target){
    int low = 0;
    int n = arr.length;
    int high = n - 1;
    int ans = -1;
    while(low <= high){
      int mid = (low+high)/2;
      if(arr[mid]==target){
          ans = mid;
          low = mid + 1 ;
      }
      else if(arr[mid]>target)
           high = mid - 1;
      else
           low = mid + 1;
    }
    return ans;
}
}
