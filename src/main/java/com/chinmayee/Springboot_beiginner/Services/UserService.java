package com.chinmayee.Springboot_beiginner.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chinmayee.Springboot_beiginner.models.User;
@Service
public class UserService {
    private List<User> allUsers;
    int nextId=3;
    UserService(){
        allUsers=new ArrayList<>();
        allUsers.add(new User(1,"John Doe","Male","/images/john.png"));
        allUsers.add(new User(2,"Jane Doe","Female","/images/jane.png"));
    }
    public List<User> getAllUsers(){
        return allUsers;
    }
    public User getUserById(int id){
        for(User user:allUsers){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User addUser(User user){
        user.setId(nextId++);
        allUsers.add(user);
        return user;
    }
    public User updateUser(int id, User user){
        for(User u:allUsers){
            if(u.getId()==id){
                u.setName(user.getName());
                u.setGender(user.getGender());
                u.setImage(user.getImage());
                return u;  
            }
        }
        return null;
    }
    public boolean deleteUser(int id){
        for(User u:allUsers){
            if(u.getId()==id){
                allUsers.remove(u);
                return true;
            }
        }
        return false;
    }
}
