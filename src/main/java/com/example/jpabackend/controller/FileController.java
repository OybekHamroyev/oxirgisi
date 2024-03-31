package com.example.jpabackend.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/file")
public class FileController {
    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile file) throws IOException {
       String name= UUID.randomUUID()+file.getOriginalFilename();
        FileOutputStream outputStream = new FileOutputStream("files/"+name);
        outputStream.write(file.getBytes());
        outputStream.close();
        return ResponseEntity.ok(name);
    }
    @GetMapping("/{name}")
    public void getFile(@PathVariable  String name, HttpServletResponse response) throws IOException {
        FileInputStream inputStream = new FileInputStream("files/" + name);
        ServletOutputStream outputStream = response.getOutputStream();
        inputStream.transferTo(outputStream);
        outputStream.close();
        inputStream.close();
    }
}

