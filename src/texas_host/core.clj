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
    (= amount 0) [cards]
    :else (let [[new-card new-pack] (get-card pack)]
                   (get-cards (- amount 1) (conj cards new-card) new-pack))))

(defn deal-cards [amount pack]
  (get-cards amount [] pack))

(defn deal-hand [player]
  (let [pack (into [] (range 52))]
  (deal-cards 2 pack)))

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
  (str (suite card) (value card)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "John got the following cards " (deal-hand "john"))))
