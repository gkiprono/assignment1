#### February 14, 2022

*Author: Gabriel Kiprono*

---

## Overview
### Statement
<p>
Statement interface is used for executing static SQL statements. Accept strings as SQL queries. Its mostly suitable for 
DDL queries i.e CREATE,ALTER,DROP
</p>

#### Drawbacks of Statement

- the code becomes less readable when concatenating strings.
- vulnerable to sql injections
- since JDBC passes the with inline values to the database,there is no query optimization, database engine must ensure
  all checks.
- can't be used for storing and retrieving files and arrays.

### PreparedStatement
<p>
PreparedStatement interface is used for executing pre-compiled SQL statements. PreparedStatement uses pre-compilation 
thus speeding up the communication between database and the JVM.
</p>

```java
class Solution {
  public void insert(PersonEntity personEntity) {
    String query = "INSERT INTO persons(id, name) VALUES( ?, ?)";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, personEntity.getId());
    preparedStatement.setString(2, personEntity.getName());
    preparedStatement.executeUpdate();
  }
}
```

#### Features of PreparedStatement
- protects against sql injection
- easy to understand
- provides a batch execution during single database connection
- it provides an easy way to store and retrieve files by using BLOB and CLOB data types