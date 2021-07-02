package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager implements ManagerService<Account>{
    protected static List<Account> accountList;

    static {
        accountList = new ArrayList<>();
        accountList.add(new Account("admin","1q2w3e"));
    }
    @Override
    public List<Account> showAll() {
        return accountList;
    }

    @Override
    public void add (Account account) {
        accountList.add(account);
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    public int findByID(String userID) {
        for (Account account:accountList) {
            if(account.getUserID().equals(userID)) {
                return accountList.indexOf(account);
            }
        }
        return -1;
    }

    @Override
    public void update(int idx, Account account) {
        for (Account c_account: accountList) {
            if(idx==findByID(c_account.getUserID())) {
                c_account = account;
            }
        }
    }

    @Override
    public void delete(int idx) {
        accountList.removeIf(account -> findByID(account.getUserID())==idx);
    }
}
