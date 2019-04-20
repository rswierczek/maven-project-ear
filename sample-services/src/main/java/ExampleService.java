import rasw.learning.rate.api.Quote;
import rasw.learning.rate.api.QuoteManager;
import rasw.learning.rate.spi.ExchangeRateProvider;

import javax.ejb.Stateless;
import java.util.List;
import java.util.ServiceLoader;

@Stateless
public class ExampleService {
    public String sayHello(){
        return "Hello";
    }

    public List<Quote> getQuotes(){
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader
                .load(ExchangeRateProvider.class);
        if (loader.iterator().hasNext()){
            ExchangeRateProvider exchangeRateProvider = loader.iterator().next();
            QuoteManager quoteManager = exchangeRateProvider.create();
            return quoteManager.getQuotes(null, null);
        }
        return null;
    }
}
