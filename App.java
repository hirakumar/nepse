import stock.Stock;
import stock.WriteFile;
import stock.ReadFile;
import java.util.Scanner;

final class App {
    private Stock stock;

    private void enterData() {
        stock = new Stock();
        WriteFile writeMyFile = new WriteFile();
        stock.enterData();

        if (stock.getIsReadyForData()) {
            System.out.println(stock.getStocks());
            writeMyFile.createFile("./", "mytext.txt");
            writeMyFile.fillDataOnFile(stock.getStocks(), "./", "mytext.txt");
        }

    }

    private void showData() {
        ReadFile readFile = new ReadFile("./", "mytext.txt");

    }

    public static void main(String[] args) {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu : 1. Enter Stock Data \t 2.Show Data");
        String menu = scanner.nextLine();

        if (menu.equals("1")) {
            app.enterData();
        } else if (menu.equals("2")) {
            app.showData();
        } else {
            System.out.println("You are required to type either 1 or 2");
        }
    }
}
