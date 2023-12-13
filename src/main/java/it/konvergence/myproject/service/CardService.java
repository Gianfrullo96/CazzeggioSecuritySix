package it.konvergence.myproject.service;

import it.konvergence.myproject.entity.Card;
import it.konvergence.myproject.repo.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card saveCard(@NotNull("card was NUll") Card card) {
        log.info("Salvo la carta", card);
        return cardRepository.save(card);
    }

    public List<Card> findAllCards() {
        log.info("trovo tutte le carte");
       return  cardRepository.findAll();
    }
}
