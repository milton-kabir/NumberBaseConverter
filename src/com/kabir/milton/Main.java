package com.kabir.milton;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            String[] st=sc.nextLine().split(" ");
            if(st.length==2){
                int a=Integer.parseInt(st[0]);
                int b=Integer.parseInt(st[1]);
                while(true){
                    System.out.println("Enter number in base "+a+" to convert to base "+b+" (To go back type /back)");
                    String ss=sc.nextLine();
                    if(ss.equals("/back")){
                        break;
                    }
                    String ans=convertInteger(ss,a,b);
                    System.out.println("Conversion result: "+ans);
                    System.out.println();
                }
            }
            else{
                break;
            }

//            else if(st.equals("/to")){
//                System.out.println("Enter source number:");
//                String s1=sc.nextLine();
//                System.out.println("Enter source base:");
//                String s2=sc.nextLine();
//                int b=Integer.parseInt(s2);
//                System.out.println("Conversion to decimal result: "+Integer.parseInt(s1,b));
//            }

        }
    }
    public static String convertInteger(String theValue, int initialBase, int finalBase) {

        BigInteger bigInteger = new BigInteger(theValue,initialBase);
        String value = bigInteger.toString(finalBase);
        value = value.toUpperCase();

        return value;
    }
}
