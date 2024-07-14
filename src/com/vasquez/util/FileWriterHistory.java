package com.vasquez.util;

import com.google.gson.*;
import com.vasquez.model.Converter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */
public class FileWriterHistory {

    public void save(List<Converter> converter) {
        // Se crea una instancia GSON
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .setPrettyPrinting()
                .create();

        // Control de excepciones
        try {
            FileWriter fileWriter = new FileWriter("historial.json");
            gson.toJson(converter, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
