package java_core.day2_hibernate.one_to_one.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "MapsByIdAccountEntity")
@Table(name="ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",unique = true,nullable = false)
    private Integer accountId;

    @Column(name = "ACC_NO", unique = true, nullable = false, length = 8)
    private Integer accountNumber;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
}
