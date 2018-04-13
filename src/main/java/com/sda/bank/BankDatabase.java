package com.sda.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankDatabase {
    private Map<BankUser, List<BankAccount>> database;
    public BankDatabase() {
        this.database = new HashMap<>();
    }



    public boolean addBankUser(BankUser bankUser) {
        if (database.containsKey(bankUser)) {
            return false;
        }
        database.put(bankUser, new ArrayList<>());
        return true;
    }

    public boolean createAccountFor(BankUser bankUser, String accountName) {
        if (!database.containsKey(bankUser)) {
            return false;
        }
        List<BankAccount> accountsOfUser = database.get(bankUser);
        BankAccount tmpBankAccounts = new BankAccount(accountName);
        if (accountsOfUser.contains(tmpBankAccounts)) {
            return false;
        }
        accountsOfUser.add(tmpBankAccounts);
        return true;
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return database.get(bankUser);
    }

    public int numberOfUsers() {
        return database.size();
    }

    public int numberOfAccounts() {
        return database.entrySet()
                .stream()
                .mapToInt(e -> e.getValue().size())
                .sum();
    }

    public int getNumberOfAccountsFor(BankUser user) {
        return getAccountsOf(user).size();
    }

    public BankAccount getAccountWithId(String accountName) {
        return null;
    }

    public boolean deposit(String accountName, int amount) {
        throw new RuntimeException();
    }
}

