package com.sda.bank;

import java.util.List;

public class Bank {
    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }
    public boolean deposit(String accountName, int amount) {
        return bankDatabase.deposit(accountName, amount);
    }
    public boolean addBankUser(BankUser bankUser) {
        return bankDatabase.addBankUser(bankUser);
    }

    public boolean createAccountFor(BankUser bankUser, String accountName) {
        return bankDatabase.createAccountFor(bankUser, accountName);
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return bankDatabase.getAccountsOf(bankUser);
    }

    public int numberOfUsers() {
        return bankDatabase.numberOfUsers();
    }

    public int numberOfAccounts() {
        return bankDatabase.numberOfAccounts();
    }

    public int getNumberOfAccountsFor(BankUser user) {
        return bankDatabase.getNumberOfAccountsFor(user);
    }

    public BankAccount getAccountWithId(String accountName) {
        return bankDatabase.getAccountWithId(accountName);
    }
}
