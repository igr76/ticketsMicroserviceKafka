package com.example.stmlabs.controller;

import com.example.stmlabs.dto.CarrierDto;
import com.example.stmlabs.dto.TicketDto;
import com.example.stmlabs.dto.UserDto;
import com.example.stmlabs.service.CarrierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/carrier")
@Slf4j
@RequiredArgsConstructor
@RestController
public class CarrierController {
    private CarrierService carrierService;
    @Operation(summary = "Создать перевозчика")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping()
    public ResponseEntity<CarrierDto> greaetCarrier(
            @RequestBody
            @NotBlank(message = "перевозчика не должен быть пустым") CarrierDto carrierDto, Authentication authentication) {
        log.info("controller создать перевозчика");
        return ResponseEntity.ok(carrierService.greateCarrier(carrierDto, authentication));
    }
    @Operation(summary = "Обновить перевозчика")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping()
    public ResponseEntity<CarrierDto> updateCarrier(
            @RequestBody
            @NotBlank(message = "перевозчик не должен быть пустым") CarrierDto carrierDto, Authentication authentication) {
        log.info("controller Обновить перевозчика");
        return ResponseEntity.ok(carrierService.updateCarrier(carrierDto, authentication));
    }
    @Operation(summary = "Удалить перевозчика")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCarrier(@PathVariable(name = "id")
                             @NotBlank(message = "id не должен быть пустым") int id,
                             Authentication authentication) {
        log.info("controller Удалить перевозчика");
        carrierService.deleteCarrier(id);
    }
}
