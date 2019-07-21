package AcountManagement;

public class AccountManagement {

    private long accountBalance;

    public AccountManagement(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public synchronized   void debitToAccount(long value){
        accountBalance+=value;
    }
    public synchronized  void creditToAccount(long value){
        accountBalance-=value;
    }

    public long getAccountBalance() {
        return accountBalance;
    }
}
