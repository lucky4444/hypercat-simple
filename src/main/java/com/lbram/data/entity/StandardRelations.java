package com.lbram.data.entity;

/**
 * Created by Lukas on 26.05.2017.
 */
public class StandardRelations {
    public static final String DESCRIPTION = "urn:X-hypercat:rels:hasDescription:en";
    public static final String CONTENT_TYPE = "urn:X-hypercat:rels:isContentType";

    public class Catalogue {
        public static final String CONTAINS_CONTENT_TYPE = "urn:X-hypercat:rels:containsContentTyp";
        public static final String SUPPORTS_SEARCH = "urn:X-hypercat:rels:supportsSearch";
    }

    public class Item {
        public static final String HOMEPAGE = "urn:X-hypercat:rels:hasHomepage";
    }
}
