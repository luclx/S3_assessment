package com.luclx.assessment16;

public class Assessment16 {

    static class Rectangle {
        long left;
        long top;
        long right;
        long bottom;
    }

    public boolean isIntersect(Rectangle r1, Rectangle r2) {
        if (r1.top < r2.bottom || r1.bottom > r1.top || r1.right < r2.left || r1.left > r2.right)
            return false;
        return true;
    }
}
