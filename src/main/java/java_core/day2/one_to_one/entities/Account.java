package java_core.day2.one_to_one.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "MapsByIdAccountEntity")
@Table(name = "ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer accountId;


}
