package com.vasquez.model;
/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */
public record MonedaAPI(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {}
