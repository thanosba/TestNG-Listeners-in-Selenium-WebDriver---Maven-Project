/**
 * Created by thanos-imac on 7/7/18.
 */
package Listener_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

    @Listeners(Listener_Demo.ListenerTest.class)

    public class TestCases {
        WebDriver driver = new ChromeDriver();

        @Test

        public void Login() {
            driver.get("http://www.facebook.com");
            driver.findElement(By.name("email")).sendKeys("test@test.gr");
            driver.findElement(By.name("passs")).sendKeys("password");
            driver.findElement(By.id("u_0_2")).click();
        }

        // Forcefully failed this test as to verify listener.
        @Test
        public void TestToFail() {
            System.out.println("This method to test fail");
            assertTrue(false);
        }

        @AfterTest
        public void afterTest() {
            driver.close();
            driver.quit();
        }
    }