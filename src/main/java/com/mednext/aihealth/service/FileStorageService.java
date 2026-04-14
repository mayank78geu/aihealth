package com.mednext.aihealth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private final String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";

    public String save(MultipartFile file) {
        try {
            // Create directory if not exists
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            File destination = new File(dir, fileName);

            file.transferTo(destination);

            return destination.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace(); // IMPORTANT for debugging
            throw new RuntimeException("File upload Failed !");
        }
    }
}