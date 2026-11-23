package com.coudevi.Tasks;

import com.coudevi.Pages.AuthPage;
import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarCuenta {
    public static Performable conDatos(String username, String email, String password) {
        return Task.where("{0} registra una nueva cuenta en Conduit",
                Click.on(HomePage.LINK_SIGN_UP),
                WaitUntil.the(AuthPage.INPUT_USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(AuthPage.INPUT_USERNAME),
                Enter.theValue(email).into(AuthPage.INPUT_EMAIL),
                Enter.theValue(password).into(AuthPage.INPUT_PASSWORD),
                Click.on(AuthPage.BTN_SUBMIT)
        );
    }
}
