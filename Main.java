package com.company;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[20000];
        for (int i = 0; i < arr.length; i++) { //filling array with random numbers
            arr[i] = rd.nextInt();
            System.out.println(arr[i]); // for 20000 elements we don't need this (I tried, my PC was ok:)
        }
        long StartTime = System.currentTimeMillis();
        Sorting(arr);
        long EndTime = System.currentTimeMillis();
        System.out.println("it took" + TimeUnit.MILLISECONDS.toSeconds(EndTime - StartTime));
        //counts time needed for sorting
    }

    public static void Sorting(int[] arr) {//method for sorting
        int LoopCounter1 = 0, LoopCounter2 = 0;
        for (int counter1 = 1; counter1 < arr.length; counter1++) //start sort array from second element
        {
            int temp = arr[counter1]; //write element we chose to sort to temporary value
            int counter2 = counter1 - 1;
            while (counter2 >= 0 && (arr[counter2] > temp)) // check if new element for sorting is smaller than
            // some other elements starting from bigger already sorted element
            {
                arr[counter2 + 1] = arr[counter2]; //move previous element to the next (bigger) position in array
                counter2 = counter2 - 1; // move counter 1 position down in array
                LoopCounter1 = LoopCounter1 + 1; //counts loops
            }
            arr[counter2 + 1] = temp; //after moving up bigger numbers write in correct position element to be sorted
            LoopCounter2 = LoopCounter2 + 1; //also count loops as we have loop in loop

        }
        System.out.println("After sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); // printing each sorted array element(no need for 20000 elements)
            //(I also tried, my PC was ok:) even for 200000 elements

        }
        System.out.println("Loops used" + (LoopCounter1 + LoopCounter2));//print how many loops our sorting used
    }


}



