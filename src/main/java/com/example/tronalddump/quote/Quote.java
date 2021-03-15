package com.example.tronalddump.quote;

public class Quote {
    private String appeared_at;
    private String created_at;
    private String qoute_id;
    private String[] tags;
    private String upvoted_at;
    private String value;
    private Object _embedded;
    private Object _links;


    public Quote(String appeared_at, String created_at, String qoute_id, String[] tags, String upvoted_at, String value, Object _embedded, Object _links) {
        this.appeared_at = appeared_at;
        this.created_at = created_at;
        this.qoute_id = qoute_id;
        this.tags = tags;
        this.upvoted_at = upvoted_at;
        this.value = value;
        this._embedded = _embedded;
        this._links = _links;
    }

    public Quote() {
    }

    public String getAppeared_at() {
        return appeared_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getQoute_id() {
        return qoute_id;
    }

    public String[] getTags() {
        return tags;
    }

    public String getUpvoted_at() {
        return upvoted_at;
    }

    public String getValue() {
        return value;
    }

    public Object get_embedded() {
        return _embedded;
    }

    public Object get_links() {
        return _links;
    }

    public void setAppeared_at(String appeared_at) {
        this.appeared_at = appeared_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setQoute_id(String qoute_id) {
        this.qoute_id = qoute_id;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setUpvoted_at(String upvoted_at) {
        this.upvoted_at = upvoted_at;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void set_embedded(Object _embedded) {
        this._embedded = _embedded;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
