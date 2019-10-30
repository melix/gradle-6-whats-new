package org.gradle.hello6;

public class HelloApp {

    public static void main(String[] args) {
        HelloMessage m = new HelloMessage("Hello everyone");
        new PrintHelloFromJava().print(m);
        new PrintLoudHelloFromJava().print(m);
    }

}
