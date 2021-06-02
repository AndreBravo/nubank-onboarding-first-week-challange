(ns customer-credit-card.core-test
  (:require [clojure.test :refer :all]
            [customer-credit-card.core :refer :all :as c.core]))

(deftest get-resume-test
  (testing "Testando"
    (let [resume (c.core/resume)]
      (println "Quantidade na fila" (count resume))
      (is (= 3 (count resume))))))
