package com.coudevi.Utils;

import io.cucumber.java.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PreAndProsCondition {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreAndProsCondition.class);
    public static String screenShot = Parameters.RutaEvidencia;

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("_____________________________________________________");
        LOGGER.info("Running: {}", scenario.getName());
        OnStage.setTheStage(new OnlineCast());

        LOGGER.info("Creating folder for screenshot");
        String safeScenarioName = scenario.getName().replaceAll("[\\\\/:*?\"<>|]", "_");
        screenShot = Parameters.RutaEvidencia + ScreenShot.getCurrentDateTime() + "_" + safeScenarioName;
        Parameters.RutaEvidenciaActual = screenShot;
        ScreenShot.createFolder(screenShot);

        limpiarSesion();
    }

    @After
    public void afterScenario(Scenario scenario) {
        LOGGER.info("Finishing: {}", scenario.getName());
        limpiarSesion();
        screenShot = Parameters.RutaEvidencia;
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        LOGGER.info("Executing step in: {}", scenario.getName());
    }

    private void limpiarSesion() {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("window.localStorage.clear();");
            jsExecutor.executeScript("window.sessionStorage.clear();");
        } catch (Exception e) {
            LOGGER.warn("No se pudo limpiar el storage : {}", e.getMessage());
        }
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        //adjunta evidencia a jira xray
//        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName());
//    }
}