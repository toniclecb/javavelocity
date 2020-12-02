# Java Code Generator with Velocity
This is a project to demonstrate a possible use for Apache Velocity. Here we create a simple program capable of create some Java Classes.

### Velocity
Velocity is a Java-based template engine. It permits anyone to use a simple yet powerful template language to reference objects defined in Java code. (https://velocity.apache.org/)

### Running
You can easily run this project with Maven. Run the two instructions below.

> In Windows, I had some trouble trying to run this in PowerShell, use cmd.

```sh
mvn install
```
```sh
mvn exec:java -Dexec.mainClass="com.toniclecb.velocity.App"
```

The steps to create the classes will be displayed on the command line.

```sh
-=- Follow the instructions -=-

1: Create a Main Class;
2: Create a Bean Class;

0: Exit;
Choose one:

2
 -=- Follow the instructions, type what is requested! -=-
Class Name:
Person
Package:
com.tonicle.velocity.bean
SerialVersionUID (need to be a valid long):
123123
Import [type -1 to stop entering imports]:
java.util.Date
Import [type -1 to stop entering imports]:
-1
Fields names and fields types (separated by a comma (name,type example: size,float) [type -1 to stop entering fields]:
age,int
Fields names and fields types (separated by a comma (name,type example: size,float) [type -1 to stop entering fields]:
-1
Default constructor (zero-argument constructor)? [Y or N]:
Y
Constructor with all fields? [Y or N]:
Y
...
```
