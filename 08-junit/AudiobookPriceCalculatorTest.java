package put.io.testing.audiobooks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import put.io.testing.junit.Calculator;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calculator;
    private Customer customer;
    private Audiobook audiobook;
    @BeforeEach
    public void setUp(){
        calculator = new AudiobookPriceCalculator();
        audiobook = new Audiobook("title", 100);
    }
    @Test
    public void testCalculate1(){
        customer = new Customer("1", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0, calculator.calculate(customer, audiobook));
    }
    @Test
    public void testCalculate2(){
        customer = new Customer("2", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }
    @Test
    public void testCalculate3(){
        customer = new Customer("3", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(0.9*audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }

    @Test
    public void testCalculate4(){
        customer = new Customer("4", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(0.8*audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }
}