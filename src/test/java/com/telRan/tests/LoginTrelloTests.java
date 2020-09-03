package com.telRan.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoginTrelloTests {
    WebDriver wd;


    @BeforeClass
    public void setUp(){
        //create new instance of WebDriver(ex.open chrome Browser)
       wd = new ChromeDriver();
       wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//otkritie browser
       wd.manage().window().maximize();//rashirenie okna

        //open site
        wd.navigate().to("https://trello.com/");

    }
   @Test
    public void LoginAtlassianAccPositiveTest() throws InterruptedException {
        //click on login Button on Welcome page
       wd.findElement(By.cssSelector("[href='/login']")).click();
       //fill login form
       //-fill email
       wd.findElement(By.name("user")).click();
       wd.findElement(By.name("user")).clear();
       wd.findElement(By.name("user")).sendKeys("Yuliazaburmag@gmail.com");
       //wait
       wd.findElement(By.id("Login")).click();
       Thread.sleep(10000);

       //login with atlassian button

       //-fill password
       wd.findElement(By.id("password")).click();
       wd.findElement(By.id("password")).clear();
       wd.findElement(By.id("password")).sendKeys("julia@54321");

       //-confirm login
       wd.findElement(By.id("Login-submit")).click();


       //expec.res user logged (isAvatar present)


    }
    @AfterClass(enabled = false)
    public void tearDown(){
        wd.close();

    }
}
