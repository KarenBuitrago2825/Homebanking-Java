package com.mindhub.homebankingUno.services.implement;

import com.mindhub.homebankingUno.models.Card;
import com.mindhub.homebankingUno.repositories.CardRepository;
import com.mindhub.homebankingUno.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImplement implements CardService {

	@Autowired
	private CardRepository cardRepository;

	@Override
	public void saveCard(Card card) {
		cardRepository.save(card);
	}

	@Override
	public Boolean existByNumber(String cardNumber) {
		return cardRepository.existsByNumber(cardNumber);
	}


	/*Preguntar*/
	@Override
	public Card findByNumber(String cardNumber) {
		return cardRepository.findByNumber(cardNumber);
	}
}
