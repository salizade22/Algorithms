/*
@Author:Shakhzod Ali-zade
@Problem: Given number 1n  1≤n≤10^7, find the last digit of n-th Fibonacci number
*/


import java.util.Scanner;
class Main {

public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] a = new int[n+1];
    a[0]=0;  
    a[1]=1;
    if(n>=2){  
    for(int i=2;i<=n;i++){
        a[i] = (a[i-1] + a[i-2])%10;
    }
    }  
    System.out.print(a[n]);  
  }
  
}
