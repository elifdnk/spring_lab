package com.cydeo.lab08rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class CurrencyApiResponse {

    private Map<String, BigDecimal> quotes;

}