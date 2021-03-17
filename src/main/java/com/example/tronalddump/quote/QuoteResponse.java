package com.example.tronalddump.quote;

import lombok.Data;

import java.util.Date;

@Data
public class QuoteResponse {
    private String quote;
    private String date;
    private double schadensersatz;
    private String ErrorMessage;

}
