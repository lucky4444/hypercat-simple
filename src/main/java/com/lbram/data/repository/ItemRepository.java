package com.lbram.data.repository;

import com.lbram.data.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {


}
