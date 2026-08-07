class Solution {
    public int countSubstr(String s, int k) {
        return atmost(s,k) - atmost(s,k-1);
    }
    public int atmost(String s , int k){
        int left = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0 ; right < s.length() ; right++){
            map.put(s.charAt(right) , map.getOrDefault(s.charAt(right),0)+1);
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0)
                 map.remove(leftChar);
                left++;
            }
            result += right - left + 1;
        }
       return result; 
    }
}