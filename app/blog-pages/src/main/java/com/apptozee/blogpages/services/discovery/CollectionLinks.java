package com.apptozee.blogpages.services.discovery;

import org.springframework.hateoas.Link;

import java.util.HashMap;
import java.util.Map;

class CollectionLinks {

    private final Map<String,Links> collectionsLinks;

    public CollectionLinks(Map<String, Links> collectionLinksList) {
        collectionsLinks = collectionLinksList;
    }

    public Link getCollection(String collectionName, Object ... ids) {
        Links links = collectionsLinks.get(collectionName);
        if (links == null){
            return null;
        }

        String collectionFilled = fillIds(links.getLink(), ids);

        return new Link(collectionFilled);
    }

    private String fillIds(String link, Object ... ids) {
        // remove projections
        String formatedLink = link.replaceAll("\\{\\?.+?\\}","");

        // add next indent
        if (!formatedLink.endsWith("/")){
            formatedLink += "/{id-resource}";
        }
        // remove named arguments
        formatedLink = formatedLink.replaceAll("\\{.+?\\}","%s");



        return String.format(formatedLink,ids);
    }

    @Override
    public String toString() {
        return "CollectionLinks{" +
                "collectionsLinks=" + collectionsLinks +
                '}';
    }
}
