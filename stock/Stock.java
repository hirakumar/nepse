package stock;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Stock implements InterfaceStock {

    private String stock;
    private double shareCapital;
    private double totalEquity;
    private double netprofit;
    private int totalValidate;
    private Scanner input;
    public Double inputSharecapital;
    private double eps;
    private double nwps;
    private ArrayList<String> stocks;
    private boolean add;
    private boolean isReadForData;
    private String txtData;

    public Stock() {
        this.totalValidate = 0;
        input = new Scanner(System.in);
        stocks = new ArrayList<String>();
        isReadForData = false;

    }

    public ArrayList getStocks() {
        return this.stocks;
    }

    public void enterData() {
        if (this.totalValidate == 0) {
            this.inputStockName();
        }
        if (this.totalValidate == 1) {
            this.inputShareCapital();
        }
        if (this.totalValidate == 2) {
            this.inputTotalEquity();
        }
        if (this.totalValidate == 3) {
            this.inputNetProfit();
        }
        if (this.totalValidate == 4) {
            this.calculateEPS();
            this.calculateNWPS();
            this.displayData();
            this.inputIfAddStock();
        }
    }

    private void calculateEPS() {
        this.eps = this.netprofit / (this.shareCapital / 100);
    }

    private void calculateNWPS() {
        this.nwps = this.totalEquity / (this.shareCapital / 100);
    }

    private int inputStockName() {
        System.out.println("Enter stock name :");
        String inputStockname = input.nextLine();
        this.stock = inputStockname;
        this.totalValidate++;
        return this.totalValidate;
    }

    private int inputShareCapital() {
        System.out.println("Enter Share Capital:");

        try {
            inputSharecapital = input.nextDouble();
            this.shareCapital = inputSharecapital;
            this.totalValidate++;

        } catch (InputMismatchException e) {
            System.out.println("*****************************************");
            System.out.println("* Error : Invalid Data for Share Capital *");
            System.out.println("*****************************************");
        } finally {
            return this.totalValidate;
        }

    }

    private int inputTotalEquity() {
        try {
            System.out.println("Enter Total Equity:");
            double inputTotalEquity = input.nextDouble();
            this.totalEquity = inputTotalEquity;
            this.totalValidate++;
        } catch (InputMismatchException e) {
            System.out.println("Invalid Data for Share Capital");
        } finally {
            return this.totalValidate;
        }

    }

    private int inputNetProfit() {
        try {
            System.out.println("Enter Net Profit:");
            double inputNetProfit = input.nextDouble();
            this.netprofit = inputNetProfit;
            this.totalValidate++;
        } catch (InputMismatchException e) {
            System.out.println("Invalid Data for Share Capital");
        } finally {
            return this.totalValidate;
        }

    }

    private void showStocksData() {
        String astik = "******************************************";
        String dash = astik.replace("*", "-");
        System.out.println(astik);
        System.out.println("| STOCK \t | EPS \t | NWPS \t |");

        for (String stock : this.stocks) {
            System.out.println(dash);
            String[] data = stock.split(",");
            String eachData = "| " + data[0] + " \t | " + data[4] + " \t | " + data[5] + " \t |";
            System.out.println(eachData);
        }
        System.out.println(astik);
    }

    public boolean getIsReadyForData() {
        return this.isReadForData;
    }

    private void inputIfAddStock() {
        try {
            input.nextLine();
            System.out.println("Do you want to add next stock ? (y/n)");
            String ifAddStock = this.input.nextLine();
            if (ifAddStock.equals("Y") || ifAddStock.equals("y")) {
                System.out.println("You entered Y or y");
                this.totalValidate = 0;
                this.enterData();
            } else {
                System.out.println("Thank you");
                this.showStocksData();
                this.isReadForData = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Data for Share Capital");
        }
    }

    private void displayData() {
        System.out.println("*************************");
        System.out.println(this.stock);
        System.out.println("=========================");
        System.out.println("Capital \t:" + String.format("%.2f", this.shareCapital));
        System.out.println("Total Equity \t:" + String.format("%.2f", this.totalEquity));
        System.out.println("Net Profit \t:" + String.format("%.2f", this.netprofit));
        System.out.println("EPS \t\t:" + String.format("%.2f", this.eps));
        System.out.println("NWPS \t\t:" + String.format("%.2f", this.nwps));
        System.out.println("*************************");

        String stockData = this.stock + "," + String.format("%.2f", this.shareCapital).toUpperCase() + ","
                + String.format("%.2f", this.totalEquity) + "," + String.format("%.2f", this.netprofit) + ","
                + String.format("%.2f", this.eps) + "," + String.format("%.2f", this.nwps);
        this.stocks.add(stockData);

    }

}
