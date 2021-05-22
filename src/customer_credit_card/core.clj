(ns customer-credit-card.core
  (:use clojure.pprint)
  (:require [customer-credit-card.database.db :as db]
            [customer-credit-card.database.model :as m]))

(db/import-schema db/conn m/schema)

(db/insert-data
  db/conn
  [{:credit-card:number    "5584 8606 9025 2523"
    :credit-card:cvv       "198"
    :credit-card:expire-at "10/06/2022"
    :credit-card:id        1
    :credit-card:name      "Luke Skywalker"
    }])

(pprint (db/query))

(db/delete-database)