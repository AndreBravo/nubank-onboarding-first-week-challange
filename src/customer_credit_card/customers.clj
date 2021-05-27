(ns customer-credit-card.customers
  (:require [customer-credit-card.database.db :as db]
            [datomic.api :as d]))

(defn get-all-customers []
  (d/q '[:find [(pull ?entity [*]) ...]
         :where [?entity :customer/uuid]] (d/db (db/get-connection))))

(defn get-all-customers-with-credit-cards []
  (d/q '[:find (pull ?entity [*]) (pull ?credit-card [*]) (pull ?transaction [*])
         :keys :customer :credit-card :transactions
         :where [?entity :customer/uuid ?uuid]
         [?credit-card :credit-card/customer-id ?uuid]
         [?credit-card :credit-card/transactions ?tx-uuid]
         [?transaction :transaction/uuid ?tx-uuid]] (d/db (db/get-connection))))

(defn get-credit-card-by-customer-id
  [customer-uuids]
  (d/q '[:find (pull ?entity [*])
         :in $ [?customer-uuid ...]
         :where [?entity :credit-card/customer-id ?customer-uuid]] (d/db (db/get-connection)) customer-uuids))

(defn map-customers-uuid
  [customers]
  (get customers :customer/uuid))

;(nu/tap (get-credit-card-by-customer-id (map map-customers-uuid (get-all-customers))))

(defn map-return
  [entities]
  {:customer (get entities :customer)
   :transactions (get entities :transactions)})

(nu/tap (map map-return (get-all-customers-with-credit-cards)))

