package com.example.bm_project.health;

import com.example.bm_project.logger.LoggerSingleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HealthChecker implements HealthIndicator {
    LoggerSingleton logger = LoggerSingleton.getInstance();
    @Override
    public Health health() {
        long freeMemory=Runtime.getRuntime().freeMemory();
        long totalMemory= Runtime.getRuntime().totalMemory();
        double freeMemoryPercent=((double)freeMemory/(double) totalMemory)*100;
        if (freeMemoryPercent > 25){
            logger.logInfo(this.getClass(),"free_memory: "+freeMemory + " bytes");
            logger.logInfo(this.getClass(),"total_memory: "+totalMemory +" bytes");
            logger.logInfo(this.getClass(),"free_memory_percent: "+freeMemoryPercent+" %");

            //log.info("free_memory: "+freeMemory + " bytes");
            //log.info("total_memory: "+totalMemory +" bytes");
            //log.info("free_memory_percent: "+freeMemoryPercent+" %");
            return Health.up()
                    .withDetail("free_memory ",freeMemory +" bytes")
                    .withDetail("total_memory ",totalMemory +" bytes")
                    .withDetail("free_memory_percent ",freeMemoryPercent +" %")
                    .build();
        }else {
            logger.logInfo(this.getClass(),"free_memory: "+freeMemory + " bytes");
            logger.logInfo(this.getClass(),"total_memory: "+totalMemory +" bytes");
            logger.logInfo(this.getClass(),"free_memory_percent: "+freeMemoryPercent+" %");
//            log.info("free_memory: "+freeMemory + " bytes");
//            log.info("total_memory: "+totalMemory +" bytes");
//            log.info("free_memory_percent: "+freeMemoryPercent+" %");
            return Health.down()
                    .withDetail("free_memory ",freeMemory +" bytes")
                    .withDetail("total_memory ",totalMemory +" bytes")
                    .withDetail("free_memory_percent ",freeMemoryPercent +" %")
                    .build();


        }
    }
}