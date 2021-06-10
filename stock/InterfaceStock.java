package stock;

interface InterfaceStock {
    public void enterData();

    private void calculateNWPS();

    private void calculateEPS();

    private void add();

    private int inputStockName();

    private int inputShareCapital();

    private int inputTotalEquity();

    private int inputNetProfit();

    private void inputIfAddStock();

    private void displayData();
}