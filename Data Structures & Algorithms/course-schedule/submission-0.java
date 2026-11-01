class Solution {
    Map<Integer,List<Integer>> coursemap=new HashMap<>();
    private Set<Integer> visiting=new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++) {
            coursemap.put(i,new ArrayList<>());
        }
        for(int[] prereq:prerequisites) {
            coursemap.get(prereq[0]).add(prereq[1]);
        }
        for(int c=0;c<numCourses;c++) 
        {
            if(!dfs(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int crs) {
        if (visiting.contains(crs)) {
            return false;
        }
        if (coursemap.get(crs).isEmpty()) {
            return true;
        }
        visiting.add(crs);
        for(int pre:coursemap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(crs);
        coursemap.put(crs,new ArrayList<>());
        return true;
    }
}
