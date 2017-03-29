package rental;

import org.junit.Test;

public class RentalPriceCalculatorTest {

	private RentalPriceCalculator calculator;

	@Test
	public void CalculatePrice(){
		calculator = new RentalPriceCalculator();
		calculator.price(20,4,3,false,true,true);
	}

    @Test
    public void CalculatePrice1(){
        calculator = new RentalPriceCalculator();
        calculator.price(21,4,3,false,true,true);
    }

    @Test
    public void CalculatePrice2(){
        calculator = new RentalPriceCalculator();
        calculator.price(22,4,3,false,true,true);
    }
}
