package teddy.test.thread;

public class PrintMachine {

    public PrintMachine() {
    }

    public void print(String name, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(name + " : " + i);
        }
    }

    public synchronized void printSync(String name, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
