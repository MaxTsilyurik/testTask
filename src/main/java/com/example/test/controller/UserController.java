package com.example.test.controller;


import com.example.test.domain.User;
import com.example.test.service.UserServices;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/addUser")
    public String addUserPage() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email,
                          @RequestParam String uri, Model model) {
        User user = userServices.saveNewUser(name, email,
                uri, " ");
        model.addAttribute("id", user.getId());
        return "addUser";
    }

    @GetMapping("/userList")
    public String userListPage(Model model) {
        model.addAttribute("usersList", userServices.getUserList());
        return "userList";
    }

    @GetMapping("/userInfo/{user}")
    public String infoPage(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping(value = "/userActive/{user}", method = RequestMethod.GET)
    public String userActivePage(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userActive";
    }

    //Изменение статуса пользователя на Online or Offline
    @RequestMapping(value = "/userActive", method = RequestMethod.POST)
    public String setActive(@ModelAttribute User usr,
                            @RequestParam String status, Model model) {

        if (status.equals("Online") || status.equals("Offline")) {
            Pair<User, String> pair = userServices.saveNewStatus(usr.getId(),status);

            model.addAttribute("id", pair.getKey().getId());
            model.addAttribute("newStat", pair.getKey().getActive());
            model.addAttribute("oldStat", pair.getValue());

        } else
            model.addAttribute("error", "Ошибка:Неверный статус");
        return "userActive";
    }
}
