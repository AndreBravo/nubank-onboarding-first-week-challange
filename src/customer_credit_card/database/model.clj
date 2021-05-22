(ns customer-credit-card.database.model)

(def schema [{:db/ident :credit-card:id
    :db/unique      :db.unique/identity
    :db/valueType :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc "Unique identifier"
    }
   {:db/ident :credit-card:name
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Customer Full Name"
    }
   {:db/ident :credit-card:number
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Card number"
    }
   {:db/ident :credit-card:cvv
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Card cvv"
    }
   {:db/ident :credit-card:number
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Card number"
    }
   {:db/ident :credit-card:expire-at
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Card expire at"
    }])
