package AcountManagement;

public class BankAccountOperationCredit implements Runnable {

    private final AccountManagement accountManagement;

    public BankAccountOperationCredit(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 3; i++) {
            Long initialBalance = accountManagement.getAccountBalance();
            accountManagement.creditToAccount(500);
            System.out.println(Thread.currentThread().getName() + " Balance:" + initialBalance + " Value taken -" +500);

        }
    }
}

