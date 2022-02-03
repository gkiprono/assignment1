#### February 2, 2022

*Author: Gabriel Kiprono*

# Databases

---

### Homework 7.1

- ##### Differences between *memcached* and *redis*

| Memcached                                           | Redis                                                                |
|-----------------------------------------------------|----------------------------------------------------------------------|
| uses multiple cores                                 | Uses single core                                                     |
| It only uses strings and integers as data structure | uses lists, string, hashes, sorted lists as data structure           |
| read and write speed is higher than Redis           | read write speed is slower than memcached                            |
| does not support any replication method             | support master-slave replication and Multi-master replication method |
| maximum key length is 250 bytes                     | maximum key length is 2GB                                            |

- ##### AWS Elastic cache
Is a fully managed in-memory data store and cache service. It improves the performance of web apps by retrieving information 
from manages in-memory cached instead of relying entirely on slower disk-based databases.

###### Benefits

- Accelerates application performances
- Ease backend database load
- Build low-latency data stores


### Homework 7.2

- ##### Differences between *view* and *stored procedure*

| view                                      | stored procedure                         |
|-------------------------------------------|------------------------------------------|
| does not accept parameters                | accept parameters                        |
| can contain only one single select query  | can contain several statements           |
| cannot perform modification to any table  | can modify one or many tables            |
| can be used as the target for DML queries | cannot be used as target for DML queries |

[Credits](https://www.c-sharpcorner.com/blogs/difference-between-a-view-and-stored-procedure1)

- ##### Differences between *view* and *material view*

<p>Technically **view** of a table is a logical virtual copy of the table created by “select query” but the result is not 
stored anywhere in the disk and every time we need to fire the query when we need data, so always we get updated or 
latest data from original tables.</p>
<p>On other hand Materialized views are also the logical virtual copy of data-driven by the select query but the result 
of the query will get stored in the table or disk.</p>

| Views                                                                                           | Material view                                                                               |
|-------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| resulting tuples of the expression if not stored on the disk, query is stored                   | both query and the results tuple is stored on the disk                                      |
| data is fetched every time the view is called hence results in upto-date records                | results is stored on disk hence queries doesnt provide latest records                       |
| memory efficient since only query is stored                                                     | memory intensive, both query and results are stored on disk                                 |
| there is a SQL standard for defining a view                                                     | designed with a generic architecture approach, so there is no SQL standard for defining it. |
| generally used when data is to be accessed infrequently and data in table is updated frequently | used when data is to be accessed frequently and data in table not get updated frequently    |

[Credits](https://www.tutorialspoint.com/difference-between-views-and-materialized-views-in-sql#:~:text=Views%20are%20generally%20used%20when,get%20updated%20on%20frequent%20basis.)



