package com.bootcamp.demo.demo_api.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// ! @EnableScheduling -> Spring Manager finds a bean with @Scheduled method
@Component
public class AppScheduler {
   @Scheduled(fixedDelay = 1000) // 1000ms = 1 second
   public void sayHello() throws InterruptedException {
     long startTime = System.currentTimeMillis(); // unix time
     Thread.sleep(3000L);
     System.out.println("Hello World!!!! startTime" + startTime);
   }

  // fixedDelay: Delay: start counting time after finishing the last task,
  // fixedRate: number of tasks must fulfill
  // Cannot support both functions.
  @Scheduled(fixedDelay = 2000) // 2000ms = 2 seconds
  public void sayGoodBye() throws InterruptedException {
    long startTime = System.currentTimeMillis(); // unix time
    Thread.sleep(3000L);
    System.out.println("GoodBye!!!! startTime" + startTime);
  }  
  @Scheduled(cron = "0 41 21 * * 1#2") 
  // Run every weekday at 12 PM and 6 PM.
    public void runTask() {
        // Your task logic here
        System.out.println("Testing cron job.");
    }
}
