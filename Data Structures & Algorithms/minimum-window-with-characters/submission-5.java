class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> formed = new HashMap<>();
        int windowCount = 0;
        String minimumWindow = "";
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int needCount = need.size();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (need.containsKey(s.charAt(right))) {
                char c = s.charAt(right);
                formed.put(c, formed.getOrDefault(c, 0) + 1);
                if (formed.get(c) == need.get(c)) {
                    windowCount++;
                }
            }
            while (windowCount == needCount) {
                String subString = s.substring(left, right + 1);
                if (minimumWindow.isEmpty()) {
                    minimumWindow = subString;
                } else if (subString.length() < minimumWindow.length()) {
                    minimumWindow = subString;
                }
                if (need.containsKey(s.charAt(left))) {
                    char c = s.charAt(left);
                    formed.put(c, formed.get(c) - 1);
                    if (formed.get(c) < need.get(c)) {
                        windowCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return minimumWindow;
    }
}
