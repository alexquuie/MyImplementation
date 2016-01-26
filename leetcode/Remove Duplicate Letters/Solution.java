import java.util.*;

public class Solution {
    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length()==0){
            return "";
        }
        int [] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
        }
        Stack<Character> resultBuilder = new Stack<Character>();
        Boolean [] visited = new Boolean[26];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            int idx = cur-'a';
            //System.out.println(idx);
            count[idx]--;
            if(visited[idx] == true){
                continue;
            }
            while( !resultBuilder.isEmpty() && resultBuilder.peek()>cur  
                && count[resultBuilder.peek()-'a']>0){
                //System.out.println("Pop stack top: "+resultBuilder.peek());
                char tmpc = resultBuilder.pop();
                visited[tmpc-'a'] = false;
            }
            resultBuilder.push(cur);
            visited[idx] = true;
        }
        StringBuilder res = new StringBuilder();
        while(!resultBuilder.isEmpty()){
            char cur = resultBuilder.pop();
            res.append(cur);
        }
        res = res.reverse();
        return res.toString();
    }
    public static void main(String []args){
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}