package com.thymeleaf1.demo_thymeleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.thymeleaf1.demo_thymeleaf.model.CoinDTO;
import com.thymeleaf1.demo_thymeleaf.service.impl.CoinService;


@Controller
public class CoinPage {
  @Autowired
  private CoinService coinService;

  @GetMapping("/coinpage")
  public String getCoinPage(Model model) {
      List<CoinDTO> coinDTOs = this.coinService.getCoins();
      model.addAttribute("coins", coinDTOs);
      return "coinpage";
  }
  
}
