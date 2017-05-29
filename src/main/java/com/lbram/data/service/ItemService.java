package com.lbram.data.service;

import com.lbram.data.entity.Item;
import com.lbram.data.entity.Relation;
import com.lbram.data.repository.ItemRepository;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by lbram on 26.05.2017.
 */
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Mongo mongo;

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
    public Item findByHref(String href) {
        return itemRepository.findOne(href);
    }

    @Override
    public List<Item> findByExample(Item item) {
        return itemRepository.findAll(Example.of(item));
    }

    @Override
    public List<Item> findByQuery(Query query) {
        return mongoTemplate.find(query, Item.class);
    }

    @Override
    public List<Item> simpleSearch(String href, String rel, String val) {
        Query query = new Query();
        if (href != null) {
            query.addCriteria(Criteria.where("href").is(href));
        }
        if (rel != null && val != null){
            query.addCriteria(Criteria.where("metadata").is(new Relation(rel,val)));
        }else if (rel != null){
            query.addCriteria(Criteria.where("metadata.rel").is(rel));
        }else if (val != null){
            query.addCriteria(Criteria.where("metadata.val").is(val));
        }
        return mongoTemplate.find(query,Item.class);
    }
}
