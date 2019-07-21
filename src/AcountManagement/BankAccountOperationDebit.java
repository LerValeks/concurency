package AcountManagement;

public class BankAccountOperationDebit implements Runnable {
    private final AccountManagement accountManagement;

    public BankAccountOperationDebit(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    @Override
    public void run() {

        for(int i = 0;i<=3; i++) {
            Long initialBalance = accountManagement.getAccountBalance();
            accountManagement.debitToAccount(300);
            System.out.println(Thread.currentThread().getName() + " Balance:" + initialBalance + " Value added +" +300 );
        }
    }
}
