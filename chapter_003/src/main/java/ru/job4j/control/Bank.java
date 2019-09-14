package ru.job4j.control;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

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


    public User getUser1(String passport) {
        //User result = null;
        List<User> result = new ArrayList<>();
        users.forEach((k,v)->{String temp = k.getPassport();
            if (temp.equals(passport))
                result.add(k);
        });
            return result.get(0);
    }

    public User getUser2(String passport) {
        List<User> result = new ArrayList<>();
        users.entrySet().stream().filter(u->{
            if (u.getKey().getPassport().equals(passport))
                result.add(u.getKey());
            return true;
        }).findFirst();
        return result.get(0);
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

    public Account getAccount1(User user, String requisites) {
        Account result = null;
        List<Account> temp = getUserAccounts(user);

        temp.stream().filter(t -> t.getRequisites().equals(requisites)).findFirst().orElse(result);
        System.out.println(result);
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
