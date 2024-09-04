package com.ems.starter.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImgService {
    public String uploadImage(String path, MultipartFile file){

        String filename = file.getOriginalFilename();
        String randomID = UUID.randomUUID().toString();
        @SuppressWarnings("null")
        String modified_filename = randomID.concat(filename.substring(filename.lastIndexOf(".")));
        String filepath = path + modified_filename;

        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        try {
            Files.copy(file.getInputStream(), Paths.get(filepath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return modified_filename;
    }

}

