package dao.domain;

public class LoanAccount extends Account {
    public LoanAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public double specialAction() {
        return chargeInterest();
    }

    private double chargeInterest() {
        // setBalance(getBalance() * 0.95); ?
        setBalance(getBalance() * 1.05);
        return getBalance();
    }
}
