package vishalselenium.SeleniumCheck;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSimple {
	
	@Test(retryAnalyzer = vishalselenium.SeleniumCheck.RetryAnalyzer.class)
	public void test1() {
		System.out.println("Hello this is test 1");
		Assert.assertEquals(false, true);
	}
	
	

	@Test
	public void test2() {
		System.out.println("Hello this is test 2");
		Assert.assertEquals(false, true);
	}

}
