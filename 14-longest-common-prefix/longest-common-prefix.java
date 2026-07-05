import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) return res;       
        if (strs.length == 1) return strs[0];   

        Arrays.sort(strs);

        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                res = strs[0].substring(0, i + 1); 
            } else {
                break; 
            }
        }
        return res;
    }
}