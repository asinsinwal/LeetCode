class Solution {
    
    // Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        utilBacktracking(result, "", 0, 0, n);
        return result;
    }
    
    private void utilBacktracking(List<String> result, String str, int open, int close, int n){
        if(str.length() == n*2){
            result.add(str);
            return;
        }
        
        if(open < n)
            utilBacktracking(result, str + "(", open + 1, close, n);
        if(close < open)
            utilBacktracking(result, str + ")", open, close + 1, n);
    }
}