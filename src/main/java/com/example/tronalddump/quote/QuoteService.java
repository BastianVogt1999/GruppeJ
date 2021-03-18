package com.example.tronalddump.quote;


import org.springframework.stereotype.Service;

@Service
public class QuoteService {
	
	public double berechneSchadensersatz(String quote, String created_at) throws Exception{
		
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
		double schadensersatz = 0.0;
		int staticVar = 1000;
		Date quoteDate = new SimpleDateFormat("yyyy-MM-dd").parse(created_at);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date nowDate = new Date();
		int quoteYear = Integer.valueOf(sdf.format(quoteDate));
		int nowYear = Integer.valueOf(sdf.format(nowDate));
		int differenz = (nowYear - quoteYear) +1;
		
		schadensersatz = wordCount * differenz * staticVar;
		
		return schadensersatz;
    }
}
