package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        // TODO: Implement the logic to add a sales contract
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment) VALUES (?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, salesContract.getVin());
            preparedStatement.setDate(2, salesContract.getSaleDate());
            preparedStatement.setDouble(3, salesContract.getPrice());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int contractId = generatedKeys.getInt(1);
                    salesContract.setContractId(contractId);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
