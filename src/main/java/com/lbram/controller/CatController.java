package com.lbram.controller;

import com.lbram.data.entity.Catalogue;
import com.lbram.data.entity.Item;
import com.lbram.data.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cat")
@RestController
public class CatController {

    private final IItemService itemService;

    @Autowired
    public CatController(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Catalogue getCatalog(@RequestParam(name = "href", required = false) String href,
                                @RequestParam(name = "val", required = false) String val,
                                @RequestParam(name = "rel", required = false) String rel) {

        List<Item> items = itemService.simpleSearch(href, rel, val);
        Catalogue catalogue = new Catalogue();
        catalogue.setItems(items);
        return catalogue;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseEntity<String> create(@RequestParam("href") String href, @RequestBody @Validated Item item) {
        if (!item.getHref().equals(href)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
        }
        Boolean found = false;
        if (itemService.findByHref(href) != null) {
            found = true;
        }
        itemService.save(item);
        if (found) {
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ResponseEntity<String> update(@RequestParam("href") String href, @RequestBody @Validated Item item) {
        if (itemService.findByHref(href) != null) {
            itemService.update(href, item);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("href") String href) {
        Item item = itemService.findByHref(href);
        if (item != null) {
            itemService.delete(item);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }

    }
}
