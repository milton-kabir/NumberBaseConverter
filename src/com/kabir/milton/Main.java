package com.kabir.milton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            String st=sc.nextLine();
            if(st.equals("/from")){
                System.out.println("Enter a number in decimal system:");
                String s1=sc.nextLine();
                int x=Integer.parseInt(s1);
                System.out.println("Enter the target base:");
                String s2=sc.nextLine();
                int b=Integer.parseInt(s2);
                String res;
                if (b==2){
                    res=Integer.toBinaryString(x);
                }
                else if(b==8){
                    res=Integer.toOctalString(x);
                }
                else{
                    res=Integer.toHexString(x);
                }
                System.out.println("Conversion to decimal result: "+res);
            }
            else if(st.equals("/to")){
                System.out.println("Enter source number:");
                String s1=sc.nextLine();
                System.out.println("Enter source base:");
                String s2=sc.nextLine();
                int b=Integer.parseInt(s2);
                System.out.println("Conversion to decimal result: "+Integer.parseInt(s1,b));
            }
            else{
                break;
            }
        }

    }
}
