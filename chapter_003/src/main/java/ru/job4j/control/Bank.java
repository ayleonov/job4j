package ru.job4j.control;

import java.util.*;

public class Bank {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.users.get(getUser(passport)).add(account);
    }

    public User getUser(String passport) {
        User result = null;
        for (Map.Entry<User, List<Account>> pair : users.entrySet()) {
            if ((pair.getKey().getPassport()).equals(passport)) {
                result = pair.getKey();
                break;
            }
        }
        return result;
    }

    public Account getAccount(User user, String requisites) {
        Account result = null;
        List<Account> temp = getUserAccounts(user);

        for (Account account : temp) {
            if (account.getRequisites().equals(requisites)) {
                result = account;
                break;
            }
        }
        return result;
    }

    private Account getActualAccount(User user, Account account) {
        List<Account> accounts = this.users.get(user);
        return accounts.get(accounts.indexOf(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.users.get(getUser(passport)).remove(account);
    }

    public List<Account> getUserAccounts(User user) {
        return this.users.get(user);
    }

    public boolean transfer(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {

        Account account1 = getWithPassportAndRequisite(srcPassport, srcRequisite);
        Account account2 = getWithPassportAndRequisite(destPassport, destRequisite);

        return account1 != null && account2 != null && account1.transfer(account2, amount);

    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public Account getWithPassportAndRequisite(String passport, String requisite) {
        User user = getUser(passport);
        Account account = getAccount(user, requisite);
        return account;
    }
}
