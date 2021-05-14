(ns customer-credit-card.logic
  (:use clojure.pprint)
  (:require [customer-credit-card.db :as c.db]))

(defn total-amount-by-category
  [[category amounts]]
  {:category category
   :total (reduce + (map :amount amounts))} )

(defn map-amount-by-categories
  [purchases]
  (->> purchases
       (group-by :category)
       (map total-amount-by-category)))

(defn map-total-amount
  [purchases]
  (->> purchases
       (map :amount)
       (reduce +)))

(defn map-transactions
  [[client-id transactions]]
  (let [purchases (map :purchase transactions)]
    {:customer  client-id
     :purchases purchases
     :amount-by-category (map-amount-by-categories purchases)
     :total-spent (map-total-amount purchases)}))

(defn group-transactions-by-client
  [transactions]
  (group-by :client-id transactions))

(defn get-resume
  [transactions]
  (->> transactions
       group-transactions-by-client
       (map map-transactions)))

(->> (c.db/transactions)
     (get-resume)
     pprint)
