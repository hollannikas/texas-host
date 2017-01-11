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
    (> amount 0) (let [[new-card new-pack] (get-card pack)]
                   (get-cards (- amount 1) (conj cards new-card) new-pack))))

(defn deal-cards [amount pack]
  (get-cards amount [] pack))

(defn deal-hand [player]
  (let [pack (into [] (range 52))]
  (deal-cards 2 pack)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "John got the following cards " (deal-hand "john"))))
