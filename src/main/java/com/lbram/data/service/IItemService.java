package com.lbram.data.service;

import com.lbram.data.entity.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by lbram on 26.05.2017.
 */
public interface IItemService {
    void save(Item item);

    void delete(Item item);

    List<Item> find(Query query);

    List<Item> findAll();

    void deleteAll();

    Item findByHref(String href);

    List<Item> findByExample(Item item);

    List<Item> findByQuery(Query query);

    List<Item> simpleSearch(String href, String rel, String val);

    void update(String href, Item item);
}
