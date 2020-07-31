package mango.udemy.multithreading.thread.creation.example1;

public class Vault {

    public static final int MAX_PASSWORD = 9999;

    private int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password == guess;
    }
}
