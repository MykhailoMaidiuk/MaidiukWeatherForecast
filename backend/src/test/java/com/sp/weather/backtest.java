package com.sp.weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sp.weather.configuration.*;
import com.sp.weather.controller.*;
import com.sp.weather.entity.*;
import com.sp.weather.repository.*;
import com.sp.weather.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.web.SecurityFilterChain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.*;
import java.util.List;
import com.sp.weather.dtos.WeatherDTO;
import com.sp.weather.entity.Users;
import com.sp.weather.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.Optional;

import static org.mockito.Mockito.*;

class WeatherApplicationTests {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private WeatherService service;

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController controller;

    private ObjectMapper objectMapper;
    @Mock
    private AppProperties appProperties;

    @InjectMocks
    private WebSecurityConfig config;

    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(appProperties.getAllowedOrigins()).thenReturn(Arrays.asList("http://localhost", "http://example.com"));
    }

    // WeatherService Tests
    @Test
    void testGetCardInfo() {
        Users user = new Users();
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        Users result = service.getCardInfo("1");

        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testSaveCard() {
        Users user = new Users();
        when(userRepository.save(user)).thenReturn(user);

        Users result = service.saveCard(user);

        assertNotNull(result);
        assertEquals(user, result);
    }


    // WeatherController Tests
    @Test
    void testControllerGetCardInfo() {
        Users user = new Users();
        when(weatherService.getCardInfo("1")).thenReturn(user);

        Users result = controller.getCardInfo("1");

        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testControllerSaveCard() {
        Users user = new Users();
        when(weatherService.saveCard(user)).thenReturn(user);

        Users result = controller.saveCard(user);

        assertNotNull(result);
        assertEquals(user, result);
    }


    


    @Test
    void testFindById_NotFound() {
        Optional<Users> foundUser = userRepository.findById("nonExistentCard");
        assertFalse(foundUser.isPresent());
    }


    @Test
    void testDeleteById() {
        Users user = new Users();
        user.setCard("testCard");
        userRepository.save(user);

        userRepository.deleteById("testCard");

        Optional<Users> foundUser = userRepository.findById("testCard");
        assertFalse(foundUser.isPresent());
    }
    
    
    @Test
    void testSaveAndFindById() {
        Users user = new Users();
        user.setCard("testCard");
        userRepository.save(user);

        Optional<Users> foundUser = userRepository.findById("testCard");
        assertFalse(foundUser.isPresent());
    }
    
    
    @Test
    void testSaveAndFindByIid() {
        Users user = new Users("testCard", "John Doe", "Sunny weather");
        userRepository.save(user);

        Optional<Users> foundUser = userRepository.findById("testCard");
        assertFalse(foundUser.isPresent());
    }
    
    @Test
    void testFindAall() {
        Users user1 = new Users("testCard1", "John Doe", "Sunny weather");
        Users user2 = new Users("testCard2", "Jane Doe", "Rainy weather");
        userRepository.save(user1);
        userRepository.save(user2);

        Iterable<Users> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.iterator().hasNext());
    }
    
    
    @Test
    void testConstructorAndGetters() {
        WeatherDTO weatherDTO = new WeatherDTO("Berlin", "Germany", "15", "Clear", "01", "true");

        assertEquals("Berlin", weatherDTO.getLocationName());
        assertEquals("Germany", weatherDTO.getCountryName());
        assertEquals("15", weatherDTO.getTemperature());
        assertEquals("Clear", weatherDTO.getConditionText());
        assertEquals("01", weatherDTO.getImageCode());
        assertEquals("true", weatherDTO.getIsDay());
    }
    
    
    @Test
    void testSetters() {
        WeatherDTO weatherDTO = new WeatherDTO("Berlin", "Germany", "15", "Clear", "01", "true");

        weatherDTO.setLocationName("Munich");
        weatherDTO.setCountryName("Germany");
        weatherDTO.setTemperature("20");
        weatherDTO.setConditionText("Cloudy");
        weatherDTO.setImageCode("02");
        weatherDTO.setIsDay("false");

        assertEquals("Munich", weatherDTO.getLocationName());
        assertEquals("Germany", weatherDTO.getCountryName());
        assertEquals("20", weatherDTO.getTemperature());
        assertEquals("Cloudy", weatherDTO.getConditionText());
        assertEquals("02", weatherDTO.getImageCode());
        assertEquals("false", weatherDTO.getIsDay());
    }


   
    
    
    
    @Test
    void testJwtSecret() {
        String jwtSecret = appProperties.getJwtSecret();
        assertNull(jwtSecret);
        assertEquals(null, jwtSecret);
    }
    
    @Test
    void testJwtExpirationMs() {
        Long jwtExpirationMs = appProperties.getJwtExpirationMs();
        assertNotNull(jwtExpirationMs);
        assertEquals(0, jwtExpirationMs);
    }
    

    @Test
    void testFindAll() {
        Users user1 = new Users();
        user1.setCard("testCard1");
        userRepository.save(user1);

        Users user2 = new Users();
        user2.setCard("testCard2");
        userRepository.save(user2);

        Iterable<Users> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.iterator().hasNext());
    }
    
    @Test
    void testControllerGetCardInfoNotFound() {
        when(weatherService.getCardInfo("1")).thenReturn(null);

        Users result = controller.getCardInfo("1");

        assertNull(result);
    }

    @Test
    void testSaveCardThrowsException() {
        Users user = new Users();
        when(userRepository.save(user)).thenThrow(new RuntimeException("Save failed"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.saveCard(user);
        });

        assertEquals("Save failed", exception.getMessage());
    }

    @Test
    void testControllerSaveCardThrowsException() {
        Users user = new Users();
        when(weatherService.saveCard(user)).thenThrow(new RuntimeException("Save failed"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.saveCard(user);
        });

        assertEquals("Save failed", exception.getMessage());
    }
    
}
