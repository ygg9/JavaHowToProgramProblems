package Week1;

import java.util.Arrays;

public class Chapter7 {
    public static void main(String[] args){
        a();
        b();
        c();
        d();
        e();
    }

    //Display the value of element 6 of array f.
    public static void a(){
        int[] f = {0, 1, 2, 3, 4, 5};
        System.out.println(f[5]);
    }
    //Initialize each of the five elements of one-dimensional integer array g to 8.
    public static void b(){
        int[] g = new int[8];
        for (int i = 0; i<5; i++){
            g[i] = 8;
            System.out.println("g[" + i + "]: " + g[i]);
        }
    }

    //Total the 100 elements of floating-point array c.
    public static void c(){
        float[] c = new float[100];
        float total = 0;
        Arrays.fill(c, 4);
        for (int j = 0; j < 100; j++){
            total += c[j];
        }
        System.out.println(total);
    }

    //Copy 11-element array a into the first portion of array b, which contains 34 elements.
    public static void d(){
        int[] a = new int[11];
        int [] b = new int [34];
        Arrays.fill(a, 1);
        Arrays.fill(b, 2);
        for (int k = 0; k < 11; k++){
            b[k] = a[k];
        }
        for( int bLoop = 0; bLoop < b.length; bLoop++){
            System.out.println(b[bLoop]);
        }
    }

    //Determine and display the smallest and largest values contained in 99-element floating-
    //point array w.
    public static void e(){
        float smallest = 1000000;
        float largest = 0;
        float [] w = new float[99];
        for(int l = 0; l<99; l++){
            w[l] = l;
        }
        for(int wLoop = 0; wLoop<99; wLoop++){
            if(w[wLoop] < smallest){
                smallest = w[wLoop];
            }
            if (w[wLoop] > largest){
                largest = w[wLoop];
            }
        }
        System.out.println(smallest + " " + largest);
    }
}

