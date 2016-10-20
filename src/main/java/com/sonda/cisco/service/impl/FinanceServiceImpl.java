package com.sonda.cisco.service.impl;

import com.sonda.cisco.service.FinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.fx.FxSymbols;

import java.io.IOException;

/**
 * Created by JanCarlo on 16/06/2016.
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public String getFinance(String moneda){

        FxQuote tipocambio = null;
        FxQuote usdmxn = null;
        try {
            tipocambio = YahooFinance.getFx(moneda);
        } catch (IOException e) {
            log.error(e.toString());

        }
        return tipocambio.toString();

    }

}
