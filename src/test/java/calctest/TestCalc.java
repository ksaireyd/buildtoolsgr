package calctest;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestCalc {
        Calculator  calculator = new Calculator();
    @Test
    public void checkAdding(){

        Assert.assertEquals(calculator.add(3,6),9);
    }
}
