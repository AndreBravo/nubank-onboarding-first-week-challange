(ns customer-credit-card.core
  (:require [customer-credit-card.database.db :as db]
            [customer-credit-card.initializer :as i]))


(db/delete-database)
(i/setup-db)



