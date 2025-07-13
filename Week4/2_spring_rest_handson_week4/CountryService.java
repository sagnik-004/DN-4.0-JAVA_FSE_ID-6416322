package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {
    public Country getCountry(String code) throws CountryNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) context.getBean("countryList");
        return list.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }
}

