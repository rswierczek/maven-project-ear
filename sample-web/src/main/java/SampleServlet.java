import rasw.learning.rate.api.Quote;
import rasw.learning.rate.api.QuoteManager;
import rasw.learning.rate.spi.ExchangeRateProvider;

import javax.inject.Inject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import java.util.ServiceLoader;

@WebServlet(value = "sample", name = "hello-sample")
public class SampleServlet extends GenericServlet {

    //@Inject
    private ExampleService exampleService = new ExampleService();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
      //  servletResponse.getWriter().append(exampleService.sayHello());

        servletResponse.getWriter().append(exampleService.getQuotes().toString());

        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader
                .load(ExchangeRateProvider.class);
        if (loader.iterator().hasNext()){
            ExchangeRateProvider exchangeRateProvider = loader.iterator().next();
            QuoteManager quoteManager = exchangeRateProvider.create();
            List<Quote> quotes = quoteManager.getQuotes(null, null);

        }


    }
}
