package Java_Labs.Lab1;

import java.util.Scanner;

public class lab1 {

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextShort();
            double S = 0;
        System.out.print("Result: \n"+ "C2: " + num%2+ "\n" + "C3: " + num%3 + "\n" + "C5: " + num%5 + "\n" + "C7: " + num%7+ "\n");
        System.out.print("a:");
            short a = scan.nextShort();
        System.out.print("n:");
            short n = scan.nextShort();
        while(n <=a) {
        System.out.println("n must be greater than a");
        n = scan.nextShort();
    }
        System.out.print("b:");
             short b = scan.nextShort();
        System.out.print("m:");
             short m = scan.nextShort();
        while(m <=b) {
            System.out.println("m must be greater than b");
            m = scan.nextShort();
        }
        scan.close();
    if(a<= -num%3 && -num%3 <=n || b<=0 && 0<=m){
    System.out.println("ERR. Divide by zero");
        }  else{
    for( char i = (char) a; i<=n; i++ ){
        for(char j = (char) b; j<=m; j++){

            S+= ((double)i/j)/(i+num%3);

        }
    }
    System.out.println(S);
        }
    }
}
