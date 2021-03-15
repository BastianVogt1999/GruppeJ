package com.example.tronalddump.quoteDB.quoteObject;

import java.util.Date;
import java.util.List;


public class Quote {
    public Date appeared_at;
    public Date created_at;
    public String quote_id;
    public List<String> tags;
    public Date updated_at;
    public String value;
    public Embedded2 _embedded;
    public Links _links;


}
