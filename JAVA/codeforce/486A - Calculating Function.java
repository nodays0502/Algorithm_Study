import java.util.*;
import java.io.*;

public class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long result = n/2;
        if(n % 2 == 1)
            result -= n ;
        System.out.println(result);
    }
}
