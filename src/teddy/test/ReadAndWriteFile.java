package teddy.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadAndWriteFile {

    public static void main(String[] args) {
        try {
            String filename = "input.txt";
            Scanner scanner = new Scanner(new File(filename));

            String outfilename = "output.txt";
            PrintWriter pw = new PrintWriter(new FileWriter(outfilename));
            ArrayList<String> lines = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            for (int i = lines.size() - 1; i >= 0; i -=2 ) {
                pw.write(lines.get(i-1) + "\n");
                pw.write(lines.get(i) + "\n");
            }

            scanner.close();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
