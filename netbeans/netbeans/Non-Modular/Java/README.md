## Non-modular samples for NetBeans

JavaFX 11 samples to run from NetBeans with different options and build tools

Version NetBeans [10.0](https://netbeans.apache.org/download/nb100/nb100.html)

Download an appropriate [JDK 11](https://jdk.java.net/11/) for your operating system. Make sure `JAVA_HOME` 
is properly set to the Java 11 installation directory. 

The samples assume NetBeans 10 runs on JDK 11 (this can be set editing the `etc/netbeans.conf` file
and setting `netbeans_jdkhome="/path/to/jdk11"`).

### Java

For the first time only:

- Download [JavaFX SDK](https://gluonhq.com/products/javafx/) for your operating 
system and unzip to a desired location.

- Open NetBeans and create a global Library under `NetBeans -> Tools -> Libraries -> New Library`.
Name it `JavaFX11` and include the jars under the lib folder from JavaFX 11 (but not the `src.zip` file).

Clone the sample, open it with NetBeans, and make sure the paths for Java 11 and 
JavaFX 11 match those on your machine.