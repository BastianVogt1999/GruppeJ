package com.example.tronalddump.quote;

import com.example.tronalddump.quoteDB.QuoteDBClient;
import com.example.tronalddump.quoteDB.QuoteDBResponse;
import com.example.tronalddump.quoteDB.quoteObject.Embedded;
import com.example.tronalddump.quoteDB.quoteObject.Quote;
import com.example.tronalddump.quoteDB.quoteObject.QuoteObj;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path= "tronalddump/quote")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping()
    public List<QuoteResponse> getDonaldsShit(@RequestParam("tag") String tag) {
        QuoteDBClient client = new QuoteDBClient();



            QuoteObj data = client.getData(tag);

            List<QuoteResponse> quoteResponse = new ArrayList<>();

            if(data._embedded == null){
                QuoteResponse qr = new QuoteResponse();
                qr.setErrorMessage("Keine Treffer!");
                quoteResponse.add(qr);
                return quoteResponse;

            }

            for (Quote q : data._embedded.quotes) {
                QuoteResponse qr = new QuoteResponse();

                qr.setQuote(q.value);


                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                qr.setDate(sdf.format(q.appeared_at));

                Double schadensersatz = quoteService.berechneSchadensersatz();
                qr.setSchadensersatz(schadensersatz);

                quoteResponse.add(qr);
            }




            return quoteResponse;



    }
}
