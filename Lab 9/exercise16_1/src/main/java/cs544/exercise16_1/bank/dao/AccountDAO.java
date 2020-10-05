package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cs544.exercise16_1.bank.domain.Account;

public class AccountDAO implements IAccountDAO {
    Collection<Account> accountlist = new ArrayList<Account>();
    //add HibernateUtil
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    public void saveAccount(Account account) {

        sf.getCurrentSession().saveOrUpdate(account);
    }

    public void updateAccount(Account account) {

        sf.getCurrentSession().saveOrUpdate(account);

        System.out.println("AccountDAO: update account with accountnr =" +
                account.getAccountnumber());
    }

    public Account loadAccount(long accountnumber) {

        System.out.println("AccountDAO: loading account with accountnr =" + accountnumber);

        return (Account) sf.getCurrentSession().get(Account.class, accountnumber);
    }

    public Collection<Account> getAccounts() {
        Query query = sf.getCurrentSession().createQuery("from Account");
        accountlist = query.list();
        return accountlist;
    }

}
