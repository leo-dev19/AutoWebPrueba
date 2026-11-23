package com.coudevi.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://conduit.bondaracademy.com/")
public class HomePage extends PageObject {

    public static final Target LINK_SIGN_UP = Target.the("Enlace Sign up")
            .located(By.cssSelector("a[href='/register']"));

    public static final Target LINK_SIGN_IN = Target.the("Enlace Sign in")
            .located(By.cssSelector("a[href='/login']"));

    public static final Target LINK_NEW_ARTICLE = Target.the("Enlace New Article")
            .located(By.cssSelector("a[href='/editor']"));

    public static final Target LINK_PERFIL_USUARIO = Target.the("Nombre de usuario logueado en la barra")
            .located(By.cssSelector("nav a[href^='/profile/']"));

    public static final Target PRIMER_ARTICULO_FEED = Target.the("Primer articulo del Global Feed")
            .located(By.cssSelector(".article-preview h1"));

    public static Target tagPopular(String tag) {
        return Target.the("Tag popular " + tag)
                .located(By.xpath("//div[contains(@class,'tag-list')]//a[normalize-space()='" + tag + "']"));
    }
}