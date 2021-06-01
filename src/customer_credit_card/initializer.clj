(ns customer-credit-card.initializer
  (:require [customer-credit-card.database.db :as db]
            [customer-credit-card.database.schema :as m]
            [customer-credit-card.insertions :as i]))

(defn setup-db []
  (db/create-database)
  (db/import-schema m/credit-card-schema)
  (db/import-schema m/transaction-schema)
  (db/import-schema m/customer)
  (i/import-customers)
  (i/import-credit-cards)
  (i/import-transactions))