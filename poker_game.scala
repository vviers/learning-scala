/*
The poker_game object
to "play" a game of poker (actually, draw and play cards and keep track
of how many cards you have in hand...)
 */

package pokergame

import pokerhand.poker_hand

// create a poker game object that extend from App (no need for main() )
object poker_game extends App {

  // init new instance of the poker hand object
  val myHand = new poker_hand()

  // init increment of
  var increment: Int = 0
  // init draw / play
  var drawPlay: Char = 'p'

  while (true) {
    println("\n" + myHand + "\n")

    print("Would you like to draw ('d') or play ('p') some cards? d/p: ")
    drawPlay = scala.io.StdIn.readChar()

    if (drawPlay != 'd' && drawPlay != 'p') {
      println("Sorry, I didn't get this...")
    }

    print("How many cards? (could be a neg. number): ")
    increment = scala.io.StdIn.readInt()

    if (drawPlay == 'd') {

      myHand.draw(increment)

    } else myHand.play(increment)

  }

}