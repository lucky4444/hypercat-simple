package com.lbram.controller;

import com.lbram.data.entity.Catalog;
import com.lbram.data.entity.Item;
import com.lbram.data.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lbram on 26.05.2017.
 */
@RequestMapping("/cat")
@RestController
public class HomeController {

  @Autowired
  public IItemService itemService;

  @GetMapping
  public Catalog getCatalog(){
    Catalog catalog = new Catalog();
    catalog.setItems(itemService.findAll());
    return catalog;
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestParam("href") String href, @RequestBody @Validated Item item){
    if (!item.getHref().equals(href)){
      return new ResponseEntity<>("Error occurred", HttpStatus.BAD_REQUEST);
    }else{
      itemService.save(item);
      return new ResponseEntity<>("CREATED", HttpStatus.OK);
    }
  }
}
