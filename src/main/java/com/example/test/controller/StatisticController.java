package com.example.test.controller;

import com.example.test.service.StatisticServices;
import com.example.test.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class StatisticController {

    @Autowired
    StatisticServices statisticServices;

    @GetMapping("/statistic")
    public String statisticPage() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "statServer";
    }

    @PostMapping("/statistic")
    public String getStatistic(@RequestParam String status,
                               @RequestParam String date,
                               Model model) {

        statisticServices.getStatistic(status, date, model);
        return "statServer";
    }
}
