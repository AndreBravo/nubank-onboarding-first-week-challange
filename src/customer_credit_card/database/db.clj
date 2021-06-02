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

(defn find-all-customers-with-credit-cards []
  (d/q '[:find (pull ?entity [*]) (pull ?credit-card [*]) (pull ?transaction [*])
         :keys :customer :credit-card :transactions
         :where [?entity :customer/uuid ?uuid]
                [?credit-card :credit-card/customer-id ?uuid]
                [?credit-card :credit-card/uuid ?credit-card-uuid]
                [?transaction :transaction/credit-card-uuid ?credit-card-uuid]] (d/db (get-connection))))

(defn find-credit-card-by-customer-id
  [customer-uuids]
  (d/q '[:find (pull ?entity [*])
         :in $ [?customer-uuid ...]
         :where [?entity :credit-card/customer-id ?customer-uuid]] (d/db (get-connection)) customer-uuids))

(defn find-all-customers []
  (d/q '[:find [(pull ?entity [*]) ...]
         :where [?entity :customer/uuid]] (d/db (get-connection))))

(defn find-transactions-by-customer-id
  [customer-uuid]
  (d/q '[:find [(pull ?transaction [*]) ...]
         :in $ ?customer-uuid
         :where [?credit-card :credit-card/customer-id ?customer-uuid]
                [?credit-card :credit-card/uuid ?credit-card-uuid]
                [?transaction :transaction/credit-card-uuid ?credit-card-uuid]] (d/db (get-connection)) customer-uuid))

(defn find-transaction-by-seller
  [customer-uuid seller]
  (d/q '[:find [(pull ?transaction [*]) ...]
         :in $ ?customer-uuid ?transaction-seller
         :where [?credit-card :credit-card/customer-id ?customer-uuid]
                [?credit-card :credit-card/uuid ?credit-card-uuid]
                [?transaction :transaction/credit-card-uuid ?credit-card-uuid]
                [?transaction :transaction/seller ?transaction-seller]] (d/db (get-connection)) customer-uuid seller))



