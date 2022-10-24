package com.stussy.stussyclone20220930leeyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CollectionController {

    @GetMapping("/collections/{category}")
    public String locadCollections(@PathVariable String category) {
        return "product/collections_number";
    }
}