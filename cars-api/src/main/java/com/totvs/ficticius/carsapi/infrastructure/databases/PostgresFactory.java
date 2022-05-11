package com.totvs.ficticius.carsapi.infrastructure.databases;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@NoArgsConstructor
public class PostgresFactory {
    private Environment env;
    private Connection connection;

    @Autowired
    public PostgresFactory(Environment env) {
        this.env = env;
    }

    private Connection createConnection() throws SQLException {
        connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));

        Statement stt = connection.createStatement();
        String brandTable = "CREATE TABLE IF NOT EXISTS brands (brand_id UUID DEFAULT gen_random_uuid(), brand_name VARCHAR(255) NOT NULL, created_at TIMESTAMPTZ DEFAULT Now(), PRIMARY KEY(brand_id));";
        String carNameTable = "CREATE TABLE IF NOT EXISTS car_names (car_name_id UUID DEFAULT gen_random_uuid(), car_name_name VARCHAR(255) NOT NULL, car_name_brand UUID NOT NULL, created_at TIMESTAMPTZ DEFAULT Now(), PRIMARY KEY(car_name_id), FOREIGN KEY (car_name_brand) REFERENCES brands (brand_id));";
        String modelTable = "CREATE TABLE IF NOT EXISTS models (model_id UUID DEFAULT gen_random_uuid(), model_name VARCHAR(255) NOT NULL, model_car_name UUID NOT NULL, created_at TIMESTAMPTZ DEFAULT Now(), PRIMARY KEY(model_id), FOREIGN KEY (model_car_name) REFERENCES car_names (car_name_id));";
        String carsTable = "CREATE TABLE IF NOT EXISTS cars (car_id UUID DEFAULT gen_random_uuid(), car_model UUID NOT NULL, car_fabrication_date INTEGER NOT NULL, car_city_consumption DOUBLE PRECISION NOT NULL, car_road_consumption DOUBLE PRECISION NOT NULL, created_at TIMESTAMPTZ DEFAULT Now(), PRIMARY KEY(car_id), FOREIGN KEY(car_model) REFERENCES models (model_id));";
        stt.execute(new StringBuilder().append(brandTable).append(carNameTable).append(modelTable).append(carsTable).toString());

        return connection;
    }

    public Connection getConnection() throws SQLException {
        return createConnection();
    }
}
