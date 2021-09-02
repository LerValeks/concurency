package AcountManagement;

public class BankAccountOperationDebit implements Runnable {
    private final AccountManagement accountManagement;

    public BankAccountOperationDebit(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    @Override
    public void run() {

        synchronized (accountManagement) {
            for (int i = 0; i <= 10; i++) {
                Long initialBalance = accountManagement.getAccountBalance();
                accountManagement.debitToAccount(400);
                accountManagement.notifyAll();
                System.out.println(Thread.currentThread().getName() + " Balance:" + initialBalance + " Value added +" + 400);

            }
        }
    }
}
