package com.thymeleaf1.demo_thymeleaf.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.thymeleaf1.demo_thymeleaf.model.CoinDTO;
import com.thymeleaf1.demo_thymeleaf.service.impl.CoinService;

@Service
public class CoinServiceImpl implements CoinService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinDTO> getCoins(){
    String url = 
        "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    return Arrays.asList(this.restTemplate.getForObject(url, CoinDTO[].class));
  }
}