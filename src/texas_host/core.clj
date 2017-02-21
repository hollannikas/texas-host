(ns texas-host.core
  (:gen-class))

(defn remove-card [card deck]
  (remove
    (fn [x] (= x card))
    deck))

(defn choose-card [deck]
  [(rand-nth deck)])

(defn deal-cards [amount deck]
  (cond
    (= amount 0) [[] deck]
    :else
    (let [[cards-before deck-before] (deal-cards (- amount 1) deck)]
      (let [card-chosen (choose-card deck-before)]
      (let [deck-after (remove-card card-chosen deck-before)]
        (println "deck-after " card-chosen deck-after)
        [(conj cards-before card-chosen) deck-after])))))

(defn deal-hand [player]
  (let [deck (into [] (range 52))]
  (deal-cards 2 deck)))

(defn suit [card]
  "Gets the suit of a card based on its number in the pack, ordered [H S C D]"
  (cond
    (<= card 12) "H"
    (<= card 25) "S"
    (<= card 38) "C"
    (<= card 51) "D"
    :else "X"
    ))

(defn value [card]
  "Gets the value of a card based on its number in the pack, Ten = T, Ace = A, Jack = J, Queen = Q and King = K"
  :-)


(defn translate-card [card]
  (str (suit card) (value card)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "John got the following cards " (deal-hand "bert"))))
