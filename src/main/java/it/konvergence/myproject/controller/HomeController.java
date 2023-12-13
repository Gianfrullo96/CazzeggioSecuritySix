package it.konvergence.myproject.controller;

import it.konvergence.myproject.domain.CustomValidationException;
import it.konvergence.myproject.entity.Card;
import it.konvergence.myproject.entity.User;
import it.konvergence.myproject.request.UserDto;
import it.konvergence.myproject.service.CardService;
import it.konvergence.myproject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */

@RestController
@RequiredArgsConstructor
public class HomeController {


    private final CardService cardService;

    private final UserService userService;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/save")
    public ResponseEntity<Card> saveCard(@Valid @RequestBody Card card) {
        Card savedCard = cardService.saveCard(card);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCard);
    }

    @GetMapping("/cards")
    public List<Card> findAllCard() {
        return cardService.findAllCards();
    }

    @PostMapping("/saveUser")
    public User registration(@Valid @RequestBody UserDto userDto,
                             BindingResult result
    ) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            throw new CustomValidationException("cazzato qualcosa");
        }

        return userService.saveUser(userDto);

    }

    @GetMapping("/users")
    public List<UserDto> users() {
        return userService.findAllUsers();
    }


}
