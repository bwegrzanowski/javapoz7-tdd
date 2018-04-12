package com.sda.bank;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BankSteps {
    private Bank bank;
    private BankUser user;
    private boolean userInsertResult;
    private BankAccount account;
    private boolean accountCreationResult;

    @Given("^I initialise bank")
    public void I_initialise_bank() {
        this.bank = new Bank();
    }

    @And("^I create user with name '(.*)' and pesel '(.*)'$")
    public void iCreateUserWithNameNameAndPeselPesel(String name, String pesel) {
        this.user = new BankUser(name, pesel);
    }

    @And("^I create account with name '(.*)'$")
    public void iCreateAccountWithNameName(String name) {
        this.account = new BankAccount(name);
    }

    @When("^I insert user to bank$")
    public void iInsertUserToBank() {
        userInsertResult = bank.addBankUser
                (new BankUser(user.getName(), user.getPesel()));
    }

    @And("^I insert account to bank$")
    public void iInsertAccountToBank() {
        accountCreationResult = bank.createAccountFor(user, account.getId());
    }

    @Then("^user is present in bank$")
    public void userIsPresentInBank() {
        Assert.assertTrue(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }

    @Then("^user is not present in bank$")
    public void userIsNotPresentInBank() {
        Assert.assertFalse(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }

    @Then("^account is present in bank$")
    public void accountIsPresentInBank() {
        Assert.assertEquals(1, bank.numberOfAccounts());
        Assert.assertTrue(accountCreationResult);
    }

    @Then("^account is not present in bank$")
    public void accountIsNotPresentInBank() {
        Assert.assertEquals(0, bank.numberOfAccounts());
        Assert.assertFalse(accountCreationResult);
    }

}
