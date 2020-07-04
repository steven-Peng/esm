package net.chenlin.dp;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int[][] arrayN= new int[n][2];
        int i = 0;
        while (i < n && in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();
            arrayN[i][0] = x;
            arrayN[i][1] = y;
            i += 1;
        }
        System.out.println(getResult(n, e, arrayN));

    }

    static int getResult(int n, int e, int[][] arrayN){
        int sum = 0;
        for (int i = arrayN.length - 1; i >= 0 ; i--){
            int x;
            int y = getY(arrayN,i);
            if(i==arrayN.length - 1){
                x = e - arrayN[i][0];
            }else{
                x = arrayN[i+1][0] - arrayN[i][0];
            }
            sum += x*y;
        }
        return sum;
    }

    static int getY(int[][] array, int i){
        int y = 0;
        for (int j = 0; j < array.length ; j++){
            while(j <= i){
                y += array[i][1];
            }
        }
        return Math.abs(y);
    }
}
