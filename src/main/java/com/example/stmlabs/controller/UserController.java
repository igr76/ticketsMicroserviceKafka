package com.example.stmlabs.controller;

import com.example.stmlabs.dto.UserDto;
import com.example.stmlabs.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/users")
@Slf4j
@RestController
public class UserController {


  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  @Operation(summary = "Получить пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
  })
  @PreAuthorize("hasAuthority('ADMIN')"+"'login==authentication.name'")
  @GetMapping(value = "/{login}}")
  public ResponseEntity<UserDto> getUser(@PathVariable(name = "login")
                                           @NotBlank(message = "ad_pk не должен быть пустым") String login,
                                         Authentication authentication) {
    log.info("");
    return ResponseEntity.ok(userService.getUser(login,authentication));
  }

  @Operation(summary = "Обновить пользователя")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK", content = @Content(
              array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
      @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
  })
  @PatchMapping(value = "/me")
  public ResponseEntity<UserDto> updateUser(
          @RequestBody
      @NotBlank(message = "updateUser не должен быть пустым") UserDto userDto, Authentication authentication) {
    log.info("controller Обновить пользователя");
    return ResponseEntity.ok(userService.updateUser(userDto, authentication));
  }
    @Operation(summary = "Обновить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable(name = "login")
                               @NotBlank(message = "ad_pk не должен быть пустым") String login,
                           Authentication authentication) {
        log.info("controller Обновить пользователя");
         userService.deleteUser(login, authentication);
    }




}