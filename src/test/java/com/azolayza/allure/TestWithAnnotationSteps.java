package com.azolayza.allure;

import org.junit.jupiter.api.Test;

public class TestWithAnnotationSteps {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void annotatedStepsTest(){
        AnnotationSteps steps = new AnnotationSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssuesTub();
        steps.shouldSeeIssueNumber(85);
    }
}
