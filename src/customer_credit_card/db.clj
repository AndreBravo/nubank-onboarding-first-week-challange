(ns customer-credit-card.db)

(def transaction-1 {:client-id  1
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
                    :purchase   {:amount    100.00
                                  :date     "2021-02-01"
                                  :seller   "McDonalds"
                                  :category "FOOD"
                                  }})
(def transaction-2 {:client-id  1
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
  :purchase                     {:amount 120.00
                :date                    "2021-02-01"
                :seller                  "Amazon"
                :category                "RETAIL"
                }})

(def transaction-3 {:client-id  1
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
  :purchase                     {:amount 500.00
                :date                    "2021-02-02"
                :seller                  "Alura"
                :category                "EDUCATION"
                }})

(def transaction-4 {:client-id  1
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
                    :purchase   {:amount    500.00
                                  :date     "2021-02-02"
                                  :seller   "Coursera"
                                  :category "EDUCATION"
                                  }})


(def transaction-5 {:client-id  4
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
  :purchase                     {:amount 500.00
                :date                    "2021-02-02"
                :seller                  "Alura"
                :category                "EDUCATION"
                }})

(def transaction-6 {:client-id  5
                    :name       "Luke Skywalker"
                    :cpf        "173.967.510-04"
                    :email      "luke@mail.com"
                    :creditCard {:number "5584 8606 9025 2523"
                                 :securityCode "198"
                                 :expiration "10/06/2022"
                                 :credit 1000.00 }
  :purchase                     {:amount 500.00
                :date                    "2021-02-02"
                :seller                  "Amazon"
                :category                "RETAIL"
                }})

(defn transactions
  []
  [transaction-1 transaction-2 transaction-3 transaction-4 transaction-5 transaction-6])