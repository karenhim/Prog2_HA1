package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    //Teilaufgabe 1
    @Test
    @DisplayName("Should display result after subtracting 2 single digit numbers")
    public void testBasicSubtraction(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "6";
        String actual=calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2.1
    @Test
    @DisplayName("Should display error when calculating inverse of 0")
    public void testInverseZero(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String actual = calc.readScreen();

        String expected="Error";

        assertEquals(expected,actual);
    }
    //Teilaufgabe 2.2
    @Test
    @DisplayName("Should correctly handle new input after binary operations")
    void testWeirdFunctinalityOfPressDigitKey(){
        Calculator calc=new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressDigitKey(3);

        String expected="53";
        String actual=calc.readScreen();

        assertEquals(expected,actual);
    }

    //Teilaufgabe 2.3
    @Test
    @DisplayName("Should correctly handle negative operands in binary operations")
    public void testAdditionOfnegatives(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected="2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

