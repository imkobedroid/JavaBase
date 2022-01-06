package com.java.base.tree;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        BTS<Integer> bts = new BTS<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int a = 0; a < nums.length; a++) {
//            bts.add(nums[a]);
//        }
//        bts.preOrder();
//        System.out.println("----");
//        bts.inOrder();
//        System.out.println("----");
//        bts.postOrder();



        //测试removemin
//        BTS<Integer> bts = new BTS<>();
//        Random random=new Random();
//        int index = 100;
//        for (int a = 0; a < index; a++) {
//            bts.add(random.nextInt(100));
//        }
//
//        ArrayList<Integer> integers=new ArrayList<>();
//        while (!bts.isEmpty()){
//            integers.add(bts.removeMin());
//        }
//        System.out.println(integers);
//
//
//        for (int a =1;a<integers.size();a++){
//            if(integers.get(a-1)>integers.get(a)){
//                throw new IllegalArgumentException("error");
//            }
//        }
//        System.out.println("完成测试");




        //测试removemax
        BTS<Integer> bts = new BTS<>();
        Random random=new Random();
        int index = 100;
        for (int a = 0; a < index; a++) {
            bts.add(random.nextInt(100));
        }

        ArrayList<Integer> integers=new ArrayList<>();
        while (!bts.isEmpty()){
            integers.add(bts.removeMax());
        }
        System.out.println(integers);


        for (int a =1;a<integers.size();a++){
            if(integers.get(a-1)<integers.get(a)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("完成测试");
    }
}
