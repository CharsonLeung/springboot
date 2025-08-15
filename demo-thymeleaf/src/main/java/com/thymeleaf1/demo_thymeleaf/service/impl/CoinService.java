package com.thymeleaf1.demo_thymeleaf.service.impl;

import java.util.List;
import com.thymeleaf1.demo_thymeleaf.model.CoinDTO;

public interface CoinService {
  List<CoinDTO> getCoins();
}