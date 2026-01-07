package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamyTest {

    static int[][] pole = {
            {0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    @Test
    void DamyTest() {
        // found another element
        assertTrue(Damy.horizontal.test(pole, 0,0));
        assertTrue(Damy.vertical.test(pole, 0,0));

        // empty
        assertFalse(Damy.horizontal.test(pole, 0,3));
        assertFalse(Damy.vertical.test(pole, 1,0));

    }

}