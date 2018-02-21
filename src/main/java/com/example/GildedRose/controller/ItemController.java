package com.example.GildedRose.controller;

import com.example.GildedRose.model.Item;
import com.example.GildedRose.repository.ItemsRepository;
import com.example.GildedRose.utils.GildedRose;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemsRepository itemsRepository;

    private GildedRose gildedRose = new GildedRose();

    @GetMapping("/items/")
    public ResponseEntity getAllItems() {

        List<Item> itemList = (List<Item>) itemsRepository.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(gildedRose.updateQuality(itemList));
        return ResponseEntity.ok(json);
    }
}
