package com.coudevi.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthPage extends PageObject {

    public static final Target INPUT_USERNAME = Target.the("Campo Username")
            .located(By.cssSelector("input[placeholder='Username']"));

    public static final Target INPUT_EMAIL = Target.the("Campo Email")
            .located(By.cssSelector("input[placeholder='Email']"));

    public static final Target INPUT_PASSWORD = Target.the("Campo Password")
            .located(By.cssSelector("input[placeholder='Password']"));

    public static final Target BTN_SUBMIT = Target.the("Boton de registro o inicio de sesion")
            .located(By.cssSelector("button[type='submit']"));
}