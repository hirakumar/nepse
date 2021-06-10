package stock;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ReadFile {
    public ReadFile(String mypath, String myfilename) {
        try {
            File file = new File(myfilename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File not found :", myfilename);
            e.printStackTrace();
        }
    }
}
