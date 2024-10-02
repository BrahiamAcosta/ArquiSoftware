package com.udea.cicdapplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.udea.cicdapplication.controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CicdApplicationTests {

    @Autowired
    DataController dataController;

    @Test
    public void health(){
        assertEquals("HEALTH CHECK OK",dataController.healtCheck());
    }

    @Test
    public void version(){
        assertEquals("THE ACTUAL VERSION IS 1.0.0", dataController.version());
    }

    @Test
    public void nationsLength(){
        Integer nationsLength = dataController.getRandomNations().size();
        assertEquals(10,nationsLength);
    }

    @Test
    public void currenciesLength(){
        Integer currenciesLength = dataController.getRandomCurrencies().size();
        assertEquals(20,currenciesLength);
    }

    @Test
    public void aviationLength(){
        Integer aviationLength = dataController.getRandomAviation().size();
        assertEquals(20,aviationLength);
    }

    @Test
    public void testRandomCurrenciesCodeFormat(){
        JsonNode response = dataController.getRandomCurrencies();
        for(int i=0;i<response.size();i++){
            JsonNode currency = response.get(i);
            String code = currency.get("code").asText();
            assertTrue(code.matches("[A-Z]{3}"));
        }
    }

    @Test
    public void testRandomNationsPerformance(){
        long startTime = System.currentTimeMillis();
        dataController.getRandomNations();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime-startTime;
        System.out.println(executionTime);
        assertTrue(executionTime<2000);
    }

}
