package it.konvergence.myproject.controller;

import it.konvergence.myproject.entity.Card;
import it.konvergence.myproject.repo.CardRepository;
import it.konvergence.myproject.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @PostMapping("/save")
    public ResponseEntity<Card> saveCard(@Valid @RequestBody Card card){
       Card savedCard = cardService.saveCard(card);
       return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCard);
    }
    @GetMapping("/cards")
    public List<Card> findAllCard(){
        return cardService.findAllCards();
    }


}
