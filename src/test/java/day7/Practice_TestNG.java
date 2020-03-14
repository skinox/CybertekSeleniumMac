package day7;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_TestNG {

    //runs just once before all tests
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class Check");
    }
    //runs before particular test
    @BeforeMethod
    public void setup1(){
        System.out.println("Before String");
    }
    @Test(description = "First description")
    public void test1(){
        System.out.println("Test1");
        String expected = "apple";
        String actual = reverseString("elppa");
        Assert.assertEquals(actual,expected);

    }
    @BeforeMethod
    public void setup2(){
        System.out.println("Before String");
    }
    @Test
    public void test2(){
        System.out.println("Test1");
        int x = 1;
        int y = 10;
        Assert.assertTrue(y>x);
    }
    public static String reverseString(String st){
        String reverse ="";
        for(int i = st.length() - 1; i >= 0; i--)
        {
            reverse = reverse + st.charAt(i);
        }
        return reverse;
    }
}
