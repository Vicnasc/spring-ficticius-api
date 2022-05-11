//package com.totvs.ficticius.carsapi.infrastructure.repositories;
//
//import com.totvs.ficticius.carsapi.domain.cars.repositories.ICarRepository;
//import com.totvs.ficticius.carsapi.infrastructure.databases.PostgresFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//@Repository
//public class CarRepositoryJdbc implements ICarRepository {
//    private final PostgresFactory postgresFactory;
//    private PreparedStatement preparedStatement;
//
//    @Autowired
//    public CarRepositoryJdbc(PostgresFactory postgresFactory) {
//        this.postgresFactory = postgresFactory;
//    }
//
//    public ResultSet save(String table, String columns, String[] values) throws SQLException {
//        String sql = "INSERT INTO " + table + "(" + columns + ") VALUES (" + Arrays.stream(values).map(value -> "'" + value + "'").collect(Collectors.joining(", ")) + ");";
//        preparedStatement = postgresFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.executeUpdate();
//
//        ResultSet response = preparedStatement.getGeneratedKeys();
//        response.next();
//
//        return response;
//    }
//
//    public ResultSet select(String columns, String table, String where) throws SQLException {
//        StringBuilder sql = new StringBuilder("SELECT " + columns + " FROM " + table);
//        if (!where.isEmpty()) {
//            sql.append(" " + where);
//        }
//        preparedStatement = postgresFactory.getConnection().prepareStatement(sql.toString());
//        return preparedStatement.executeQuery();
//    }
//
//    public ResultSet select(String columns, String table) throws SQLException {
//        return select(columns, table, ";");
//    }
//}
