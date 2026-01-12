package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiagTest {

    @Test
    public void testDiag() {
        int columns[] = {-1, 1, -1, -1, -1, -1, -1, -1};
        assertFalse(Diag.isSafe(0, 0, columns));
    }

    @Test
    public void testDiag2() {
        int columns[] = {-1, 2, -1, -1, -1, -1, -1, -1};
        assertTrue(Diag.isSafe(0, 0, columns));
    }

}