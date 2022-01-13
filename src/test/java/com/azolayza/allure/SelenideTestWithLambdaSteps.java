package com.azolayza.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithLambdaSteps {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testIssueSearch(){
        step("Open main page GitHubCom", () -> {
            open("https://github.com/");
        });

        step("Search repository  " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("GOTO" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();
            Allure.addAttachment(
                    "Page Source",
                    "text/html",
                    WebDriverRunner.source(),
                    "html");
        });

        step("Check issue with number 76", () ->{
            $(withText("#86")).should(Condition.visible);
        });
    }
}
