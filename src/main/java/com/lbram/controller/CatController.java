package com.lbram.controller;

import com.lbram.data.entity.Catalog;
import com.lbram.data.entity.Item;
import com.lbram.data.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.zip.DataFormatException;

@RequestMapping("/cat")
@RestController
public class CatController {

    private final IItemService itemService;

    @Autowired
    public CatController(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Catalog getCatalog() {
        Catalog catalog = new Catalog();
        catalog.setItems(itemService.findAll());
        return catalog;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseEntity<String> create(@RequestParam("href") String href, @RequestBody @Validated Item item) throws DataFormatException {
        if (!item.getHref().equals(href)) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
        }
        Boolean found = false;
        if (itemService.findByHref(href) != null){
            found = true;
        }
        itemService.save(item);
        if (found){
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(),HttpStatus.CREATED);
        }
    }

    @DeleteMapping
    public String delete(@RequestParam("href") String href){
        Item item = itemService.findByHref(href);
        if (item != null){
            itemService.delete(item);
        }
        return HttpStatus.OK.getReasonPhrase();
    }
}
