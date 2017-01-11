(ns texas-host.core
  (:gen-class))

(defn remove-card [card pack]
  (remove
    (fn [x] (= x card))
    pack))

(defn get-card [pack]
  ( let [card (rand-nth pack)]
  [card (remove-card card pack)]))

;; should return set of cards (size= amount) and a pack without those cards
(defn get-cards [amount pack]
  (get-card pack))


(defn deal-cards [amount pack]
  (get-cards amount pack))

(defn deal-hand [player]
  (let [pack (into [] (range 52))]
  (deal-cards 2 pack)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "hello "(deal-hand "john"))))
