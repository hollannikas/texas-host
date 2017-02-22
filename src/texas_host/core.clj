(ns texas-host.core
  (:gen-class))

(defn remove-card [card pack]
  (remove
    (fn [x] (= x card))
    pack))

(defn get-card [pack]
  ( let [card (rand-nth pack)]
  [card (remove-card card pack)]))

(defn get-cards [amount cards pack]
  (cond
    (= amount 0) [cards pack]
    :else (let [[new-card new-pack] (get-card pack)]
                   (get-cards (- amount 1) (conj cards new-card) new-pack))))

(defn deal-cards [amount pack]
  (get-cards amount [] pack))

(defn deal-hand [players pack]
    (for [player players :let [[cards pack] (deal-cards 2 pack)]]
        (vector player cards pack)))

(defn deal-hands [players]
  (let [pack (into [] (range 52))]
      (deal-hand players pack)))

(defn suit [card]
  "Gets the suit of a card based on its number in the pack, ordered [H S C D]"
  (cond
    (< card 13) "H"
    (< card 26) "S"
    (< card 39) "C"
    (< card 52) "D"
    :else "X"
    ))

(defn value [card]
  "Gets the value of a card based on its number in the pack, Ten = T, Ace = A, Jack = J, Queen = Q and King = K"
  (cond
    (< card 52) (mod card 13)
    :else -100
    ))


(defn translate-card [card]
  (str (suit card) (value card)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (println (str "Players got the following hands " (apply str(deal-hands ["john" "bob" "edgar"])))))
