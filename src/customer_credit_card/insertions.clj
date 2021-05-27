(ns customer-credit-card.insertions
  (:use clojure.pprint)
  (:import (java.util UUID Date))
  (:require [customer-credit-card.database.db :as db]))


(def customer-1-uuid (UUID/randomUUID))
(def customer-2-uuid (UUID/randomUUID))
(def customer-3-uuid (UUID/randomUUID))

(def customer-1 {:customer/uuid  customer-1-uuid
                 :customer/name  "Luke Skywalker"
                 :customer/cpf   "173.967.510-04"
                 :customer/email "luke@mail.com"})

(def customer-2 {:customer/uuid  customer-2-uuid
                 :customer/name  "Jannis Joplin"
                 :customer/cpf   "132.634.790-08"
                 :customer/email "janis@mail.com"})

(def customer-3 {:customer/uuid  customer-3-uuid
                 :customer/name  "Anakin Skywalker"
                 :customer/cpf   "120.635.030-01"
                 :customer/email "anakin@mail.com"})

(def transaction-1-uuid (UUID/randomUUID))
(def transaction-2-uuid (UUID/randomUUID))
(def transaction-3-uuid (UUID/randomUUID))
(def transaction-4-uuid (UUID/randomUUID))

(def transaction-1 {:transaction/uuid     transaction-1-uuid
                    :transaction/date     (new Date)
                    :transaction/seller   "McDonalds"
                    :transaction/amount   100.0M
                    :transaction/category "FOOD"})

(def transaction-2 {:transaction/uuid     transaction-2-uuid
                    :transaction/date     (new Date)
                    :transaction/seller   "Nike"
                    :transaction/amount   50.0M
                    :transaction/category "CLOTHES"})

(def transaction-3 {:transaction/uuid     transaction-3-uuid
                    :transaction/date     (new Date)
                    :transaction/seller   "Samsung"
                    :transaction/amount   400.0M
                    :transaction/category "ELECTRONICS"})

(def transaction-4 {:transaction/uuid     transaction-4-uuid
                    :transaction/date     (new Date)
                    :transaction/seller   "Guanabara"
                    :transaction/amount   300.0M
                    :transaction/category "FOOD"})

(def credit-card-1 {:credit-card/uuid         (UUID/randomUUID)
                    :credit-card/number       "5584 8606 9025 2523"
                    :credit-card/cvv          "198"
                    :credit-card/expire-at    "10/06/2022"
                    :credit-card/credit-limit 1000.0M
                    :credit-card/customer-id  customer-1-uuid})

(def credit-card-2 {:credit-card/uuid         (UUID/randomUUID)
                    :credit-card/number       "5479 0298 5352 2878"
                    :credit-card/cvv          "907"
                    :credit-card/expire-at    "26/05/2023"
                    :credit-card/credit-limit 2000.0M
                    :credit-card/customer-id  customer-2-uuid})

(def credit-card-3 {:credit-card/uuid         (UUID/randomUUID)
                    :credit-card/number       "5250 7558 6562 7645"
                    :credit-card/cvv          "262"
                    :credit-card/expire-at    "26/12/2021"
                    :credit-card/credit-limit 5000.0M
                    :credit-card/customer-id  customer-3-uuid
                    :credit-card/transactions [transaction-1-uuid transaction-2-uuid]})


(defn import-customers
  []
  (db/insert-data [customer-1 customer-2 customer-3]))

(defn import-credit-cards
  []
  (db/insert-data [credit-card-1 credit-card-2 credit-card-3]))

(defn import-transactions
  []
  (db/insert-data [transaction-1 transaction-2 transaction-3 transaction-4]))