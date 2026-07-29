class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> map=new HashMap<>();
        List<List<String>> group=new ArrayList<>();
        int index=0;
        for(String s:strs){
            char[] stringToArr=s.toCharArray();
            Arrays.sort(stringToArr);
            String arrToString=new String(stringToArr);
            if(map.containsKey(arrToString)){
                group.get(map.get(arrToString)).add(s);
            }else{
                map.put(arrToString,index);
                group.add(new ArrayList());
                group.get(index).add(s);
                index++;
            }
        }
        return group;
    }
}
