package rasw.learning.rate.impl;

import rasw.learning.rate.api.Quote;
import rasw.learning.rate.api.QuoteManager;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class YahooQuoteManagerImpl implements QuoteManager {

    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        // fetch from Yahoo API
        return Collections.emptyList();
    }
}
