/*
* Method: Maintaining 2 heaps: O(6.log(N)) & O(1)
*/
class MedianFinder {
    Queue<Integer> smallerNums;
    Queue<Integer> biggerNums;
    private boolean evenFlag;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        smallerNums = new PriorityQueue<>(Collections.reverseOrder());
        biggerNums = new PriorityQueue<>();
        this.evenFlag = true;
    }
    
    public void addNum(int num) {
        if(evenFlag){
            biggerNums.offer(num);
            smallerNums.offer(biggerNums.poll());
        }else{
            smallerNums.offer(num);
            biggerNums.offer(smallerNums.poll());
        }
        evenFlag = !evenFlag;
    }
    
    public double findMedian() {
        // System.out.println((double)smallerNums.peek() + (double)biggerNums.peek());
        if(evenFlag)
            return ((double)smallerNums.peek() + (double)biggerNums.peek())/2.0;
        else
            return ((double)smallerNums.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */