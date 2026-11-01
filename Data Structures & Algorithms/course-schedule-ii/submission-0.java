class Solution {
    Map<Integer,List<Integer>> preMap=new HashMap<>();
    private Set<Integer> visiting=new HashSet<>();
    private Set<Integer> visited=new HashSet<>();
    List<Integer> result=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++) {
            preMap.put(i,new ArrayList<>());
        }
        for(int[] prereq:prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for(int c=0;c<numCourses;c++) {
            if(!dfs(c)) {
                return new int[0];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean dfs(int crs) {
        if(visiting.contains(crs)) {
            return false;
        }
        if(visited.contains(crs)) {
            return true;
        }
        visiting.add(crs);
        for(int pre:preMap.get(crs)) {
            if(!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(crs);
        visited.add(crs);
        result.add(crs);
        return true;
    }
}