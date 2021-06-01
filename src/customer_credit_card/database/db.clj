(ns customer-credit-card.database.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/credit-card")

(defn get-connection [] (d/connect db-uri))

(defn create-database
  []
  (d/create-database db-uri)
  (get-connection))

(defn- transact-data
  [data]
  (d/transact (get-connection) data))

(defn delete-database
  []
  (d/delete-database db-uri))

(defn import-schema
  [schema]
  (transact-data schema))

(defn insert-data
  [data]
  (transact-data data))

(defn query
  [query]
  (d/q query))

(defn get-all-customers-with-credit-cards []
  (d/q '[:find (pull ?entity [*]) (pull ?credit-card [*]) (pull ?transaction [*])
         :keys :customer :credit-card :transactions
         :where [?entity :customer/uuid ?uuid]
         [?credit-card :credit-card/customer-id ?uuid]
         [?credit-card :credit-card/transactions ?tx-uuid]
         [?transaction :transaction/uuid ?tx-uuid]] (d/db (get-connection))))

(defn get-credit-card-by-customer-id
  [customer-uuids]
  (d/q '[:find (pull ?entity [*])
         :in $ [?customer-uuid ...]
         :where [?entity :credit-card/customer-id ?customer-uuid]] (d/db (get-connection)) customer-uuids))

(defn get-all-customers []
  (d/q '[:find [(pull ?entity [*]) ...]
         :where [?entity :customer/uuid]] (d/db (get-connection))))

(defn get-all-transactions-by-customer-id
  [customer-uuid]
  (d/q '[:find [(pull ?transaction [*]) ...]
         :in $ ?customer-uuid
         :where [?credit-card :credit-card/customer-id ?customer-uuid]
         [?credit-card :credit-card/transactions ?tx-uuid]
         [?transaction :transaction/uuid ?tx-uuid]] (d/db (get-connection)) customer-uuid))



