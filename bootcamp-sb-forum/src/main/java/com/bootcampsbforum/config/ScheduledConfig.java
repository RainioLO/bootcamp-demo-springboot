package com.bootcampsbforum.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {

  // @Scheduled(fixedRate = 2000)
  public void fixedRateTask() throws InterruptedException {
    // System.out.println("Start: fixedRateTask" + System.currentTimeMillis());
    // Thread.sleep(1000);
    // System.out.println("End: fixedRateTask");
    // }

    // // @Scheduled(fixedDelay = 2000)
    // public void fixedDelayTask() throws InterruptedException {
    // System.out.println("Start: fixedDelayTask" + System.currentTimeMillis());
    // Thread.sleep(1000);
    // System.out.println("End: fixedDelayTask");
    // }

    // // @Scheduled(cron = "*/5 * * * * ?") // every 5 sec, similar to fixedDelay
    // public void cronTask() throws InterruptedException {
    // System.out.println("start cron");
    // Thread.sleep(10000);
    // System.out.println("end cron");
    // }

    // @Scheduled(cron = "5 * * * * ?") // every 5 sec, similar to fixedDelay
    // public void cronTask5() throws InterruptedException {
    // System.out.println("start cronTask5");
    // Thread.sleep(10000);
    // System.out.println("end cronTask5");
    // }

    // @Scheduled(cron = "10 * * * * ?") // every 10 sec, similar to fixedDelay
    // public void cronTask10() throws InterruptedException {
    // System.out.println("start cronTask10");
    // Thread.sleep(10000);
    // System.out.println("end cronTask10");
    // }
  }
}
