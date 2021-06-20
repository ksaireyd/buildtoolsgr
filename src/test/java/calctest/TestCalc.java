package calctest;

import calculator.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sender.Sender;


@Listeners(listener.ListenerTest.class)
public class TestCalc {
        Calculator  calculator = new Calculator();

    @Test
    public void checkAdding(){
        Sender.sendletter();
        Assert.assertEquals(calculator.add(3,6),9);

    }
    @Test
    public void checkAddingsecond(){

        Assert.assertEquals(calculator.add(3,1),4);

    }
    @Test
    public void checkAddingfalse(){

        Assert.assertEquals(calculator.add(3,6),10);

    }
}
