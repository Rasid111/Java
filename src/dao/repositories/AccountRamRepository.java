package dao.repositories;

import dao.domain.Account;
import services.ActionResult;

public class AccountRamRepository {
    // Why static size?
    final private Account[] accounts = new Account[10];

    public ActionResult createAccount(Account account) {
        int emptyIndex = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (emptyIndex == -1 && accounts[i] == null) {
                emptyIndex = i;
            }
            if (accounts[i] != null && accounts[i].getAccountNumber().equals(account.getAccountNumber())) {
                return new ActionResult(false, "Account with this accountNumber already exists");
            }
        }
        if (emptyIndex != -1) {
            accounts[emptyIndex] = account;
            return new ActionResult(true, "Created");
        }
        return new ActionResult(false, "No more space for new accounts");
    }

    public ActionResult getAccount(String id) {
        for (Account account : accounts) {
            if (account == null) {
                continue;
            }
            if (account.getAccountNumber().equals(id)) {
                return new ActionResult(true, account);
            }
        }
        return new ActionResult(false, "Account not found");
    }
}
