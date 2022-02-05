#### February 3, 2022

*Author: Gabriel Kiprono*

# Databases

---
## Homework 8.1
## Locks
<p>Locks are used to ensure the integrity of the data. When a database resource is locked by one process, another process is 
not permitted to change the locked data. This help to avoid concurrent update problem</p> 
To avoid waiting forever,lock time-out value is set and the DBMS releases the lock.
Deadlock occurs when one process A holds one resource and requests another resource that another process B is holding while 
this process B is also requesting the resource being held by process A.

#### Levels
- Database level locking
- file level locking
- table level locking
- page/block level locking
- row level locking
- column level locking

### Optimistic lock
This locking does not hold row locks between selecting and updating/deleting a row. It assumes that unlocked rows are 
unlikely to change before the update or delete operation and if it changes, update or delete will fail and the application
will handle this failure, by restarting the whole transaction.
<p>This is mostly applicable in high volume systems and 3-tier systems where you do not maintain a connection 
to the database for your session.</p>

### Pessimistic lock
<p>involves locking the record for your exclusive use until you have finished with it. This offers
much better integrity than the optimistic locking as long as the app design avoids the deadlock.</p>
<p>To use pessimistic lock, you have to have either a direct connection to the database or an
externally available transaction id that can be used independently of the connection.</p>
Used when collision is anticipated

## Homework 8.2
### Transactions
A transaction is an action or series of actions that are bing performed by a single user or application program which
reads or updates the contents of the database. 

##### Properties of Transaction
- Atomicity: means that either all the transactions will execute successfully or none of them will.
- Consistency: means that constraints are enforced for every committed transaction. 
- Isolation: if two transactions are executing concurrently and working on the same data, then one transaction should not
  disturb the other transaction. should not affect each other
- Durability: once transaction is complete, it guarantees that all the changes are recorded on the database. Incase of power
  outages, all transactions may be replayed.

### How to solve a deadlock
- *Eliminate Mutual Exclusion:* its not possible to dis-satisfy thr mutual exclusion because some resources are inherently
    non-shareable.
- *Eliminate hold and wait:* Allocate all required resources by the process before the start of its execution, eliminating 
    the hold and wait. 
- *Eliminate no preemption:* preempt resources from the process when resources are needed by high priority processes.
- *Eliminate circular wait:* Each resource will be assigned with a numerical number. A process can request the resources 
   increasing/decreasing. order of numbering
- *Deadlock avoidance with Bankers algorithm:* this algorithm tests all the request made by process for resources.

#### Bankers Algorithm
It checks for the safe state, If after granting request system remains in the safe state then it allows the request and 
if there is no safe state it doesn't allow the request made by the process. 

##### Input
- max need of resources by each process
- currently, allocated resources by each process
- max free available resources in the system.

##### Conditions considered before granting requests
- if the request made by the process is less than or equal to max need to that process
- if the request made by the process is less than or equal to the freely available resources in the system

## Homework 8.3
### Saga
is a sequence of local transactions where each transaction updates data within a single service. The first transaction 
in a saga is initiated by an external request corresponding to the system operation, and then each subsequent step is 
triggered by the completion of the previous one.

- Events/Choreography: when there is no central coordination, each service produces and listen to the other service's 
    event and decides if an action should be taken or not.
- Command/Orchestration: when coordinator service is responsible for centralizing the saga's decision-making and sequencing
    business logic.