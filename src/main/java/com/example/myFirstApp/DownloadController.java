package com.example.myFirstApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class DownloadController {
    @GetMapping("/download")
   public void downloadFile (HttpServletResponse response){
    try{
        //Load the file as a Resource
        Resource resource = new ClassPathResource("About.txt");

        //Set the response content type
        response.setContentType("text/plain");

        //Set the response header
        response.setHeader("Content-Disposition", "attachment; filename=" + resource.getFilename());

        // get input stream from the file resource
        InputStream inputStream = resource.getInputStream();

        // get the output stream of the response
            OutputStream outputStream = response.getOutputStream();
        
        // Copy the input stream to the output stream
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Then you close your stream
        inputStream.close();
        outputStream.close();
    }
    catch(IOException e){
        e.printStackTrace();
    }

   }
    
}
