package com.example.test.service;


import com.example.test.domain.User;
import com.example.test.repos.UserRepo;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserServices {
    private static final String sdf = "dd-MM-yyyy HH:mm:ss";

    @Autowired
    private UserRepo userRepo;

    public User saveNewUser(String name, String email,
                            String uri, String active) {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User user = new User(name, email, uri, active);

        userRepo.save(user);
        return user;
    }

    public List<User> getUserList() {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userRepo.findAllByOrderByIdAsc();
    }
    public Pair<User,String> saveNewStatus(Integer id, String newStatus){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User tmp = userRepo.findById(id).get();
        String oldStat = tmp.getActive();
        tmp.setActive(newStatus);
        userRepo.save(tmp);

        return new Pair<>(tmp,oldStat);
    }

    public List<User> getUsersStat(String status) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepo.findByActive(status);
    }
    
    public List<User> getUsersDate(Timestamp date){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepo.findByTimestampGreaterThan(date);
    }

    public List<User> getUserDateAndStatus(Date date, String status){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepo.findByTimestampGreaterThanAndActive(date,status);
    }
}
