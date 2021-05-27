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


