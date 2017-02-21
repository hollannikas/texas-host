(ns texas-host.core-test
  (:use [midje.sweet :refer :all])
  (:require [texas-host.core :refer :all]))

(fact "`remove-card` removes a card from the pack"
      (count (remove-card 1 [1 2 3 4])) => 3
      (some #{1} (remove-card 1 [1 2 3 4])) => falsey)

(fact "`suit` finds the suite of the card"
      (fact "0-12 are Hearts"
            (map suit (range 0 13)) => (repeat 13 "H"))
      (fact "13-25 are Spades"
            (map suit (range 13 26)) => (repeat 13 "S"))
      (fact "26-38 are Clubs"
            (map suit (range 26 39)) => (repeat 13 "C"))
      (fact "39-51 are Diamonds"
            (map suit (range 39 52)) => (repeat 13 "D"))
      (fact "52-61 are invalid"
            (map suit (range 52 62)) => (repeat 10 "X"))
      )

(fact "`value` finds the value of the card"
      )



(fact "'deal-cards' deals number of cards wanted and removes them from the deck"
      (let [deck-before (into [] (range 13))]
      (let [[cards-dealt deck-after] (deal-cards 3 deck-before)]
            (count cards-dealt) => 3
            (count deck-after) => 10
        )))

