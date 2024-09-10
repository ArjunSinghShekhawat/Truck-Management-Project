package org.example;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        TruckService truckService = new TruckService();

        while(true){

            System.out.println("1.Add Truck");
            System.out.println("2.Update Truck");
            System.out.println("3.Delete Truck");
            System.out.println("4.Read One Truck");
            System.out.println("5.Read All Truck");
            System.out.println("6.Quite");

            System.out.println();

            System.out.println("Enter your choice");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter truck name");
                    String name= scanner.next();

                    System.out.println("Enter truck model");
                    String model = scanner.next();

                    System.out.println("Enter truck capacity");
                    String capacity = scanner.next();

                    System.out.println("Enter driver name");
                    String driverName = scanner.next();

                    Truck truck = new Truck(name,model,capacity,driverName);
                    truckService.addTruck(truck);
                    System.out.println("Truck add successfully !");
                    System.out.println();
                    break;
                case 2:

                    System.out.println("Enter Id for Updating purpose !");
                    int id = scanner.nextInt();

                    System.out.println("Enter truck name");
                    String updatedName= scanner.next();

                    System.out.println("Enter truck model");
                    String updatedModel = scanner.next();

                    System.out.println("Enter truck capacity");
                    String updatedCapacity = scanner.next();

                    System.out.println("Enter driver name");
                    String updatedDriverName = scanner.next();

                    Truck updatedTruck = new Truck(updatedName,updatedModel,updatedCapacity,updatedDriverName);
                    truckService.updateTruck(id,updatedTruck);

                    System.out.println("Truck update successfully");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter Id for deleting purpose !");
                    int deletingTruckId = scanner.nextInt();

                    truckService.deleteTructById(deletingTruckId);
                    System.out.println("delete truck successfully ");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter Id for reading purpose !");
                    int readTruckId = scanner.nextInt();

                    Truck truck1 = truckService.readTruckById(readTruckId);

                    System.out.println("Id : "+truck1.getId()+" Name : "+truck1.getName()+" Model : "+truck1.getModel()+" Capacity : "+truck1.getCapacity()+" Driver Name : "+truck1.getDriver_name());

                    System.out.println("Read truck successfully ");
                    System.out.println();
                    break;
                case 5:
                    List<Truck>list = truckService.getAllTruck();

                    System.out.println("Print all truck data \n");

                    for(Truck t:list){
                        System.out.println("Id : "+t.getId()+" Name : "+t.getName()+" Model : "+t.getModel()+" Capacity : "+t.getCapacity()+" Driver Name : "+t.getDriver_name());
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("End.........");
                    System.exit(1);
                default:
                    System.out.println("Please enter correct choice !");
            }

        }

    }
}
