package com.jaya.challenge.api.currency.converter.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaya.challenge.api.currency.converter.commons.Currency;
import com.jaya.challenge.api.currency.converter.model.dto.ConversionDTO;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;
import com.jaya.challenge.api.currency.converter.service.ConversionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void mustConvertBRLToJPY() throws Exception {
        User user = userRepository.save(new User("teste1", "teste1"));
        ConversionRequest conversionRequest = new ConversionRequest(Currency.BRL, new BigDecimal(80), Currency.JPY);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/currency-converter")
                .param("idUser", user.getIdUser().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(conversionRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotConvertCurrencyUnregisteredUser() throws Exception {
        ConversionRequest conversionRequest = new ConversionRequest(Currency.BRL, new BigDecimal(80), Currency.JPY);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/currency-converter")
                .param("idUser", "2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(conversionRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User not found"));

    }

    @Test
    public void mustConvertUSDToEUR() throws Exception {
        User user = userRepository.save(new User("teste2","teste2"));
        ConversionRequest conversionRequest = new ConversionRequest(Currency.USD, new BigDecimal(80), Currency.EUR);
        ConversionDTO conversionDTO = conversionService.convertCurrency(user.getIdUser(), conversionRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/currency-converter")
                .param("idUser",user.getIdUser().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(conversionRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idUser").value(conversionDTO.getIdUser()))
                .andExpect(jsonPath("$.sourceCurrency").value(conversionDTO.getSourceCurrency().toString()))
                .andExpect(jsonPath("$.sourceValue").value(conversionDTO.getSourceValue()))
                .andExpect(jsonPath("$.destinationCurrency").value(conversionDTO.getDestinationCurrency().toString()))
                .andExpect(jsonPath("$.destinationValue").value(conversionDTO.getDestinationValue()))
                .andExpect(jsonPath("$.conversionRate").value(conversionDTO.getConversionRate()));
        assertTrue(userRepository.existsById(1L));
        assertEquals(2,transactionRepository.transactionsByUser(user).size());
    }


}
