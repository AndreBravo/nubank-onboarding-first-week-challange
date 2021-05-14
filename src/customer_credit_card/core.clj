(ns customer-credit-card.core
     (:require [customer-credit-card.db :as c.db]
               [customer-credit-card.logic :as c.logic]))

(defn resume []
  (let [transactions (c.db/transactions)]
    (c.logic/get-resume transactions)))
