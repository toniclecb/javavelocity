# Java Code Generator with Velocity
This is a project to demonstrate a possible use for Apache Velocity. Here we create a simple program capable of create some Java Classes.

### Velocity
Velocity is a Java-based template engine. It permits anyone to use a simple yet powerful template language to reference objects defined in Java code.
https://velocity.apache.org/

### Running
You can easily run this project with Maven. Run the two instructions below.
> In Windows, I had some trouble trying to run this in PowerShell, use cmd.
```sh
mvn install
```
```sh
mvn exec:java -Dexec.mainClass="com.toniclecb.velocity.App"
```
