package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment) VALUES (?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, leaseContract.getVin());
            preparedStatement.setDate(2, leaseContract.getLeaseStart());
            preparedStatement.setDate(3, leaseContract.getLeaseEnd());
            preparedStatement.setDouble(4, leaseContract.getMonthlyPayment());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int contractId = generatedKeys.getInt(1);
                    leaseContract.setContractId(contractId);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
