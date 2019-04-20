package rasw.learning.rate.impl;

import rasw.learning.rate.api.QuoteManager;
import rasw.learning.rate.spi.ExchangeRateProvider;

public class YahooFinanceExchangeRateProvider  implements ExchangeRateProvider {

    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }
}
