package java_core.day2.one_to_one.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "MapsByIdEmployeeEntity")
@Table(name = "EMPLOYEE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer employeeId;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String lastName;

    @Column(name = "SALARY", nullable = false, length = 10)
    private int salary;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
