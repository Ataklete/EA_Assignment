package cs544.exercise17_1.bank.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise17_1.bank.domain.Account;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
@Component
public class AccountDAO implements IAccountDAO {

    Collection<Account> accountlist = new ArrayList<Account>();
    private SessionFactory sf;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

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

    @SuppressWarnings("unchecked")
    public Collection<Account> getAccounts() {
        Query query = sf.getCurrentSession().createQuery("from Account");
        accountlist = query.list();
        return accountlist;
    }

}
