package com.sda.bank;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;

public class BankSteps {
    private Bank bank;
    private BankUser user;
    private boolean userInsertResult;
    private BankAccount account;
    private boolean accountCreationResult;
    private boolean depositResult;
    private BankDatabase bankDatabase = new BankDatabase();

    @Given("^I initialise bank")
    public void I_initialise_bank() {
        this.bank = new Bank(bankDatabase);
    }

    @Given("^I mock bank database for this case$")
    public void iMockBankDatabaseForThisCase() {
        this.bankDatabase = Mockito.mock(BankDatabase.class);
        Mockito.when(bankDatabase.addBankUser(Mockito.any())).then(e -> true);
        Mockito.when(bankDatabase.createAccountFor(Mockito.any(), Mockito.anyString())).then(e -> true);
        Mockito.when(bankDatabase.getAccountWithId(Mockito.anyString())).then(e -> BankAccount.instanceOf(null, 1000));
        Mockito.when(bankDatabase.deposit(Mockito.any(), Mockito.anyInt())).then(e -> true);
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

    @And("^I deposit '(\\d+)' to account with name '(.*)'$")
    public void iDepositAmountToAccountWithNameName(int amount, String accountName) {
        this.depositResult = bank.deposit(accountName, amount);
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

    @Then("^User has only '(\\d+)' account in bank$")
    public void userHasOnlyAccountInBank(int numberOfAccounts) {
        Assert.assertEquals(numberOfAccounts, bank.getNumberOfAccountsFor(user));
    }

    @Then("^Account with name '(.*)' has amount of '(\\d+)'$")
    public void accountWithNameTestoweKontoHasAmountOf(String accountName, int amount) {
        Assert.assertTrue(depositResult);
        Assert.assertEquals(amount, bank.getAccountWithId(accountName).getAmount());
    }

}
