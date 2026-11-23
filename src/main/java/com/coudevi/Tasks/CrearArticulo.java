package com.coudevi.Tasks;

import com.coudevi.Pages.ArticlePage;
import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearArticulo {
    public static Performable conDatos(String titulo, String descripcion, String cuerpo, String tag) {
        return Task.where("{0} crea un nuevo articulo",
                Click.on(HomePage.LINK_NEW_ARTICLE),
                WaitUntil.the(ArticlePage.INPUT_TITULO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(titulo).into(ArticlePage.INPUT_TITULO),
                Enter.theValue(descripcion).into(ArticlePage.INPUT_DESCRIPCION),
                Enter.theValue(cuerpo).into(ArticlePage.INPUT_CUERPO),
                Enter.theValue(tag).into(ArticlePage.INPUT_TAGS).thenHit(Keys.ENTER),
                Click.on(ArticlePage.BTN_PUBLISH),
                WaitUntil.the(ArticlePage.TITULO_PUBLICADO, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
