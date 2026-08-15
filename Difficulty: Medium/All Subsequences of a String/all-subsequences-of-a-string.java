class Solution {
    public List<String> powerSet(String s) {
        List<String>list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        generate(s,0,list,curr);
        Collections.sort(list);
        return list;
    }
    public void generate(String s , int index , List<String>list , StringBuilder curr){
        if(index == s.length()){
           list.add(curr.toString());
            return;
        }
        generate(s,index+1,list,curr);
        curr.append(s.charAt(index));
        generate(s,index+1,list,curr);
        curr.deleteCharAt(curr.length() - 1);
    }
}