(ns texas-host.core
  (:gen-class))

(defn remove-card [card pack]
  (remove
    (fn [x] (= x card))
    pack))

(defn get-card [pack]
  ( let [card (rand-nth pack)]
  [card (remove-card card pack)]))

(defn deal-cards [amount pack]
  (cond
    (= amount 0) [[] pack]
    :else
    (let [[cards-before pack-before] (deal-cards (- amount 1) pack)]
      (let [[card-chosen pack-after] (get-card pack-before)]
         [(conj cards-before card-chosen) pack-after]))))

(defn deal-hand [player]
  (let [pack (into [] (range 52))]
  (deal-cards 2 pack)))

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
  :-)


(defn translate-card [card]
  (str (suit card) (value card)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "John got the following cards " (deal-hand "john"))))
