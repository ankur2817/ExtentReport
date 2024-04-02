package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertions {
    
    @Test
    public void validateStringsEqual() {
	String expectedTitle = "Sephora SEA";
	String actualTitle = "Sephora USA";
	
	Assert.assertEquals(actualTitle, expectedTitle, "Test case failed as strings are not same");
    }
    
    @Test
    public void validateBooleanEqual() {
	boolean true1 = true;
	Assert.assertTrue(true1, "Test case failed as it's not true");
    }
    
    @Test
    public void skippedCase()
    {
	throw new SkipException("Test skipped");
    }

}
