package com.cydeo.client;

import com.cydeo.dto.CurrencyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.currencylayer.com", name = "CURRENCY-CLIENT")
public interface CurrencyClient {

    @GetMapping("/live")
    ResponseEntity<CurrencyApiResponse> consumeCurrencyApi(@RequestParam("access_key") String access_key,
                                                          @RequestParam("currencies") String currencies);

}
