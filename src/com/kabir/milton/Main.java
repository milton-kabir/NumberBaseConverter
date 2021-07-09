package com.kabir.milton;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz";

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
                    String ans=fromDecimal(toDecimal(ss, a), b, 5);
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
    static String toDecimal(String number, int radix) {
        BigDecimal result = BigDecimal.ZERO;

        String[] array = number.split("\\.");

        for (int i = 0; i < array[0].length(); i++) {
            int val = DIGITS.indexOf(array[0].charAt(i));
            result = result.add(BigDecimal.valueOf(val * Math.pow(radix, array[0].length() - 1 - i)));
        }

        if (array.length == 2) {
            for (int i = 0; i < array[1].length(); i++) {
                int val = DIGITS.indexOf(array[1].charAt(i));
                result = result.add(BigDecimal.valueOf(val * Math.pow(radix, (i + 1) * -1)));
            }
        } else {
            result = result.setScale(0);
        }

        return result.toString();
    }

    static String fromDecimal(String number, int radix, int scale) {
        StringBuilder result = new StringBuilder();

        String[] array = number.split("\\.");
        BigInteger integer = new BigDecimal(array[0]).toBigInteger();

        do {
            result.append(DIGITS.charAt(integer.divideAndRemainder(BigInteger.valueOf(radix))[1].intValue()));
            integer = integer.divide(BigInteger.valueOf(radix));
        } while (integer.compareTo(BigInteger.ZERO) > 0);
        result = result.reverse();

        if (array.length == 2) {
            result.append(".");
            BigDecimal remainder = new BigDecimal("0." + array[1]);
            for (int i = 0; i < scale; i++) {
                BigDecimal val = remainder.multiply(BigDecimal.valueOf(radix)).setScale(scale, RoundingMode.UP);
                remainder = val.remainder(BigDecimal.ONE);
                result.append(DIGITS.charAt(val.setScale(0, RoundingMode.DOWN).intValue()));
            }
        }

        return result.toString();
    }

}
