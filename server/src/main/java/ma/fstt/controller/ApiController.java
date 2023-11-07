package ma.fstt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api")
public class ApiController {
  @GetMapping
  @ResponseBody
  public String hello() {
    return "hello";
  }

}
