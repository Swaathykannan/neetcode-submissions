class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] stringToArr=s.toCharArray();
            Arrays.sort(stringToArr);
            String arrToString=new String(stringToArr);
            map.computeIfAbsent(arrToString, k -> new ArrayList()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
