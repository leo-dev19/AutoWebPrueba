package com.coudevi.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ArticlePage extends PageObject {

    public static final Target INPUT_TITULO = Target.the("Campo Article Title")
            .located(By.cssSelector("input[placeholder='Article Title']"));

    public static final Target INPUT_DESCRIPCION = Target.the("Campo What's this article about?")
            .located(By.cssSelector("input[placeholder=\"What's this article about?\"]"));

    public static final Target INPUT_CUERPO = Target.the("Campo Write your article")
            .located(By.cssSelector("textarea[placeholder='Write your article (in markdown)']"));

    public static final Target INPUT_TAGS = Target.the("Campo Enter tags")
            .located(By.cssSelector("input[placeholder='Enter tags']"));

    public static final Target BTN_PUBLISH = Target.the("Boton Publish Article")
            .located(By.xpath("//button[contains(normalize-space(),'Publish Article')]"));

    // Vista de detalle del articulo
    public static final Target TITULO_PUBLICADO = Target.the("Titulo del articulo publicado")
            .located(By.cssSelector(".banner h1"));

    public static final Target INPUT_COMENTARIO = Target.the("Campo Write a comment")
            .located(By.cssSelector("textarea[placeholder='Write a comment...']"));

    public static final Target BTN_POST_COMMENT = Target.the("Boton Post Comment")
            .located(By.xpath("//button[contains(normalize-space(),'Post Comment')]"));

    public static final Target PRIMER_COMENTARIO = Target.the("Ultimo comentario publicado")
            .located(By.cssSelector(".card .card-text"));
}