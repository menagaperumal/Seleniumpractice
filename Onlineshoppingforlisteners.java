package day52_listeners_extent_reports;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(day52_listeners_extent_reports.Listeners_utility.class)
public class Onlineshoppingforlisteners {
	
	
	@Test(priority = 1)
	void registerUser() {
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	void login() {
		Assert.assertTrue(true);
	}

	@Test(priority = 3)
	void searchProduct() {
		Assert.assertTrue(true);
	}

	@Test(priority = 4)
	void addToCart() {
		Assert.assertTrue(false);
	}

	@Test(priority = 5, dependsOnMethods = { "addToCart" })
	void placeOrder() {
		Assert.assertTrue(false);
	}

}
