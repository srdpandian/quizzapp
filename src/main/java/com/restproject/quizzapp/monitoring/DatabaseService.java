package com.restproject.quizzapp.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements HealthIndicator{

	@Override
	public Health health() {
		System.out.println("DatabaseService health() called!");
        return Health.up().withDetail("Database Service", "Service is running").build();
	}

}
