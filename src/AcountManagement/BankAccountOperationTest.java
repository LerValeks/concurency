package AcountManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccountOperationTest {
    public static void main(String[] arg) {

        AccountManagement balance = new AccountManagement(100);

        BankAccountOperationDebit operation1 = new BankAccountOperationDebit(balance);
        BankAccountOperationCredit operation2 = new BankAccountOperationCredit(balance);
        BankAccountOperationDebit operation3 = new BankAccountOperationDebit(balance);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(operation1);
        executorService.execute(operation2);
        executorService.execute(operation3);

        executorService.shutdown();

        try {
            // wait 1 minute for both writers to finish executing
            boolean tasksEnded =
                    executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (tasksEnded) {
                System.out.printf("Account Balance");
                System.out.println(balance.getAccountBalance()); // print contents
            } else {
                System.out.println(
                        "Timed out while waiting for tasks to finish.");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
