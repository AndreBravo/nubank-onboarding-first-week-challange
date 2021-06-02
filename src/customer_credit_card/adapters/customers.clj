(ns customer-credit-card.adapters.customers
  (:import (java.util UUID))
  (:require [customer-credit-card.database.db :as c.db]
            [customer-credit-card.logic :as c.logic]))

(defn- get-customers
  []
  (c.db/find-all-customers))

(defn- get-transactions
  [customer-uuid]
  (c.db/find-transactions-by-customer-id customer-uuid))

(defn- map-customer-and-transactions
  [customer]
  (c.logic/map-customer-with-transactions customer (get-transactions (get customer :customer/uuid))))

(defn- map-customers []
  (map map-customer-and-transactions (get-customers)))

(defn get-full-resume
  []
  (map-customers))

(defn find-transactions-by-seller
  []
  (c.db/find-transaction-by-seller (UUID/fromString "77a048d1-c1d5-48c8-9535-fa60dbe48308") "Samsung"))

(nu/tap (get-full-resume))
(nu/tap (find-transactions-by-seller))


