(ns texas-host.core-test
  (:use [midje.sweet :refer :all])
  (:require [texas-host.core :refer :all]))

(fact "`remove-card` removes a card from the pack"
      (count (remove-card 1 [1 2 3 4])) => 3
      (some #{1} (remove-card 1 [1 2 3 4])) => falsey)
