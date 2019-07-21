package com.company;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintTask implements Runnable{
      private static final SecureRandom generator = new SecureRandom();
      private final int sleepTime; // random sleep time for thread
      private final String taskName;

      // constructor
             public PrintTask(String taskName) {
                   this.taskName = taskName;

                    // pick random sleep time between 0 and 5 seconds
                     sleepTime = generator.nextInt(5000); // milliseconds
                  }

              // method run contains the code that a thread will execute
              @Override
      public void run() {
                     try { // put thread to sleep for sleepTime amount of time
                            System.out.printf("%s going to sleep for %d milliseconds.%n",
                                       taskName, sleepTime);
                            Thread.sleep(sleepTime); // put thread to sleep
                         }
                     catch (InterruptedException exception) {
                            exception.printStackTrace();
                            Thread.currentThread().interrupt(); // re-interrupt the thread
                         }

                     // print task name
                     System.out.printf("%s done sleeping%n", taskName);
                  }

    public static void main(String[] args) {
                 // create and name each runnable
                 PrintTask task1 = new PrintTask("task1");
                 PrintTask task2 = new PrintTask("task2");
                 PrintTask task3 = new PrintTask("task3");

                 System.out.println("Starting Executor");

                 // create ExecutorService to manage threads
                 ExecutorService executorService = Executors.newCachedThreadPool();

                 // start the three PrintTasks
                 executorService.execute(task1); // start task1
                 executorService.execute(task2); // start task2
                 executorService.execute(task3); // start task3

                 // shut down ExecutorService--it decides when to shut down threads
                 executorService.shutdown();

                 System.out.printf("Tasks started, main ends.%n%n");
              }
}
