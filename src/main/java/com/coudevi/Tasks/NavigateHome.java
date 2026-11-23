package com.coudevi.Tasks;

import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateHome {
    public static Performable theHomePage() {
        return Task.where("{0} abre la pagina principal de Conduit",
                Open.browserOn().the(HomePage.class)
        );
    }
}