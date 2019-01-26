package com.algo.arrays;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int x = A.size();
        int i = 0;
        while(i < x - 1 && A.get(i) == 0) {
            A.remove(i);
        }

        int carry = 1;
        int sum;

        for(i = A.size() - 1; i >= 0; i--) {
            sum = A.get(i) + carry;
            A.set(i, sum % 10);
            carry = sum/10;
            if(carry == 0) {
                break;
            }

        }

        if(carry != 0) {
            A.add(0, carry);
        }

        return A;
    }
}
