package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamyTest {

    static int[][] pole = {
            {0, 0, 1, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 6, 0, 0},
            {0, 8, 0, 0, 0, 0, 0, 0}
    };

    @Test
    void DamyTest() {
        // found another element
        assertTrue(Damy.horizontal.test(pole, 0,0));
        assertTrue(Damy.vertical.test(pole, 0,0));

        // diag: left up
        assertTrue(Damy.diagonal.test(pole, 7,6));
        // diag: up right
        assertTrue(Damy.diagonal.test(pole, 7,4));
        // diag: left down
        assertTrue(Damy.diagonal.test(pole, 6,2));
        // diag: right down
        assertTrue(Damy.diagonal.test(pole, 6,0));

        // empty
        assertFalse(Damy.horizontal.test(pole, 3,3));
        assertFalse(Damy.vertical.test(pole, 5,7));
        assertFalse(Damy.diagonal.test(pole, 3,3));

    }

}