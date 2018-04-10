package com.sda.service.cucumber;

import com.sda.stringCalc.StringCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StringCalculatorSteps {

    private String value;
    private StringCalculator calculator = new StringCalculator();
    private int result;

    @Given("^I initialise stringCalculator$")
    public void I_initialise_stringCalculator() {
        this.calculator = new StringCalculator();
    }

    @Given("^I pass single number value$")
    public void I_pass_single_number_value() {
        this.value = "5";
    }

    @And("^I pass null value$")
    public void I_pass_null_value() {
        this.value = null;
    }

    @And("^I pass blank value$")
    public void I_Pass_Blank_Value() {
        this.value = "";
    }

    @And("^I pass multiple values$")
    public void I_Pass_Multiple_Values() {
        this.value = "5,8,21";
    }

    @And("^I pass multiple values with white spaces$")
    public void iPassMultipleValuesWithWhiteSpaces() {
        this.value = "2, 3,     9,3";
    }

    @When("^I trigger calculate function$")
    public void I_trigger_calculate_function() {
        this.result = calculator.calculate(value);
    }

    @Then("^I get 5 as a result$")
    public void I_get_5_as_a_result() {
        Assert.assertEquals(5, result);
    }

    @Then("^I get 0 as a result$")
    public void I_get_0_as_a_result() {
        Assert.assertEquals(0, result);
    }

    @Then("^I get 34 as a result$")
    public void iGet34AsAResult() {
        Assert.assertEquals(34, result);
    }

    @Then("^I get 17 as a result$")
    public void iGet17AsAResult() {
        Assert.assertEquals(17, result);
    }
}
