package com.example.tronalddump.quoteDB;

import com.example.tronalddump.quoteDB.quoteObject.Quote;
import com.example.tronalddump.quoteDB.quoteObject.QuoteObj;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuoteDBResponse {
    private QuoteObj quotes;
}
