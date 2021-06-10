import stock.Stock;
import stock.WriteFile;
import java.util.ArrayList;

final class App {

    public static void main(String[] args) {

        Stock stock = new Stock();
        WriteFile writeMyFile = new WriteFile();
        stock.enterData();

        if (stock.getIsReadyForData()) {
            System.out.println(stock.getStocks());
            writeMyFile.createFile("./", "stock.txt");
            writeMyFile.fillDataOnFile(stock.getStocks(), "./", "mytext.txt");
        }

    }
}
