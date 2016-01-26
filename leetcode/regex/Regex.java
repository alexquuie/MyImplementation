import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String []args)
    {
 		String pattern = "^((2[0-5]{2})|(1\\d{2})| (0{2}\\d) |( 0\\d{2}) |(\\d{1,2}))\\.((2[0-5]{2})|(1\\d{2})| (0{2}\\d) |( 0\\d{2}) |(\\d{1,2}))\\.((2[0-5]{2})|(1\\d{2})| (0{2}\\d) |( 0\\d{2}) |(\\d{1,2}))\\.((2[0-5]{2})|(1\\d{2})| (0{2}\\d) |( 0\\d{2}) |(\\d{1,2}))$";
        
        String IP = "122.122.111.11";
        System.out.println(IP.matches(pattern));
    }
}