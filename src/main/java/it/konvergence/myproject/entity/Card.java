package it.konvergence.myproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
