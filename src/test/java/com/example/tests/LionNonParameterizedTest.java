package com.example.tests;
import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LionNonParameterizedTest {

    @Mock
    Predator predator;
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testExceptionForInvalidSex() {
        try {
            new Lion("Неизвестный", predator);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного"));
        }
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }
}

