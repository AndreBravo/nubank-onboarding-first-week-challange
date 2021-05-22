(ns customer-credit-card.database.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/credit-card")

(defn- create-database
  []
  (d/create-database db-uri)
  (d/connect db-uri))

(def conn (create-database))

(defn- transact-data
  [schema]
  (d/transact conn schema))

(defn delete-database
  []
  (d/delete-database db-uri))

(defn import-schema
  [conn schema]
  (transact-data schema))

(defn insert-data
  [conn data]
  (transact-data data))

(defn query
  []
  (d/q '[:find ?id
         :where [?id :credit-card:id ]] (d/db conn)))
