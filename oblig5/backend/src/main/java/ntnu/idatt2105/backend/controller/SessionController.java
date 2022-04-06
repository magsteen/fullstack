package ntnu.idatt2105.backend.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ntnu.idatt2105.backend.model.UserCredentials;
import ntnu.idatt2105.backend.model.jpa.Session;
import ntnu.idatt2105.backend.service.SessionService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value = "/session")
@EnableAutoConfiguration
public class SessionController {
    @Autowired
    private SessionService service;

    @Operation(summary = "Creates a new session for a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created session", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Session.class)) }),
            @ApiResponse(responseCode = "401", description = "Invalid credentials", content = @Content)
    })
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Session create(@RequestBody UserCredentials credentials) {
        return this.service.create(credentials);
    }

    @Operation(summary = "Deletes a session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted session"),
            @ApiResponse(responseCode = "404", description = "Session was not found")
    })
    @DeleteMapping(value = "{token}")
    public void delete(@PathVariable String token) {
        this.service.delete(Base64.getDecoder().decode(token));
    }
}
