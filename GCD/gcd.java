/*
@Author: Shakhzod Ali-zade
@Problem: Given two numbers a and b, such that 1 ≤ a,b ≤ 2⋅10^9, find their greatest common divisor
*/

import java.util.Scanner;
class Main {

  public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      long a = kb.nextLong();
      long b = kb.nextLong();
      System.out.print(gcd(a,b));
  }
    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
    
}
