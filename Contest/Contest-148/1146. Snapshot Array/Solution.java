class SnapshotArray {
    
    //Define data structures
    List<Map<Integer, Integer>> snapshot;
    Map<Integer, Integer> changes;

    public SnapshotArray(int length) {
        snapshot = new ArrayList<>();
        changes = new HashMap<>();
    }
    
    public void set(int index, int val) {
        changes.put(index, val);
    }
    
    public int snap() {
        snapshot.add(changes);
        changes = new HashMap<>();
        return snapshot.size() - 1;
    }
    
    public int get(int index, int snap_id) {
        for(int i = snap_id; i >= 0; i--){
            if(snapshot.get(i).containsKey(index))
                return snapshot.get(i).get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */