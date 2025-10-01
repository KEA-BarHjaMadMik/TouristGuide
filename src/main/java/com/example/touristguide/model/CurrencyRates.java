package com.example.touristguide.model;

import java.util.Date;

public class CurrencyRates {
    private String table;
    private Rate rates;
    private Date lastupdate;

    static final class Rate {
        private double DKK;
        private double EUR;
        private double USD;

        @Override
        public String toString() {
            return "DKK: " + DKK + ", " +
                    "EUR: " + EUR + ", " +
                    "USD: " + USD;
        }
    }

    public double getDKK() {
        return rates.DKK;
    }

    public double getEUR() {
        return rates.EUR;
    }

    public double getUSD() {
        return rates.USD;
    }

    @Override
    public String toString() {
        return "Valutakurser hentet fra CDN skyen {" +
                "table: '" + table + '\'' +
                ", rates: {" + rates + '}' +
                ", lastupdate: " + lastupdate +
                '}';
    }
}
