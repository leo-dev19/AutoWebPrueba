package com.coudevi.Questions;

import com.coudevi.Pages.ArticlePage;
import com.coudevi.Pages.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConduitQuestions {

    public static Question<String> usuarioLogueado() {
        return actor -> {
            actor.attemptsTo(WaitUntil.the(HomePage.LINK_PERFIL_USUARIO, isVisible()).forNoMoreThan(10).seconds());
            return Text.of(HomePage.LINK_PERFIL_USUARIO).answeredBy(actor).trim();
        };
    }

    public static Question<String> tituloDelArticulo() {
        return actor -> Text.of(ArticlePage.TITULO_PUBLICADO).answeredBy(actor).trim();
    }

    public static Question<String> ultimoComentario() {
        return actor -> Text.of(ArticlePage.PRIMER_COMENTARIO).answeredBy(actor).trim();
    }
}
