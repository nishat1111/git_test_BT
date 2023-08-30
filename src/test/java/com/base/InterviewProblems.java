package com.base;

public class InterviewProblems {

   static void doSum(int num) {
        int sum=0;
        for(int i=0; i<num;i++)  {

            if (i%3==0 || i%7==0) {
                sum=sum+i;
            }
        }

        System.out.println(sum);

    }

    public static void main(String[] args) {
       doSum(10);
        doSum(1000);



    }


}
