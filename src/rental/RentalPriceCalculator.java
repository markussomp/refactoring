package rental;

public class RentalPriceCalculator {
	
	// driverAge - age of driver
	// licence - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// inAccidentsLastYear - has s/he caused any accidents within last year
	// inAccidents - has s/he participated (but not caused) in any accidents within last year
	// isSeason - if it is high season or not
	public double price(int driverAge, int licence, int carClass, boolean inAccidentsLastYear, boolean inAccidents, boolean isSeason) {

		CheckAgeAndCarClass(driverAge, carClass);
		CheckIfDriverHoldsLicenceAtLeastForOneYear(licence);

		return CalculateRentalPrice(driverAge, licence, carClass, inAccidentsLastYear, isSeason);
	}

	public double CalculateRentalPrice(int driverAge, int licence, int carClass, boolean inAccidentsLastYear, boolean isSeason) {
		double rentalPrice = driverAge;

		if (carClass >=4 && driverAge <= 25 && isSeason == true) {
			rentalPrice = rentalPrice * 1.5;
		}

		if (licence <= 3) {
			rentalPrice = rentalPrice * 1.3;
		}

		if (inAccidentsLastYear == true && driverAge < 30) {
			rentalPrice += 15;
		}

		if (rentalPrice > 1000) {
			return 1000.00;
		}

		return rentalPrice;
	}

	public void CheckIfDriverHoldsLicenceAtLeastForOneYear(int licence) throws IllegalArgumentException {
		if (licence <= 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	public void CheckAgeAndCarClass(int driverAge, int carClass) throws IllegalArgumentException, UnsupportedOperationException {
		if (driverAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (driverAge <= 21 && carClass >= 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
	}
}