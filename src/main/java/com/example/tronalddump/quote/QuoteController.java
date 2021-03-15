package com.example.tronalddump.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "tronalddump/quote")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    //Vorsicht! Lustiger Methodenname lul :D
    @GetMapping()
    public Quote getDonaldsShit() {
        return quoteService.getDonaldsShit();
    }
}
