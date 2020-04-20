package com.example.test.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileUploadService {
    private final static String pathDir = System.getProperty("user.dir") + "/igm_";

    public String uploadFile(MultipartFile[] files) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //
        StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : files) {
            //добавим чтобы не было коллизий
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                String uuidFile = UUID.randomUUID().toString().substring(0, 5);


                String resultFileName = uuidFile +
                        Objects.requireNonNull(file.getOriginalFilename())
                                .replace(" ", "_");//чтобы в имени файла не*/
                // было пробелов

                File temp = new File(pathDir + resultFileName);
                try {
                    file.transferTo(temp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                URI uri = temp.toURI();
                fileNames.append(uri.toString()).append("\n");
            }
        }
        return fileNames.toString();
    }
}
