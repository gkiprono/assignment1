#### February 15, 2022

*Author: Gabriel Kiprono*

# Hibernate and JPA

---

### Hibernate Query Language
<p>
Similar to SQL but works with persistent objects and their properties. HQL is translated by Hibernate into conventional 
SQL queries.
</p>

#### clauses

```java
import org.hibernate.Hibernate;

class Solution {

    public static void hqlSample() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "From Employee"; // FROM -> loads complete persistent objects to memory
        String hql = "FROM Employee AS E"; //AS clause
        String hql = "SELECT E.firstName FROM Employee E"; // SELECT
        String hql = "FROM Employee E WHERE E.id = 10"; //WHERE
        String hql = "FROM Employee E WHERE E.id > 10 ORDER BY E.salary DESC"; //ORDER BY
        String hql = "SELECT SUM(E.salary), E.firtName FROM Employee E " +
                "GROUP BY E.firstName";  // GROUP BY
        String hql = "UPDATE Employee set salary = :salary WHERE id = :employee_id"; // UPDATE
        String hql = "DELETE FROM Employee WHERE id = :employee_id"; // DELETE
        String hql = "INSERT INTO Employee(firstName, lastName, salary) SELECT firstName, lastName, salary FROM old_employee"; // nested 

        Query query = session.createQuery(hql);
        List results = query.list();

        HibernateUtil.shutdown();
    }
}
```
Also supports aggregate functions i.e avg,count,max,min,sum,distinct

### Hibernate Criteria Queries
<p>The criteria query API lets you build nested, structured query expressions in Java, providing a compile-time syntax 
checking that is not possible with a query language like HQL or SQL. Session object provides createCriteria() method 
used to create criteria object.
</p>

```java
class Solution{
    
    public static void hcqSample(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        List results = cr.list(); // results
        
        // Restrictions with Criteria
        
        // records with salary is equal to 2000 
        cr.add(Restrictions.eq("salary", 2000));
        // To get records having salary more than 2000
        cr.add(Restrictions.gt("salary", 2000));

        // To get records having salary less than 2000
        cr.add(Restrictions.lt("salary", 2000));

        // To get records having fistName starting with zara
        cr.add(Restrictions.like("firstName", "zara%"));

        // Case-sensitive form of the above restriction.
        cr.add(Restrictions.ilike("firstName", "zara%"));

        // To get records having salary in between 1000 and 2000
        cr.add(Restrictions.between("salary", 1000, 2000));

        // To check if the given property is null
        cr.add(Restrictions.isNull("salary"));

        // To check if the given property is not null
        cr.add(Restrictions.isNotNull("salary"));

        // To check if the given property is empty
        cr.add(Restrictions.isEmpty("salary"));

        // To check if the given property is not empty
        cr.add(Restrictions.isNotEmpty("salary"));
        
        //SORTING -> org.hibernate.criterion.Order class
        // To sort records in descening order
        cr.addOrder(Order.desc("salary"));

        // To sort records in ascending order
        cr.addOrder(Order.asc("salary"));
        
        // AGGREGATE FUNCTIONS ->  org.hibernate.criterion.Projections class, 
        // To get total row count.
        cr.setProjection(Projections.rowCount());

        // To get average of a property.
        cr.setProjection(Projections.avg("salary"));

        // To get distinct count of a property.
        cr.setProjection(Projections.countDistinct("firstName"));

        // To get maximum of a property.
        cr.setProjection(Projections.max("salary"));

        // To get minimum of a property.
        cr.setProjection(Projections.min("salary"));

        // To get sum of a property.
        cr.setProjection(Projections.sum("salary"));
        

        HibernateUtil.shutdown();
    }
}
```

### Hibernate Native SQL
<p>Hibernate 3.x allows you to specify handwritten SQL, including stored procedures, for all create, update, delete, 
and load operations. application will create a native SQL query from the session with the createSQLQuery() method on 
the Session interface.
</p><p>After you pass a string containing the SQL query to the createSQLQuery() method, you can associate the SQL result 
with either an existing Hibernate entity, a join, or a scalar result using addEntity(), addJoin(), and addScalar() 
methods respectively.
</p>

```java
class Solution{
    public static void hbNativeSql(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        // SCALAR QUERIES -> get the list of scalars/values from one or more tables

        String sql = "SELECT first_name, salary FROM EMPLOYEE";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        
        // ENTITY QUERIES -> returns the entity objects as whole from native sql query via addEntity()
        
        String sql = "SELECT * FROM EMPLOYEE";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        List results = query.list();
        
        // NAMED SQL QUERIES -> parameterised
        
        String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        query.setParameter("employee_id", 10);
        List results = query.list();
    }
}
```