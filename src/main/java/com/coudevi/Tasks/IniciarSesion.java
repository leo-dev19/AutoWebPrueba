package com.coudevi.Tasks;

import com.coudevi.Pages.AuthPage;
import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesion {
    public static Performable conCredenciales(String email, String password) {
        return Task.where("{0} inicia sesion en Conduit",
                Click.on(HomePage.LINK_SIGN_IN),
                WaitUntil.the(AuthPage.INPUT_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(AuthPage.INPUT_EMAIL),
                Enter.theValue(password).into(AuthPage.INPUT_PASSWORD),
                Click.on(AuthPage.BTN_SUBMIT),
                WaitUntil.the(HomePage.LINK_PERFIL_USUARIO, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
