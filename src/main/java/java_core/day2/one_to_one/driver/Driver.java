package java_core.day2.one_to_one.driver;


import java_core.day2.one_to_one.entities.Account;
import java_core.day2.one_to_one.entities.Employee;
import java_core.day2.one_to_one.utils.HibernateUtil;
import org.hibernate.Session;

public class Driver {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        for(int i=0;i<5;i++){
            Employee employee = new Employee();
            Account account = new Account();

            account.setAccountNumber(123+i);

            employee.setEmail("Gabriel.ku@gmail.com"+i);
            employee.setFirstName("Gabriel");
            employee.setLastName("Kau");
            employee.setSalary(78000+i);

            employee.setAccount(account);

            session.save(employee);
        }



        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
