# Homework 2.1
*Author: Gabriel Kiprono*

---

# What is a JVM?
JVM(Java Virtual Machine) is part of the JRE(Java Runtime Environment) and it reads the compiled source code (byte code)
and translates it into the Machine readable form to be executed by the host operating system.

# Components of JVM

1. **Class Loader**: reads the byte code, generates the corresponding binary data and saves it in the method area.
   - Loading: for each class file, JVM stores fully qualified name, whether the .class file is related to interface, class or enum 
   and the modifier, variables and method information etc.
   - Linking: performs verification, preparation and resolution
   - initialization: all static variables are assigned with their values defined in the code and static block.
   
2. **JVM Memory**: has been divided into:
    - Method area: all class level information is stored here i.e class name, parent class name, methods, variables etc.
    - Heap area: stores information of all objects.
    - Stack: JVM creates on run-time stack for every thread and is stored in stack area
    - PC Registers: stores addresses of current execution instruction of a thread.
    - Native methods stack: stores native method information

3. **Execution Engine**: executes resulting binary code from the bytecode class. Has been classified into 3 parts
    - Interpreter: interprets the byte code line by line then executes it.
    - Just-In-Time Compiler": compiles the entire bytecode and changes it to native code so whenever the interpreter sees the
    repeated method calls, JIT provides direct native code for the part, so re-interpretation is not required
    - Garbage collector: destroys the un-referenced objects.
    - **Other**:
        - Java Native Interface: is an interface that interacts with the native method libraries and provides the native ibraries i.e
          C and C++ needed for execution.
        - Native method Libraries: is a collection of native libraries which are required by the execution engine

    