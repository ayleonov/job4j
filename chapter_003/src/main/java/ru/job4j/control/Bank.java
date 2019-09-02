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
        User user1 = getUser(srcPassport);
        Account account1 = getAccount(user1, srcRequisite);
        User user2 = getUser(destPassport);
        Account account2 = getAccount(user2, destRequisite);

        return this.users.get(user1).contains(account1)
                && this.users.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                        getActualAccount(user2, account2), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }
}
