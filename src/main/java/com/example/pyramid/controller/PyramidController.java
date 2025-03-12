package com.example.pyramid.controller;

import com.example.pyramid.service.PyramidService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pyramid")
public class PyramidController {
    @Resource
    private PyramidService pyramidService;

    @GetMapping("/{size}")
    public String generatePyramid(@PathVariable int size) {
        if (size <= 0) {
            throw new NumberFormatException("Please enter number.");
        }
        return pyramidService.printPyramid(size);
    }


}
