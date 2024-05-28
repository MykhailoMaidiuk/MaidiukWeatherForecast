package com.sp.weather.controller;

import com.sp.weather.dtos.WeatherDTO;
import com.sp.weather.entity.Users;
import com.sp.weather.service.WeatherService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@Validated
@Transactional(readOnly = true)
@Tag(
        name =  "Weather Setup" ,
        description = "It Include APIs related to configure Weather"
)
@CrossOrigin(origins = "/*", maxAge = 3600, allowCredentials="true")
public class WeatherController {

    @Autowired
    WeatherService service;

    @GetMapping("/get-card")
    @Parameter(
            in = ParameterIn.QUERY,
            required = true,
            name = "card",
            schema = @Schema(implementation = String.class),
            example = "1",
            description = "An identifier for User in the system."
    )
    public Users getCardInfo(
            @RequestParam(value = "card")
            String card
    ) {
        return this.service.getCardInfo(card);
    }

    @Transactional
    @PostMapping("/add-card")
    public Users saveCard(
            @RequestBody
            @Validated
            Users insertDTO
    ) {
        return this.service.saveCard(insertDTO);
    }



  /*  @GetMapping("/get-weather")
    @Parameter(
            in = ParameterIn.QUERY,
            required = true,
            name = "city",
            schema = @Schema(implementation = String.class),
            example = "1",
            description = "An identifier for User in the system."
    )
    public List<WeatherDTO> getWeatherInfo(
            @RequestParam(value = "city")
            String city
    ) {
        return this.service.getWeatherInfo(city);
    }*/
}
