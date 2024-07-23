package com.AdsApp.AdsApp.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AdsApp.AdsApp.service.ProductionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Enable CORS for Angular
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }

        try {
            // Save the file to a location on the server
            String uploadDir = "uploads/";
            File uploadFile = new File(uploadDir + file.getOriginalFilename());
            file.transferTo(uploadFile);

            // Get the file extension
            String fileName = file.getOriginalFilename();
            String fileExtension = getFileExtension(fileName);


            // Save the file path in the database
            productionService.saveFilePath(uploadFile.getAbsolutePath());

            return "You successfully uploaded, processed, and saved the file path.";

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload and process file.";
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

   
}