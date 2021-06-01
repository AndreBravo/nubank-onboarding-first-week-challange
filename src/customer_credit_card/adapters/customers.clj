(ns customer-credit-card.adapters.customers
  (:require [customer-credit-card.database.db :as ddb]))

(defn map-customer-transactions
  [customer]
  (let [customer-uuid (:customer/uuid customer)]
    {:customer customer
     :transactions (ddb/get-all-transactions-by-customer-id customer-uuid)}))

(defn get-customers-with-transactions []
  (nu/tap (map map-customer-transactions (ddb/get-all-customers))))

(get-customers-with-transactions)


(->> (ddb/transactions)
     (get-resume)
     pprint)



