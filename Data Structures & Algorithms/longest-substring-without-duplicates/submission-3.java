class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> subStringMap = new HashMap<>();
        int maxLength = 0;
        int right = 0;
        int left = 0;
        for (right = 0; right < s.length(); right++) {
            if (subStringMap.containsKey(s.charAt(right))
                && subStringMap.get(s.charAt(right)) >= left) {
                left = subStringMap.get(s.charAt(right)) + 1;
            }
            subStringMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left+1);
        }
        return maxLength;
    }
}
