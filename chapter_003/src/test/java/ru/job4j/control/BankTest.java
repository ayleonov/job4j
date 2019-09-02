package ru.job4j.control;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void whenaddUser() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        Map<User, List<Account>> expect = new HashMap<>();
        expect.put(u1, new ArrayList<>());
        expect.put(u2, new ArrayList<>());
        expect.put(u3, new ArrayList<>());
        assertThat(bank.getUsers(), is(expect));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        bank.deleteUser(u1);
        Map<User, List<Account>> expect = new HashMap<>();
        expect.put(u2, new ArrayList<>());
        expect.put(u3, new ArrayList<>());
        assertThat(bank.getUsers(), is(expect));

    }

    @Test
    public void whenGettingUserAmongPassport() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);

        List<User> result = new ArrayList<>();
        result.add(bank.getUser("24"));
        result.add(bank.getUser("27"));
        result.add(bank.getUser("23"));
        List<User> expect = new ArrayList<>();
        expect.add(u1);
        expect.add(u2);
        expect.add(u3);

        assertThat(result, is(expect));
    }

    @Test
    public void whenaddAccount() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        Account ac1 = new Account(0.2d, "");
        Account ac2 = new Account(0.3d, "");
        bank.addAccountToUser(u2.getPassport(), ac1);
        bank.addAccountToUser(u2.getPassport(), ac2);
        List<Account> expect = new ArrayList<>();
        expect.add(ac1);
        expect.add(ac2);
        assertThat(bank.getUserAccounts(u2), is(expect));
    }

    @Test
    public void whenDeleteAccount() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        Account ac1 = new Account(0.2d, "");
        Account ac2 = new Account(0.3d, "");
        bank.addAccountToUser(u2.getPassport(), ac1);
        bank.addAccountToUser(u2.getPassport(), ac2);
        bank.deleteAccountFromUser(u2.getPassport(), ac1);
        List<Account> expect = new ArrayList<>();
        expect.add(ac2);
        assertThat(bank.getUserAccounts(u2), is(expect));
    }

    @Test
    public void whenUserU1MakeTransfer30ToUserU2() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        Account ac1 = new Account(100.0d, "001");
        Account ac2 = new Account(0.3d, "002");
        bank.addAccountToUser(u1.getPassport(), ac1);
        bank.addAccountToUser(u2.getPassport(), ac2);
        bank.transfer("24", "001", "27", "002", 30);

        double resultUs1 = bank.getAccount(u1, "001").getValues();
        double resultUs2 = bank.getAccount(u2, "002").getValues();

        // количество денег на счете первого юзера
        assertThat((resultUs1), is(70.0));
        //количество денег на счете второго юзера
        assertThat((resultUs2), is(30.3));
    }

    @Test
    public void whenGetAccountOfUserWithRequisite() {
        Bank bank = new Bank();
        User u1 = new User("Попов", "24");
        User u2 = new User("Ларионов", "27");
        User u3 = new User("Хамов", "23");
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);
        Account ac1 = new Account(100.0d, "001");
        Account ac2 = new Account(0.3d, "002");
        bank.addAccountToUser(u2.getPassport(), ac1);
        bank.addAccountToUser(u2.getPassport(), ac2);
        Account result1 = bank.getAccount(u2, "001");
        Account result2 = bank.getAccount(u2, "002");
        assertThat((result1), is(ac1));
        assertThat((result2), is(ac2));
    }
}