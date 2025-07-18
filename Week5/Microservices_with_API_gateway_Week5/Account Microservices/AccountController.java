package com.cognizant.account.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public ResponseEntity<Map<String, Object>> getAccount(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", "00987987973432");
        response.put("type", "savings");
        response.put("balance", 234343);
        return ResponseEntity.ok(response);
    }
}
