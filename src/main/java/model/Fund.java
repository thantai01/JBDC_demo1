package model;

public class Fund {
    private String fundName;
    private double fundBalance;

    public Fund(String fundName, double fundBalance) {
        this.fundName = fundName;
        this.fundBalance = fundBalance;
    }

    public Fund() {
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public double getFundBalance() {
        return fundBalance;
    }

    public void setFundBalance(double fundBalance) {
        this.fundBalance = fundBalance;
    }
}
