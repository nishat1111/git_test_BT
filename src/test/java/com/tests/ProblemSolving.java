package com.tests;

public class ProblemSolving {

/*If we list all the natural numbers below 10 that are multiples of 3 or 7, we get 3, 6, 7 and 9.
 The sum of these multiples is 25.
 What is the sum of multiples of 3, 7 for the natural numbers below 1000?
 */
  public void doSumOfMultiples(int num) {
        int sum =0;
        for (int i=1; i<num;i++) {
            if(i%3==0 || i%7==0 ) {
                //System.out.println(i);
                sum=sum+i;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
       // doSumOfMultiples();
        ProblemSolving obj=new ProblemSolving();
        obj.doSumOfMultiples(10);
        obj.doSumOfMultiples(1000);


    }
}
