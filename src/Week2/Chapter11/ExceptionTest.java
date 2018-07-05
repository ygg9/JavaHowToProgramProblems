package Week2.Chapter11;

import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new ExceptionA();
        } catch (ExceptionA exceptionA) {
            System.out.println(exceptionA);
        }

        try {
            throw new ExceptionB();
        } catch (ExceptionB exceptionB) {
            System.out.println(exceptionB.getMessage());
        }

        try {
            throw new IOException();
        } catch (IOException ioException) {
            System.out.println(ioException);
        }

        try {
            throw new NullPointerException();
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
        }
    }
}
