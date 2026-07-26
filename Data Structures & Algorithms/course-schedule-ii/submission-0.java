class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        int[] prereqCount = new int[numCourses];
        List<Integer> courseOrder = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        for (int[] course : prerequisites) {
            courseMap.computeIfAbsent(course[1], k -> new ArrayList()).add(course[0]);
            prereqCount[course[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (prereqCount[i] == 0) {
                q.add(i);
                courseOrder.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer course = q.remove();
            for (Integer i : courseMap.getOrDefault(course, new ArrayList<Integer>())) {
                prereqCount[i]--;
                if (prereqCount[i] == 0) {
                    q.add(i);
                    courseOrder.add(i);
                }
            }
        }
        if (courseOrder.size() == numCourses) {
            return courseOrder.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }
}
