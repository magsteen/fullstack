package ntnu.idatt2105.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ntnu.idatt2105.backend.model.UserCredentials;
import ntnu.idatt2105.backend.model.jpa.User;
import ntnu.idatt2105.backend.service.UserService;

@RestController
@RequestMapping(value = "/user")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Creates a new session for a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "401", description = "Invalid credentials", content = @Content)
    })
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody UserCredentials credentials) {
        return this.service.create(credentials);
    }
}
