
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CalculatorTest {

    private Calculator calculator;
    @BeforeEach

    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void addOneAndTow_ReturnsThree() {


        //arrange
        Calculator calculator = new Calculator();

        //act
        var result = calculator.add(1, 2);

        //assert
        //expect, what you actaully got
        assertEquals(3, result);
    }


    @Test
    public void subtractOneFromTow_ReturnOne() {
        Calculator calculator = new Calculator();

        var result = calculator.subtract(4,2);

    }

    @Test
    public void divideByZero_ThrowException (){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {calculator.divide(10, 0); });
        }

        //multiple test




        @ParameterizedTest
        @CsvSource({"1,2,3", "10,5,15", "100,3,103"})
        public void testAdd (double a, double b, double  expected){
            assertEquals( expected, calculator.add(a,b), () -> a + "+" + b, "should eqaul " + expected);
        }


    }

