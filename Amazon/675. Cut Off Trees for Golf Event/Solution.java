class Solution {
    
    private final int[] row_n = new int[]{-1,1,0,0};
    private final int[] col_n = new int[]{0,0,-1,1};
    // 
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] l1, int[] l2){
                return l1[0] - l2[0];
            }
        });
        
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(0).size(); j++){
                if(forest.get(i).get(j) > 1)
                    heap.offer(new int[]{forest.get(i).get(j), i, j});
            }
        }
        
        int source_r = 0;
        int source_c = 0;
        int result = 0;
        while(heap.size() > 0){
            int[] temp = heap.poll();
            
            int distance = bfs(forest, source_r, source_c, temp[1], temp[2], 0);
            System.out.println(distance + " for " + temp[1] + " and " + temp[2]);
            if(distance == -1)
                return -1;
            result += distance;
            
            source_r = temp[1];
            source_c = temp[2];
            
        }
        
        return result;
    }
    
    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc, int distance){
        Queue<List<Integer>> queue = new LinkedList<>();
        Queue<List<Integer>> next_queue = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        
        List<Integer> point = new ArrayList<Integer>();
        point.add(sr);
        point.add(sc);
        queue.add(point);
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                point = queue.poll();
                int row = point.get(0);
                int col = point.get(1);
                if(forest.get(row).get(col) == forest.get(tr).get(tc))
                    return distance;
                
                for(int k = 0; k < 4; k++){
                    if(isSafe(forest, visited, row + row_n[k], col + col_n[k])){
                        visited[row + row_n[k]][col + col_n[k]] = true;
                        List<Integer> temp = new ArrayList<>();
                        temp.add(row + row_n[k]);
                        temp.add(col + col_n[k]);
                        next_queue.add(temp);
                    }
                }
            }
            
            if(queue.isEmpty() && !next_queue.isEmpty()){
                queue = next_queue;
                next_queue = new LinkedList<>();
                distance++;
            }
        }
        
        return -1;
    }
    
    private boolean isSafe(List<List<Integer>> forest, boolean[][] visited, int row, int col){
        return (row >= 0 && row < forest.size() && col >= 0 && col < forest.get(0).size() && !visited[row][col] && forest.get(row).get(col) >= 1);
    }
}