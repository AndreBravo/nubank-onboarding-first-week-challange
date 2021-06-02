(ns customer-credit-card.logic
  (:use clojure.pprint))

(defn- map-transaction
  [transaction]
  {:amount (get transaction :transaction/amount)
   :date (get transaction :transaction/date)
   :seller (get transaction :transaction/seller)
   :category (get transaction :transaction/category)})

(defn total-amount-by-category
  [[category amounts]]
  {:category category
   :total (reduce + (map :transaction/amount amounts))})

(defn- group-amount-by-category
  [transactions]
  (->> transactions
       (group-by :transaction/category)
       (map total-amount-by-category)))

(defn map-customer-with-transactions
  [customer transactions]
  {:customer     {:name (get customer :customer/name)}
   :transactions (map map-transaction transactions)
   :categories (group-amount-by-category transactions)})



