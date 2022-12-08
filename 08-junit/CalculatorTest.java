package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void testAdd(){
        assertEquals(15, calculator.add(10, 5));
        assertEquals(8, calculator.add(4, 4));
        assertEquals(-1, calculator.add(0, -1));
    }

    @Test
    public void testMultiply(){
        assertEquals(15, calculator.multiply(3, 5));
        assertEquals(8, calculator.multiply(2, 4));
        assertEquals(-4, calculator.multiply(4, -1));
    }

    @Test
    public void testAddPositiveNumbers(){
        assertThrows(IllegalArgumentException.class, ()->calculator.addPositiveNumbers(-5, 10));
    }
}

class FailureOrErrorTest{
    @Test
    public void test1(){
        assertEquals(1, 2);
    }

    @Test
    public void test2(){
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.addPositiveNumbers(-5, 10));
    }

    @Test
    public void test3(){
        try{
            assertEquals(1, 2);
        }
        catch(Throwable e){
            System.out.println(e.getClass());
            e.printStackTrace();
        }
    }
}