package day13;

import org.testng.annotations.Test;

public class SystemProperties {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("/Downloads"));
    }
}
