package com.agfa.hap.drools.service;

import com.agfa.hap.drools.Account;


public class AccountService {

    public void transfer(Account from, Account to, long amt){
        from.setBalance(from.getBalance() - amt);
        to.setBalance(to.getBalance() + amt);
    }
}
