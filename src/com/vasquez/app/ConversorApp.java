package com.vasquez.app;

import com.vasquez.model.Converter;
import com.vasquez.util.FileWriterHistory;
import com.vasquez.util.ConverterHistory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {

        FileWriterHistory fileWriterHistory = new FileWriterHistory();
        Converter converter = new Converter();
        ConverterHistory converterHistory = new ConverterHistory();

        Scanner sc = new Scanner(System.in);

        String monedas = """

                *********************************************************************                
                     Sea Bienvenido/a al CONVERSOR DE MONEDAS =]
                     -------------------------------------------
              
                 1. USD - Dólar estadounidense ==> ARS - Peso argentino
                 2. ARS - Peso argentino       ==> USD - Dólar estadounidense
                 3. USD - Dólar estadounidense ==> BRL - Real brasileño
                 4. BRL - Real brasileño       ==> USD - Dólar estadounidense
                 5. USD - Dólar estadounidense ==> MXN - Peso Mexicano
                 6. MXN - Peso Mexicano        ==> USD - Dólar estadounidense
                 7. [[ *** VER HISTORIAL DE CONVERSIONES *** ]]
                 8. Salir
                 Elija una opción valida:
                                            [--- Developed By Jhonatan Vasquez ---]                 
                *********************************************************************
                """;


        int opcion = 0;

        do {
            Double valor = null;
            Converter conversion;
            try {
                System.out.println(monedas);
                opcion = sc.nextInt();
                if (opcion != 7 && opcion != 8) {
                    System.out.println("Ingres el valor que desea convertir");
                    valor = sc.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Seleccione una opción valida.");
                sc.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("USD", "ARS", valor);
                    converterHistory.addConverter(conversion);
                    break;
                case 2:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("ARS", "USD", valor);
                    converterHistory.addConverter(conversion);
                    break;
                case 3:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("USD", "BRL", valor);
                    converterHistory.addConverter(conversion);
                    break;

                case 4:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("BRL", "USD", valor);
                    converterHistory.addConverter(conversion);
                    break;
                case 5:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("USD", "MXN", valor);
                    converterHistory.addConverter(conversion);
                    break;
                case 6:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.convert("MXN", "USD", valor);
                    converterHistory.addConverter(conversion);
                    break;
                case 7:
                    converterHistory.showHistory();
                    fileWriterHistory.save(converterHistory.getConverterList());
                    break;
                case 8:
                    System.out.println(" **  Regresando al menu principal ** ");
                    break;

                default:
                    break;

            }
        } while (opcion != 8);
        sc.close();
    }
}

