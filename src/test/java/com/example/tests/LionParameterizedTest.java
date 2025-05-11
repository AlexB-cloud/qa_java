package com.example.tests;

import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private  final boolean expectedHasMane;
    private final int expectedKittensCount;
    public  LionParameterizedTest(String sex, boolean expectedHasMane, int expectedKittensCount){
        this.sex=sex;
        this.expectedHasMane=expectedHasMane;
        this.expectedKittensCount=expectedKittensCount;
    }
    @Mock
    Feline feline;

    @Parameterized.Parameters()
    public static Object[][] getData() { // {"sexString",expectedHasMane ,expectedKittensCount}
        return new Object[][]{
                {"Самец", true, 3},
                {"Самка", false, 1}
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);

        assertEquals(expectedKittensCount, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
