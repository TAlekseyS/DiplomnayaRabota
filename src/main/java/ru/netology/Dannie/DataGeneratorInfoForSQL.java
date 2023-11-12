package ru.netology.Dannie;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DataGeneratorInfoForSQL {
    private static String url = System.getProperty("db.url");
    private static String user = System.getProperty("db.user");
    private static String password = System.getProperty("db.password");


    @SneakyThrows
    public static void clearBD() {
        val deletePaymentEntity = "DELETE FROM payment_entity";
        val deleteCreditEntity = "DELETE FROM credit_request_entity";
        val deleteOrderEntity = "DELETE FROM order_entity";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                url, user, password)
        ) {
            runner.update(conn, deletePaymentEntity);
            runner.update(conn, deleteCreditEntity);
            runner.update(conn, deleteOrderEntity);
        }
    }

    @SneakyThrows
    public static String getPaymentGateStatus() {
        String status = "SELECT status FROM payment_entity";
        return getOnlyStatus(status);
    }

    @SneakyThrows
    public static String getCreditGateStatus() {
        String status = "SELECT status FROM credit_request_entity";
        return getOnlyStatus(status);
    }

    @SneakyThrows
    public static String getOnlyStatus(String status) {
        String result = "";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                url, user, password)
        ) {
            result = runner.query(conn, status, new ScalarHandler<String>());
            System.out.println(result);
            return result;
        }
    }
}

