package com.kabir.milton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter number in decimal system:");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println("Enter target base:");
        int b=sc.nextInt();
        String res="";
        if (b==2){
            res=Integer.toBinaryString(x);
        }
        else if(b==8){
            res=Integer.toOctalString(x);
        }
        else{
            res=Integer.toHexString(x);
        }
        System.out.println("Conversion result: "+res);
    }
}
