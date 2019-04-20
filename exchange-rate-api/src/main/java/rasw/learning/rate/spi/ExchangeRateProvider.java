package rasw.learning.rate.spi;

import rasw.learning.rate.api.QuoteManager;

public interface ExchangeRateProvider {
    QuoteManager create();
}
