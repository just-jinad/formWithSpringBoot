package com.example.myFirstApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class DownloadController {
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) {
        try {

            Resource resource = new ClassPathResource("About.txt");

            response.setContentType("text/plain");

            response.setHeader("Content-Disposition", "attachment; filename=" + resource.getFilename());

            InputStream inputStream = resource.getInputStream();

            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
