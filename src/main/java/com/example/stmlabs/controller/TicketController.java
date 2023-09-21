package com.example.stmlabs.controller;

import com.example.stmlabs.dto.TicketDto;
import com.example.stmlabs.dto.UserDto;
import com.example.stmlabs.model.Ticket;
import com.example.stmlabs.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RequestMapping("/ticket")
@Slf4j
@RestController
public class TicketController {
    private TicketService ticketService;

    @Operation(summary = "Создать Билет")
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
    public ResponseEntity<TicketDto> greaetTicket(
            @RequestBody
            @NotBlank(message = "Билет не должен быть пустым") TicketDto ticketDto, Authentication authentication) {
        log.info("controller создать Билет");
        return ResponseEntity.ok(ticketService.greatTicket(ticketDto, authentication));
    }
    @Operation(summary = "Обновить Билет")
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
    public ResponseEntity<TicketDto> updateTicket(
            @RequestBody
            @NotBlank(message = "Билет не должен быть пустым") TicketDto ticketDto, Authentication authentication) {
        log.info("controller Обновить Билет");
        return ResponseEntity.ok(ticketService.updateTicket(ticketDto, authentication));
    }
    @Operation(summary = "Удалить Билет")
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
    public void deleteTicket(@PathVariable(name = "id")
                           @NotBlank(message = "логин не должен быть пустым") int id,
                           Authentication authentication) {
        log.info("controller Удалить Билет");
        ticketService.deleteTicket(id);
    }
    @Operation(summary = "Получить все доступные билеты")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{dateTime/{point}/{nameCarrier}")
    public ResponseEntity<Collection<Ticket>> getAllTicket(
            @RequestParam
             LocalDateTime dateTime,
            @RequestParam String point,@RequestParam String nameCarrier) {
        log.info("controller Получить все доступные билеты");
        return ResponseEntity.ok(ticketService.getAllTicket( dateTime,
                point, nameCarrier));
    }
    @Operation(summary = "Получить все билеты пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{dateTime/{point}/{nameCarrier}")
    public ResponseEntity<Collection<Ticket>> getAllMyPurchaseTicket(
            @RequestParam
            String login) {
        log.info("controller Получить все билеты пользователя");
        return ResponseEntity.ok(ticketService.getAllMyPurchaseTicket(login));
    }
}
