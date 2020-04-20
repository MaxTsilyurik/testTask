package com.example.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Timestamp;

@Service
public class StatisticServices {
    @Autowired
    UserServices userServices;


    public void getStatistic(String status, String date, Model model){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (status.isEmpty() && date.isEmpty()) {
            model.addAttribute("stat", userServices.getUserList());
        } else if (!status.isEmpty() && date.isEmpty())
            if (status.equals("Online") || status.equals("Offline")) {
                model.addAttribute("stat", userServices.getUsersStat(status));
            } else {
                model.addAttribute("error", "Введен неверный статус");
            }
        else if (status.isEmpty()){
            try {
                model.addAttribute("stat", userServices.getUsersDate(Timestamp.valueOf(date)));
            }
            catch (IllegalArgumentException ex){
                model.addAttribute("error", "Неверный формат даты");
            }

        } else if (status.equals("Online") || status.equals("Offline")){
            try {
                model.addAttribute("stat", userServices.getUserDateAndStatus(Timestamp.valueOf(date),status));
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", "Неверный формат даты");
            }
        } else {
            model.addAttribute("error", "Введен неверный статус");
        }
    }
}
