/*
A simple class for a poker hand
Keeps track of the number of cards you have in your hands
2 methods: draw cards and play cards.
 */

package pokerhand

class poker_hand(num_card: Int = 5){ // originally 5 cards

  var cards: Int = num_card // init cards attribute (counter)

  def draw(n: Int): Unit = { // draw n cards
    cards += n
  }

  def play(n: Int): Unit = { // play n cards
    cards -= n
  }

  // override the print method for the class (__str__() in python)
  override def toString: String = s"you currently have a poker hand with $cards cards."

}

