public class Solution {
    public long toLong(String num){
        if(num.length() != 1
            && num.charAt(0) == '0'){
            return -1;
        }else{
            return  Long.parseLong(num);
        }
    }
    public boolean recur(String num, int idx, int len1) {
        for(int i = 1; idx+len1+i < num.length(); i++) {
            /* i is the length of the second number */ 
            /*if(j > 1 && num[idx + i] == '0'){
                // start with zero
                return false;
            }*/
            long num1 = toLong(num.substring(idx, len1+idx));
            System.out.println("From "+idx+" to "+(len1+idx) );
            long num2 = toLong(num.substring(idx+len1, idx+len1+i));
            System.out.println("From "+(idx+len1)+" to "+(idx+len1+i) );
            System.out.println(num1+" "+num2);
            if(num2 == -1){
                return false;
            }
            String curStr = num.substring(len1+idx+i);
            System.out.println("Index of next: "+ (num1+num2)+" is: "+curStr.indexOf(Long.toString(num1 + num2)) );
            System.out.println("Index of predicted: "+ 0 );
            if(curStr.indexOf(Long.toString(num1 + num2)) == 0){
                if(Long.toString(num1 + num2).length() +len1+idx+i == num.length() 
                    || recur(num, idx+len1, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i < num.length() / 2 + 1; i++){
            if(recur(num, 0, i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solution sl = new Solution();        
        System.out.println(sl.isAdditiveNumber("101"));
        System.out.println();
        
        System.out.println(sl.isAdditiveNumber("112358"));
        System.out.println();
        System.out.println(sl.isAdditiveNumber("198019823962"));
        
    }
}