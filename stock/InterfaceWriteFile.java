package stock;

import java.util.ArrayList;

interface InterfaceWriteFile {
    public void fillDataOnFile(ArrayList mydata, String mypath, String myfilename);

    private void readDataFile(String mypath, String myfilename);

    public void createFile(String mypath, String myfilename);
}
