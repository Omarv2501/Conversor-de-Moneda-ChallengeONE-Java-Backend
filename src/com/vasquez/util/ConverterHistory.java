package com.vasquez.util;

import com.vasquez.model.Converter;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */
public class ConverterHistory {
    @Getter
    private List<Converter> converterList = new ArrayList<>();
    private DateTimeFormatter formatter;
    private FileWriterHistory convertirArchivo;

    public ConverterHistory() {
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.convertirArchivo = new FileWriterHistory();
    }

    public void addConverter(Converter converter) {
        converterList.add(converter);
    }

    public void showHistory() {
        System.out.println(" ---- ** Conversiones realizadas ** ---- \n");

        for (Converter moneda : converterList ) {
            System.out.println("Valor: " + moneda.getAmount() + " \tDesde: " + moneda.getCurrencyCodeFrom() +
                    "\ta: " + moneda.getCurrencyCodeTo() + " ===> \t" + moneda.getCurrencyCodeTo()
                    + "  \t Fecha y hora de conversion: " + moneda.getDateTime().format(formatter));

        }
    }

}
