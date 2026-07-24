class Solution {
    int completedCourses=0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        Map<Integer,List<Integer>> courseMap=new HashMap<>();
        for(int[] course:prerequisites){
            courseMap.computeIfAbsent(course[1], k -> new ArrayList()).add(course[0]);
            inDegree[course[0]]++;
        }
        isFinished(courseMap,inDegree,numCourses);
        if(completedCourses==numCourses){
            return true;
        }
        return false;
    }
    private void isFinished(Map<Integer,List<Integer>> courseMap,int[] inDegree,int numCourses){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
                completedCourses++;
            }
        }
        while(!q.isEmpty()){
            Integer course=q.remove();
            for(Integer inList:courseMap.getOrDefault(course, new ArrayList<>())){
                inDegree[inList]--;
                if(inDegree[inList]==0){
                    q.add(inList);
                    completedCourses++;
                }
            }
        }
    }
}

