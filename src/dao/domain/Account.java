package dao.domain;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            System.out.println("Account number is blank");
            return;
        }
        if (accountNumber.length() < 4) {
            System.out.println("Account number is too short");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            System.out.println("Owner name is blank");
            return;
        }
        if (ownerName.length() < 3) {
            System.out.println("Owner name is too short");
            return;
        }
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance is negative");
            return;
        }
        this.balance = balance;
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public boolean Deposit(double amount) {
        if (amount < 0) {
            System.out.println("Amount is negative");
            return false;
        }
        setBalance(getBalance() + amount);
        return true;
    }

    public boolean Withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Amount is negative");
            return false;
        }
        setBalance(getBalance() - amount);
        return true;
    }

    public double specialAction() {
        throw new UnsupportedOperationException("No interfaces yet.");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getAccountNumber(), account.getAccountNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getAccountNumber());
    }
}
