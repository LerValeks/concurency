package AcountManagement;

public class BankAccountOperationCredit implements Runnable {
    private final int creditAmount = 500;
    private final AccountManagement accountManagement;

    public BankAccountOperationCredit(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    @Override
    public void run() {
        synchronized (accountManagement) {
            for (int i = 0; i <= 8; i++) {

                while (accountManagement.getAccountBalance() < creditAmount) {

                    try {
                        System.out.println(Thread.currentThread().getName() + "Thread interrupted");
                        accountManagement.wait();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();

                    }
                }
                Long initialBalance = accountManagement.getAccountBalance();
                accountManagement.creditToAccount(creditAmount);
                System.out.println(Thread.currentThread().getName() + " Balance:" + initialBalance + " Value taken -" + creditAmount);
            }
        }
    }
}

