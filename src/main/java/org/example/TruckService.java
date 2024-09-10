package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    public void addTruck(Truck truck){

        String query = "insert into trucks (name,model,capacity,driver_name) values(?,?,?,?)";

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setString(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());

            int i = preparedStatement.executeUpdate();

            System.out.println("Reflect row "+i);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Truck readTruckById(int id){

        String query = "select * from trucks where id=?";
        Truck truck = new Truck();

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setCapacity(resultSet.getString("capacity"));
                truck.setModel(resultSet.getString("model"));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return truck;
    }
    public void updateTruck(int id,Truck truck){

        String query = "update trucks set name=?,model=?,capacity=?,driver_name=? where id=?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setString(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());
            preparedStatement.setInt(5  ,id);

            int i = preparedStatement.executeUpdate();

            System.out.println("Reflect rows "+i);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Truck>getAllTruck(){

        String query = "select * from trucks";
        List<Truck>list = new ArrayList<>();
        try{
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setCapacity(resultSet.getString("capacity"));
                truck.setModel(resultSet.getString("model"));
                truck.setDriver_name(resultSet.getString("driver_name"));

                list.add(truck);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public  void deleteTructById(int id){

        String query = "delete from trucks where id=?";

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();

            System.out.println("Reflect rows "+i);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
