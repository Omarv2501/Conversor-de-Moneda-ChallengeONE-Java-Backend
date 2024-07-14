package com.vasquez.model;

import com.vasquez.api.ExchangeRateAPI;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */

@Data
public class Converter {
    double amount;
    String currencyCodeFrom;
    String currencyCodeTo;
    double conversionResult;
    LocalDateTime dateTime;
    private ExchangeRateAPI apiConnection;


    public Converter(MonedaAPI monedaAPI) {
        this.currencyCodeFrom = monedaAPI.base_code();
        this.currencyCodeTo = monedaAPI.target_code();
        this.conversionResult = monedaAPI.conversion_result();
        this.amount = getAmount();
        this.dateTime = getDateTime();

    }

    public Converter() {
        this.apiConnection = new ExchangeRateAPI();
    }

    public Converter convert(String from, String to, double amount) {
        Converter miConvertidor = null;
        if (from.length() < 4 && to.length() < 4) {
            MonedaAPI monedaAPI = apiConnection.ApiResponse(from, to, amount);
            miConvertidor = new Converter(monedaAPI);
            miConvertidor.setAmount(amount);
            System.out.println(showConverter(miConvertidor));

        } else {
            System.out.println("Error: codigo de moneda es incorrecto");

        }
        return miConvertidor;

    }

    private String showConverter(Converter converter) {
        return " El valor de " + converter.amount + " [" + converter.currencyCodeFrom + "] " + " corresponde al valor final ===> " +
                converter.conversionResult + " [" + converter.currencyCodeTo + "]";
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "Conversion {" +
                "valor=" + amount +
                ", de ='" + currencyCodeFrom + '\'' +
                ", a ='" + currencyCodeTo + '\'' +
                ", total ='" + conversionResult + '\'' +
                ", fecha ='" + dateTime + '\'' +
                '}';

    }
}
