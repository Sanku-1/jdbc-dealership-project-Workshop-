package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        // TODO: Implement the logic to add a vehicle
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vehicles (VIN, make, model, year, SOLD, color, vehicleType, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setInt(5, ((vehicle.isSold()) ? 1 : 0));
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setString(7, vehicle.getVehicleType());
            preparedStatement.setInt(8, vehicle.getOdometer());
            preparedStatement.setDouble(9, vehicle.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeVehicle(String VIN) {
        // TODO: Implement the logic to remove a vehicle
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM vehicles WHERE VIN = ?")) {
            preparedStatement.setString(1, VIN);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        // TODO: Implement the logic to search vehicles by price range
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE price BETWEEN ? and ?")) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String color = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, color, vehicleType, odometer, price);
//                    vehicles.add(vehicle);

                    vehicles.add(createVehicleFromResultSet(resultSet));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        // TODO: Implement the logic to search vehicles by make and model
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE (make = ? AND model = ?)")) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String color = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, color, vehicleType, odometer, price);
//                    vehicles.add(vehicle);
                      vehicles.add(createVehicleFromResultSet(resultSet));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        // TODO: Implement the logic to search vehicles by year range
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE year BETWEEN ? and ?")) {
            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String color = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, color, vehicleType, odometer, price);
//                    vehicles.add(vehicle);
                      vehicles.add(createVehicleFromResultSet(resultSet));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        // TODO: Implement the logic to search vehicles by color
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE color = ?")) {
            preparedStatement.setString(1, color);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String vehicleColor = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, vehicleColor, vehicleType, odometer, price);
//                    vehicles.add(vehicle);
                      vehicles.add(createVehicleFromResultSet(resultSet));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        // TODO: Implement the logic to search vehicles by mileage range
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE odometer BETWEEN ? and ?")) {
            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String color = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, color, vehicleType, odometer, price);
//                    vehicles.add(vehicle);

                    vehicles.add(createVehicleFromResultSet(resultSet));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByType(String type) {
        // TODO: Implement the logic to search vehicles by type
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE vehicleType = ?")) {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();{

                while (resultSet.next()) {
//                    String vin = resultSet.getString("VIN");
//                    String vehicleMake = resultSet.getString("make");
//                    String vehicleModel = resultSet.getString("model");
//                    int year = resultSet.getInt("year");
//                    boolean sold = (resultSet.getInt("SOLD")) == 1;
//                    String vehicleColor = resultSet.getString("color");
//                    String vehicleType = resultSet.getString("vehicleType");
//                    int odometer = resultSet.getInt("odometer");
//                    double price = resultSet.getDouble("price");
//
//                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, vehicleColor, vehicleType, odometer, price);
//                    vehicles.add(vehicle);

                     vehicles.add(createVehicleFromResultSet(resultSet));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
