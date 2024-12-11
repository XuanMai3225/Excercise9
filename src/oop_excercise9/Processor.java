package oop_excercise9;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        RoomList roomList = new RoomList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========== ROOM MANAGEMENT ==========");
            System.out.println("1. Add New Meeting Room");
            System.out.println("2. Add New Bed Room");
            System.out.println("3. Update Room");
            System.out.println("4. Delete Room");
            System.out.println("5. Find Room");
            System.out.println("6. Display All Room");
            System.out.println("7. Find The MOst Expensive Room");
            System.out.println("8. Count Total Number Of Room");
            System.out.println("9. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("---- Add New Meeting Room ----");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    roomList.addRoom(new MeetingRoom(id, name, baseCost, capacity));
                    System.out.println("Meeting Room Add Successfull");
                    break;

                case 2:
                    System.out.println("---- Add New Bed Room ----");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Number Of Beds: ");
                    int numberOfBeds = scanner.nextInt();
                    scanner.nextLine();
                    roomList.addRoom(new BedRoom(id, name, baseCost, numberOfBeds));
                    System.out.println("Bed Room Add Successful");
                    break;


                case 3:
                    System.out.println("---- Update Room ----");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    scanner.nextLine();
                    int Type = scanner.nextInt();
                    if(Type == 1){
                        System.out.print("Enter capacity: ");
                        int Capacity =scanner.nextInt();
                        roomList.updateRoomById(id, new MeetingRoom(id, name, baseCost, capacity));
                    }else{
                        System.out.print("Enter Number Of Beds: ");
                        int NumberOfBeds = scanner.nextInt();
                        roomList.updateRoomById(id, new BedRoom(id, name, baseCost, numberOfBeds));
                    }
                    break;

                case 4:
                    System.out.println("---- Delete Room ----");
                    System.out.print("Enter ID: ");
                    String deleteId = scanner.nextLine();
                    if(!roomList.deleteRoomById(deleteId)){
                        System.out.println("Successful");
                    }else{
                        System.out.println("No Successful");
                    }
                    break;


                case 5:
                    System.out.println("---- Find Room ----");
                    System.out.print("Enter ID: ");
                    String findId = scanner.next();
                    Room findRoom = roomList.findRoomById(id);
                    if (findRoom != null) {
                        findRoom.displayDetails();
                    } else {
                        System.out.println("Find Room No Successful");
                    }
                    break;

                case 6:
                    System.out.println("---- Display All Room ----");
                    roomList.displayAllRoom();
                    break;

                case 7:
                    System.out.println("---- Find Most Expensive Room ----");
                    Room expensiveRoom = roomList.findMostExpensiveRoom();
                    if (expensiveRoom != null) {
                        expensiveRoom.displayDetails();
                    } else {
                        System.out.println("Find Room No Successful");
                    }
                    break;

                case 8:
                    System.out.println("---- Count Room ----");
                    roomList.countRoom();
                    break;

                case 9:
                    System.out.println("EXIT");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }while(choice != 9);
        scanner.close();
    }
}
