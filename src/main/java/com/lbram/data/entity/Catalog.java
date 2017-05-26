package com.lbram.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lbram.data.validator.ContainsDescription;

import java.util.List;

@JsonPropertyOrder({"metadata", "items"})
public class Catalog {

    @ContainsDescription
    @JsonProperty("catalog-metadata")
    private List<Relation> metadata;

    private List<Item> items;

    public Catalog() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Relation> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Relation> metadata) {
        this.metadata = metadata;
    }
}
