package com.lbram.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lbram.data.validator.ContainsDescription;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Item {

    @Id
    @NotNull
    private String href;

    @ContainsDescription
    @JsonProperty("item-metadata")
    private List<Relation> metadata;

    public Item() {
    }

    public Item(String href, String description) {
        this.href = href;
        metadata = new ArrayList<>();
        metadata.add(new Relation(StandardRelations.DESCRIPTION, description));
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Relation> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Relation> metadata) {
        this.metadata = metadata;
    }
}
