package com.coudevi.Tasks;

import com.coudevi.Pages.ArticlePage;
import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PublicarComentario {
    public static Performable enElPrimerArticulo(String comentario) {
        return Task.where("{0} ingresa al primer articulo y publica un comentario",
                WaitUntil.the(HomePage.PRIMER_ARTICULO_FEED, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.PRIMER_ARTICULO_FEED),
                WaitUntil.the(ArticlePage.INPUT_COMENTARIO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(comentario).into(ArticlePage.INPUT_COMENTARIO),
                Click.on(ArticlePage.BTN_POST_COMMENT),
                WaitUntil.the(ArticlePage.PRIMER_COMENTARIO, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}