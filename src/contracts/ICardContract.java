package contracts;

import models.Card;

import java.util.List;

public interface ICardContract {

    List<Card> generateCards(List<String> randomWords);

}
