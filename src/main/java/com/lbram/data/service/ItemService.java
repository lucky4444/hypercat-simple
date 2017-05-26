package com.lbram.data.service;

import com.lbram.data.entity.Item;
import com.lbram.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lbram on 26.05.2017.
 */
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public List<Item> find(Query query) {
        return mongoTemplate.find(query, Item.class);
    }


    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    @Override
    public Item findByHref(String href){
        return itemRepository.findOne(href);
    }
}
