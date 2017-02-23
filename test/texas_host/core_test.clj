(ns texas-host.core-test
  (:use [midje.sweet :refer :all])
  (:require [texas-host.core :refer :all]))

(fact "`remove-item` removes a card from the pack"
      (count (remove-item 1 [1 2 3 4])) => 3
      (some #{1} (remove-item 1 [1 2 3 4])) => falsey)

(fact "`get-card` gets a card from the pack"
      (let [[card deck] (get-card [1 2 3 4])]
        (count deck) => 3
        (some #{card} deck) => falsey))


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
      (fact "0, 13, 26, 39 are Aces"
            (map value [0 13 26 39]) => (repeat 4 0))
      (fact "1, 14, 27, 40 are Deuces"
            (map value [1 14 27 40]) => (repeat 4 1))
      (fact "2, 15, 28, 41 are Threes"
            (map value [2 15 28 41]) => (repeat 4 2))
      (fact "3, 16, 29, 42 are Fours"
            (map value [3 16 29 42]) => (repeat 4 3))
      (fact "4, 17, 30, 43 are Fives"
            (map value [4 17 30 43]) => (repeat 4 4))
      (fact "5, 18, 31, 44 are Sixes"
            (map value [5 18 31 44]) => (repeat 4 5))
      (fact "6, 19, 32, 45 are Sevens"
            (map value [6 19 32 45]) => (repeat 4 6))
      (fact "7, 20, 33, 46 are Eights"
            (map value [7 20 33 46]) => (repeat 4 7))
      (fact "8, 21, 34, 47 are Nines"
            (map value [8 21 34 47]) => (repeat 4 8))
      (fact "9, 22, 35, 48 are Tens"
            (map value [9 22 35 48]) => (repeat 4 9))
      (fact "10, 23, 36, 49 are Jacks"
            (map value [10 23 36 49]) => (repeat 4 10))
      (fact "11, 24, 37, 50 are Queens"
            (map value [11 24 37 50]) => (repeat 4 11))
      (fact "12, 25, 38, 51 are Kings"
            (map value [12 25 38 51]) => (repeat 4 12))
      (fact "number 52 or above is invalid"
            (map value [52 60 65]) => (repeat 3 -100))
      )

(fact "'deal-cards' deals number of cards wanted and removes them from the deck"
      (let [deck-before (into [] (range 13))]
      (let [[cards-dealt deck-after] (deal-cards 3 deck-before)]
            (count cards-dealt) => 3
            (count deck-after) => 10
        )))


(fact "'deal' deals two cards to all players"
      (let [[hands pack] (deal (apply str (range 0 10)))]
          (count pack) => 32
          (count hands) => 10
          (doseq [[idx hand] (map-indexed vector hands)]
              (let [[player cards] (split-at 1 (flatten hand))]
                  (first player) => str idx
                  (count cards) => 2
                  nil => (some (partial = (first cards)) pack)
                  nil => (some (partial = (second cards)) pack)
        ))))



