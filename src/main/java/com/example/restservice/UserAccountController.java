package com.example.restservice;

import java.util.UUID;

import com.example.restservice.model.ErrorResponse;
import com.example.restservice.model.GeoLocationData;
import com.example.restservice.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserAccountController {

    private final String WELCOME_MSG_TEMPLATE = " Welcome %s from %s ! \n Your Unique Id: %s";
    private final String ERRPR_MSG_TEMPLATE = " User outside Canada are not allowed to register.";
    private final String CANADA = "Canada";


    @Autowired
    UserAccountService userAccountService;


    @PostMapping("/register")
    public ResponseEntity<String> userLogin(@Valid @RequestBody UserData userData) {
        GeoLocationData geoLocationData = userAccountService.getGeoLocation(userData.getIpAddress());
        if (!geoLocationData.getCountry().equalsIgnoreCase(CANADA)) {
            return ResponseEntity.ok().body(ERRPR_MSG_TEMPLATE);
        }
        UUID uuid = UUID.randomUUID();
        return ResponseEntity.ok(String.format(WELCOME_MSG_TEMPLATE, userData.getUsername(), geoLocationData.getCity(), uuid));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {
        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());
        return ErrorResponse.builder().message(errorMsg).build();
    }

}
