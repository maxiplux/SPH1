package cs544.exercise16_1.bank.dao;

import java.util.*;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class AccountDAO implements IAccountDAO
 {

    private SessionFactory sf;

     public AccountDAO() {

     }

     public void setSessionFactory(SessionFactory sf) {


         this.sf = sf;

    }

	//Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		//accountlist.add(account); // add the new


        Session session = this.sf.openSession();
        Transaction transaction =session.beginTransaction();
        //session.save(account.getCustomer());

        System.out.printf("Que pasa DAO--- > (%s)   ",session.save(account)) ;

        transaction.commit();
//        session.close();






 }

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());

        Session session = this.sf.openSession();
        Transaction transaction =session.beginTransaction();

		session.merge(account);
        transaction.commit();


	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
        Session session = this.sf.openSession();
        return  (Account) this.sf.openSession().get(Account.class,accountnumber);

	}

	public Collection<Account> getAccounts() {
        Query query =  this.sf.openSession().createQuery("select A from Account A");
		return query.getResultList();
	}


 }
