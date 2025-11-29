package services;

import dao.domain.Account;
import dao.domain.DepositAccount;
import dao.domain.LoanAccount;
import dao.domain.MortgageAccount;
import dao.repositories.AccountRamRepository;

public class AccountService {
    private final AccountRamRepository repository;

    public AccountService(AccountRamRepository repository) {
        this.repository = repository;
    }

    public ActionResult createAccount(String accountNumber, String ownerName, double balance, int type) {
        if (accountNumber == null || accountNumber.isBlank()) {
            return new ActionResult(false, "Account number is blank");
        }
        if (accountNumber.length() < 4) {
            return new ActionResult(false, "Account number is too short");
        }

        if (ownerName == null || ownerName.isBlank()) {
            return new ActionResult(false, "Owner name is blank");
        }
        if (ownerName.length() < 3) {
            return new ActionResult(false, "Owner name is too short");
        }

        if (balance <= 0) {
            return new ActionResult(false, "Balance is negative");
        }

        return switch (type) {
            case 1 -> repository.createAccount(new DepositAccount(accountNumber, ownerName, balance));
            case 2 -> repository.createAccount(new LoanAccount(accountNumber, ownerName, balance));
            case 3 -> repository.createAccount(new MortgageAccount(accountNumber, ownerName, balance));
            default -> new ActionResult(false, "Invalid type of account");
        };
    }

    public ActionResult deposit(String accountId, double amount) {
        var result = repository.getAccount(accountId);
        if (!result.success) {
            return result;
        }
        if (result.value instanceof Account account) {
            account.setBalance(account.getBalance() + amount);
            return new ActionResult(true, "Balance is now " + account.getBalance());
        }
        return new ActionResult(false, "500");
    }

    public ActionResult withdraw(String accountId, double amount) {
        var result = repository.getAccount(accountId);
        if (!result.success) {
            return result;
        }
        if (result.value instanceof Account account) {
            account.setBalance(account.getBalance() - amount);
            return new ActionResult(true, "Balance is now " + account.getBalance());
        }
        return new ActionResult(false, "500");
    }

    public ActionResult runSpecialAction(String accountId) {
        var result = repository.getAccount(accountId);
        if (!result.success) {
            return result;
        }
        if (result.value instanceof Account account) {
            var balance = account.specialAction();
            return new ActionResult(true, "Balance is now " + balance);
        }
        return new ActionResult(false, "500");
    }

    public ActionResult getAccountInfo(String accountId) {
        var result = repository.getAccount(accountId);
        if (!result.success) {
            return result;
        }
        if (result.value instanceof Account account) {
            return new ActionResult(true, account.toString());
        }
        return new ActionResult(false, "500");
    }
}
