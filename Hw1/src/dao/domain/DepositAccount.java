package dao.domain;

public class DepositAccount extends Account {
    public DepositAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public double specialAction() {
        return addMonthlyBonus();
    }

    public double addMonthlyBonus() {
        setBalance(getBalance() * 1.01);
        return getBalance();
    }
}
