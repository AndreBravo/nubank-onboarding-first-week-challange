(ns customer-credit-card.core
  (:require [customer-credit-card.database.db :as db]
            [customer-credit-card.initializer :as i]))

(i/setup-db)
(db/delete-database)


