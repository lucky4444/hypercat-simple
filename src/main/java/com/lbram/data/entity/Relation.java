package com.lbram.data.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Relation {

    public static final String REL_DESCRIPTION = "urn:X-hypercat:rels:hasDescription:en";

    @Id
    @NotNull
    private String rel;

    @NotNull
    private String val;

    public Relation() {
    }

    public Relation(String rel, String val) {
        this.rel = rel;
        this.val = val;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
