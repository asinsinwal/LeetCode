class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        
        for(int[] list: prerequisites){
            if(!prereqMap.containsKey(list[0]))
                prereqMap.put(list[0], new HashSet<>());
            
            prereqMap.get(list[0]).add(list[1]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for(Integer key: prereqMap.keySet()){
            visited.add(key);
            
            for(Integer checkCourse: prereqMap.get(key))
                if(!passThrough(prereqMap, checkCourse, visited))
                    return false;
            
            visited.remove(key);
        }
        
        return true;
    }
    
    
    private boolean passThrough(Map<Integer, Set<Integer>> map, Integer course, Set<Integer> visited){
        visited.add(course);
        
        if(map.containsKey(course)){
            for(Integer prereqCourse: map.get(course)){
                if(visited.contains(prereqCourse))
                    return false;
                if(!passThrough(map, prereqCourse, visited))
                    return false;
            }
        }
        visited.remove(course);
        
        return true;
    }
}