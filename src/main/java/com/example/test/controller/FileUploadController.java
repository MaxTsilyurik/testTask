package com.example.test.controller;

import com.example.test.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;



    @GetMapping("/loader")
    public String loadPage() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "loader";
    }

    @PostMapping("/loader")
    public String loadFile(Model model,
                           @RequestParam("files") MultipartFile[] files) {
        String filesName = fileUploadService.uploadFile(files);
        model.addAttribute("files", filesName);
        return "loader";
    }

}
