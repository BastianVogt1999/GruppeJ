package com.example.tronalddump.quote;


import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QuoteService {
	
	public String berechneSchadensersatz(String quote, String created_at) {
		
		int wordCount = 0;
	    boolean word = false;
	    int endOfLine = quote.length() - 1;
	    for (int i = 0; i < quote.length(); i++) {
	        if (Character.isLetter(quote.charAt(i)) && i != endOfLine) {
	            word = true;
	        } else if (!Character.isLetter(quote.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	        } else if (Character.isLetter(quote.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
		double schaden = 0.0;
		int staticVar = 1000;
        Date quoteDate = null;
        try {
            quoteDate = new SimpleDateFormat("dd.MM.yyyy").parse(created_at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date nowDate = new Date();
		int quoteYear = Integer.valueOf(sdf.format(quoteDate));
		int nowYear = Integer.valueOf(sdf.format(nowDate));
		int differenz = (nowYear - quoteYear) +1;
        double random = Math.random() * 5;
		schaden = ((wordCount * differenz) /100 + random) * staticVar;


        DecimalFormat df = new DecimalFormat("#0.00");
        String schadensersatz = df.format(schaden);
		
		return schadensersatz;
    }
}
