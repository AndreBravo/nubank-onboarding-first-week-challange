(ns customer-credit-card.core
     (:use clojure.pprint)
     (:require [customer-credit-card.db :as c.db]))

(defn total-amount-by-category
     [[category amounts]]
     {:category category
      :total-spent (reduce + (map :amount amounts))} )

(defn map-purchases
     [transaction]
     (get transaction :purchase))

(defn map-amount-by-categories
     [transactions]
     (->> transactions
          (map map-purchases)
          (group-by :category)
          (map total-amount-by-category)))

(defn map-total-amount
     [transactions]
     (->> transactions
          (map-amount-by-categories)
          (map :total-spent)
          (reduce +)))

(defn map-transactions
     [[client-id transactions]]
     {:customer     client-id
      :transactions transactions
      :amount-by-category (map-amount-by-categories transactions)
      :total-spent (map-total-amount transactions)})

(->> (c.db/transactions)
     (group-by :client-id)
     (map map-transactions)
     pprint)