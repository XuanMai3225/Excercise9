package oop_excercise9;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<Room> roomList;
    
    public RoomList(){
        roomList = new ArrayList<>();
    }
    
    public void addRoom(Room room){
        roomList.add(room);
    }
    
    public boolean updateRoomById(String id, Room idRoom){
        for(int i = 0; i < roomList.size(); i++){
            if(roomList.get(i).getId().equals(id)){  //Ktra id phòng vs id cần tìm
                roomList.set(i, idRoom);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteRoomById(String id){  //removeIf biểu thức lambda để kiểm tra
        return roomList.removeIf(room -> room.getId().equals(id));
    }
    
    public Room findRoomById(String id){
        for(Room room : roomList){
            if(room.getId().equals(id)){
                return room;
            }
        }
        return null;
    }
    
    public void displayAllRoom(){
        for(Room room : roomList){
            room.displayDetails();
        }
    }
    
    public Room findMostExpensiveRoom(){
        if(roomList.isEmpty()){
            return null;
        }
        Room mostExpensive = roomList.get(0);  //Giả sử room đầu tiên đắt nhất
        for(Room room : roomList){
            if(room.calculateCost() > mostExpensive.calculateCost()){
                mostExpensive = room;
            }
        }
        return mostExpensive;
    }
    
    public void countRoom(){
        int meetingRoom = 0;
        int bedRoom = 0;    
        for(Room room : roomList){
            if(room instanceof MeetingRoom){
                meetingRoom++;
            }else if(room instanceof BedRoom){
                bedRoom++;
            }
        }
        System.out.println("Count Meeting Room: " +meetingRoom);
        System.out.println("Count Bed Room: " +bedRoom);
    }
}
