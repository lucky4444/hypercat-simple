package com.lbram.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lbram.data.validator.ContainsDescription;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"metadata", "items"})
public class Catalogue {

    @ContainsDescription
    @JsonProperty("catalogue-metadata")
    private List<Relation> metadata;

    private List<Item> items;

    public Catalogue() {
        metadata = new ArrayList<>();
        metadata.add(new Relation(StandardRelations.DESCRIPTION,"A Simple Hypercat Catalogue"));
        metadata.add(new Relation(StandardRelations.CONTENT_TYPE,"application/vnd.hypercat.catalogue+json"));
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
