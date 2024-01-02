package it.konvergence.myproject.repo;

import it.konvergence.myproject.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 12/13/23
 */
public interface CardRepository extends JpaRepository<Card,Long> {
}

