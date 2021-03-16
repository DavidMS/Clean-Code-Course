package org.dms.functionalprogramming.optionals;

import java.util.Optional;

public class ClientOptional {

    private AccountOptional account;

    public Optional<AccountOptional> getAccount() {
        return Optional.ofNullable(account);
    }

    public void setAccount(AccountOptional account) {
        this.account = account;
    }
}
