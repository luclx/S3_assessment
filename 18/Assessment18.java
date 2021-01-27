package com.sin.buildingInsights.data.repository;

public class Assessment18 {

    public boolean isPrimeNumber(long number) {
        if (number < 2)
            return false;
        
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
