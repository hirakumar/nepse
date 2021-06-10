package stock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class WriteFile implements InterfaceWriteFile {

    private String filename;
    private String path;
    private String data;

    public void createFile(String mypath, String myfilename) {
        try {
            File myfile = new File(mypath + myfilename);
            if (myfile.createNewFile()) {
                System.out.println("File is  created");
            } else {
                System.out.println("File has been already created");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry no file has been created");
        }
    }

    public void fillDataOnFile(ArrayList mydata, String mypath, String myfilename) {

        try {
            String csvData = "Stock,Capital,Equity,Net Profit,EPS,NWPS";
            /*
             * for (int i = 0; i < mydata.size(); i++) { csvData += "\n" + mydata.get(i); }
             */

            FileWriter myWriter = new FileWriter(mypath + myfilename);
            myWriter.write(csvData);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred on writing file : " + mypath + myfilename);
            e.printStackTrace();
        }
    }

    private void readDataFile(String mypath, String myfilename) {
        System.out.println("readDataFile...");
    }
}
