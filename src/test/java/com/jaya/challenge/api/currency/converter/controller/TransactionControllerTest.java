package com.jaya.challenge.api.currency.converter.controller;

import static org.junit.Assert.assertEquals;
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

import com.jaya.challenge.api.currency.converter.commons.Currency;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;
import com.jaya.challenge.api.currency.converter.service.ConversionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void mustTransactionsByUser() throws Exception {
        User user = userRepository.save(new User("teste1", "teste1"));
        conversionService.convertCurrency(user.getIdUser(), new ConversionRequest(Currency.JPY, new BigDecimal(40), Currency.USD));
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/transactions-by-user")
                .param("idUser", user.getIdUser().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(1,transactionRepository.transactionsByUser(user).size());
    }

    @Test
    public void mustNotFindTransactionsByUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/transactions-by-user")
                .param("idUser", "2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User not found"));
    }

    @Test
    public void mustFindALL() throws Exception {
        User user = userRepository.save(new User("teste1", "teste1"));
        conversionService.convertCurrency(user.getIdUser(), new ConversionRequest(Currency.JPY, new BigDecimal(40), Currency.USD));
        conversionService.convertCurrency(user.getIdUser(), new ConversionRequest(Currency.BRL, new BigDecimal(40), Currency.EUR));
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/all-transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(2,transactionRepository.transactionsByUser(user).size());
    }


}
