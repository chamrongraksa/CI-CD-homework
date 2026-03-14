package com.homework.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        normalizeRenderDatabaseUrl();
        SpringApplication.run(BackendApplication.class, args);
    }

    private static void normalizeRenderDatabaseUrl() {
        // Render may provide postgres:// or postgresql:// URLs, while Spring JDBC expects jdbc:postgresql://.
        String dbUrl = firstNonBlank(
                System.getenv("SPRING_DATASOURCE_URL"),
                System.getenv("DATABASE_URL")
        );

        if (dbUrl == null) {
            return;
        }

        String lower = dbUrl.toLowerCase();
        if (!(lower.startsWith("postgres://") || lower.startsWith("postgresql://"))) {
            return;
        }

        URI uri = URI.create(dbUrl);
        String portSegment = uri.getPort() > 0 ? ":" + uri.getPort() : "";
        String jdbcUrl = "jdbc:postgresql://" + uri.getHost() + portSegment + uri.getPath();
        System.setProperty("spring.datasource.url", jdbcUrl);

        String userInfo = uri.getUserInfo();
        if (userInfo == null || userInfo.isBlank()) {
            return;
        }

        String[] parts = userInfo.split(":", 2);
        if (System.getenv("SPRING_DATASOURCE_USERNAME") == null && parts.length > 0) {
            System.setProperty("spring.datasource.username", parts[0]);
        }
        if (System.getenv("SPRING_DATASOURCE_PASSWORD") == null && parts.length > 1) {
            System.setProperty("spring.datasource.password", parts[1]);
        }
    }

    private static String firstNonBlank(String... values) {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value;
            }
        }
        return null;
    }
}
