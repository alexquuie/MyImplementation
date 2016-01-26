public class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, left = 0, right = 0, res = 0;
        Stack<Integer> buffer = new Stack<Integer>();
        for(int i=0;i<=s.length();i++){
            char cur = i<s.length()?s.charAt(i):'.';
            if(cur=='('){
                buffer.push(i);
                left++;
            }else{
                if(right>left){
                    left = 0;
                    right = 0;
                    buffer.clear();
                }else{
                    int topIdx = buffer.pop();
                    right++;
                    res = buffer.isEmpty() ? Math.max(res, 2*right) : Math.max(res, i - topIdx);
                }
            }
        }
        return res;
    }
    public static void main(String []args){
        
    }
}