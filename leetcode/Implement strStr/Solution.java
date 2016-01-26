public class Solution {
	public void getNext(String needle, int [] next){
		next[0] = 0;
		int i=1, j=0;
		while(i<needle.length()){
			if(needle.charAt(j) == needle.charAt(i)){
				j++;
				next[i] = j;
				i++;
			}else if(j==0){
				i++;
			}else{
				j = next[j-1];
			}
		}
	}
    public int strStr(String haystack, String needle) {
    	if(needle.length()==0){
            return 0;
        }
        if(haystack.length()==0 && needle.length()!=0){
            return -1;
        }
    	int [] next = new int[needle.length()];
        getNext( needle, next);
        int i=0, j=0;
		while(i<haystack.length()){
			if( haystack.charAt(i) == needle.charAt(j) ){
				i++;
				j++;
				if(j==needle.length()){
					return i-j;
				}
			}else if(j==0){
				i++;
			}else{
				j = next[j-1];
			}
		}
		return -1;
    }
    public static void main(String []args){
    	Solution sl = new Solution();

    	String haystack1 = "AAAAAAAAAAAAAAAAAB";
   		String needle1 = "AAAAB";
   		System.out.println(sl.strStr( haystack1, needle1));
   		System.out.println("Index of needle in haystack is: "+haystack1.indexOf(needle1));
   		String haystack2 = "ABABDABACDABABCABAB";
   		String needle2 = "ABABCABAB";
   		System.out.println(sl.strStr( haystack2, needle2));
   		System.out.println("Index of needle in haystack is: "+haystack2.indexOf(needle2));
   		String haystack3 = "ABABDABACDABABCABAB";
   		String needle3 = "ABABCABABZ";
   		System.out.println(sl.strStr( haystack3, needle3));
   		System.out.println("Index of needle in haystack is: "+haystack3.indexOf(needle3));
    }
}