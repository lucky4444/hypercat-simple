package com.lbram.data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbram.data.entity.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private IItemService itemService;

    @Before
    public void setup() throws IOException {
        itemService.deleteAll();
        ObjectMapper mapper = new ObjectMapper();
        itemService.save(mapper.readValue(getClass().getResource("/items/R1.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/R2.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/CMT1.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/CMT2.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/LFT1.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/LFT2.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/F1.json"), Item.class));
        itemService.save(mapper.readValue(getClass().getResource("/items/bla.json"), Item.class));
    }

    @Test
    public void findAll() {
        List<Item> items = itemService.findAll();
        Assert.assertEquals(8, items.size());
    }

    @Test
    public void findSingleByRelAndVal() {
        String rel = "urn:X-sammobile:rels:hasName";
        String val = "LFT1";

        List<Item> items = itemService.simpleSearch(null, rel, val);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals("https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=LFT1", items.get(0).getHref());
    }

    @Test
    public void findMultipleByRelAndVal() {
        String rel = "urn:X-sammobile:rels:hasType";
        String val = "machine";

        List<Item> items = itemService.simpleSearch(null, rel, val);
        Assert.assertEquals(6, items.size());
    }

    @Test
    public void findNotByRelAndVal() {
        String rel = "urn:X-sammobile:rels:hasName";
        String val = "machine";

        List<Item> items = itemService.simpleSearch(null, rel, val);
        Assert.assertEquals(0, items.size());
    }

    @Test
    public void findByVal() {
        String val = "machine";

        List<Item> items = itemService.simpleSearch(null, null, val);
        Assert.assertEquals(6, items.size());
    }

    @Test
    public void findByRel() {
        String rel = "urn:X-sammobile:rels:hasName";

        List<Item> items = itemService.simpleSearch(null, rel, null);
        Assert.assertEquals(7, items.size());
    }

    public void findByHref() {
        String href = "https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=LFT1";

        List<Item> items = itemService.simpleSearch(href, null, null);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(href, items.get(0).getHref());
    }
}
