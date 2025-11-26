package dao.domain;

public class MortgageAccount extends Account {
    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public double specialAction() {
        return addMonthlyFee();
    }

    public double addMonthlyFee() {
        setBalance(getBalance() - 10);
        double balance = getBalance();
        if (balance < 0) {
            System.out.println("Balance became negative");
        }
        return balance;
    }
}
