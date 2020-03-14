package day7;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_TestNG {
    @BeforeMethod
    public void setup(){
        System.out.println("Before String");
    }
    @Test(description = "First description")
    public void test1(){
        System.out.println("Test1");
        String expected = "apple";
        String actual = reverseString("elppa");
        Assert.assertEquals(actual,expected);

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
