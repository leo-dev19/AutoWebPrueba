package com.coudevi.SteepDefinitions;

import com.coudevi.Questions.ConduitQuestions;
import com.coudevi.Tasks.CrearArticulo;
import com.coudevi.Tasks.IniciarSesion;
import com.coudevi.Tasks.NavigateHome;
import com.coudevi.Tasks.PublicarComentario;
import com.coudevi.Tasks.RegistrarCuenta;
import com.coudevi.Utils.PreAndProsCondition;
import com.coudevi.Utils.ScreenShot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.Matchers.equalTo;

public class ConduitSteps {

    @Given("el {actor} esta en la pagina de inicio de Conduit")
    public void elUsuarioEstaEnLaPaginaDeInicioDeConduit(Actor actor) {
        actor.attemptsTo(NavigateHome.theHomePage());
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_1_Home");
    }

    @When("se registra con usuario {string}, correo {string} y contrasenia {string}")
    public void seRegistraConDatos(String username, String email, String password) {
        theActorInTheSpotlight().attemptsTo(RegistrarCuenta.conDatos(username, email, password));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_2_Registro");
    }

    @Then("deberia ver su nombre de usuario {string} en la barra de navegacion")
    public void deberiaVerSuNombreDeUsuario(String username) {
        theActorInTheSpotlight().should(
                seeThat("El usuario logueado", ConduitQuestions.usuarioLogueado(), equalTo(username))
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_3_Validacion_Usuario");
    }

    @And("inicia sesion con correo {string} y contrasenia {string}")
    public void iniciaSesionConCredenciales(String email, String password) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.conCredenciales(email, password));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_2_Login");
    }

    @When("crea un articulo con titulo {string}, descripcion {string}, contenido {string} y tag {string}")
    public void creaUnArticulo(String titulo, String descripcion, String cuerpo, String tag) {
        theActorInTheSpotlight().attemptsTo(CrearArticulo.conDatos(titulo, descripcion, cuerpo, tag));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_3_Articulo_Creado");
    }

    @Then("deberia visualizar el articulo publicado con el titulo {string}")
    public void deberiaVisualizarElArticuloPublicado(String tituloEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El titulo del articulo", ConduitQuestions.tituloDelArticulo(), equalTo(tituloEsperado))
        );
    }

    @When("publica el comentario {string} en el primer articulo disponible")
    public void publicaElComentario(String comentario) {
        theActorInTheSpotlight().attemptsTo(PublicarComentario.enElPrimerArticulo(comentario));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot, "Paso_3_Comentario");
    }

    @Then("deberia visualizar el comentario {string} en el articulo")
    public void deberiaVisualizarElComentario(String comentarioEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El comentario publicado", ConduitQuestions.ultimoComentario(), equalTo(comentarioEsperado))
        );
    }
}