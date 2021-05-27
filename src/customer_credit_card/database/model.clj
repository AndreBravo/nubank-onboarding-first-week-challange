(ns customer-credit-card.database.model)

(def customer
  [{:db/ident       :customer/uuid
    :db/unique      :db.unique/identity
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc         "Customer identifier"}

   {:db/ident       :customer/name
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Customer Full Name"}

   {:db/ident       :customer/cpf
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Customer CPF"}

   {:db/ident       :customer/email
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Customer Email"}])


(def credit-card-schema
  [{:db/ident       :credit-card/uuid
    :db/unique      :db.unique/identity
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc         "Unique identifier"}

   {:db/ident       :credit-card/number
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Card number"}

   {:db/ident       :credit-card/credit-limit
    :db/valueType   :db.type/bigdec
    :db/cardinality :db.cardinality/one
    :db/doc         "Credit Card Maximum Limit"}

   {:db/ident       :credit-card/cvv
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Card cvv"}

   {:db/ident       :credit-card/expire-at
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Card expire at"}

   {:db/ident       :credit-card/transactions
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/many
    :db/doc         "List of transactions UUIDs"}

   {:db/ident       :credit-card/customer-id
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc         "Customer ID"}])


(def transaction-schema
  [{:db/ident       :transaction/uuid
    :db/unique      :db.unique/identity
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc         "Unique identifier"}

   {:db/ident       :transaction/date
    :db/valueType   :db.type/instant
    :db/cardinality :db.cardinality/one
    :db/doc         "Transaction Date"}

   {:db/ident       :transaction/seller
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Seller"}

   {:db/ident       :transaction/amount
    :db/valueType   :db.type/bigdec
    :db/cardinality :db.cardinality/one
    :db/doc         "Transaction amount"}

   {:db/ident       :transaction/category
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Transaction Category"}])

