package com.example.tests;
import com.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int inputCount;
    private final int expectedCount;
    private final Feline feline;
    public FelineParameterizedTest(int inputCount, int expectedCount) {
        this.inputCount = inputCount;
        this.expectedCount = expectedCount;
        this.feline = new Feline();
    }
@Parameterized.Parameters
public static Object[][] kittensDataProvider() {
    return new Object[][] {
            {0, 0},
            {1, 1},
            {5, 5},
            {-1, -1}
    };
}
    @Test
    public void testGetKittensWithDifferentCounts() {
        assertEquals(expectedCount, feline.getKittens(inputCount));
    }
}

