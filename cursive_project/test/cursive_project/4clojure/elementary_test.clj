(ns cursive-project.4clojure.elementary_test
  (:require [clojure.test :refer :all]))

(deftest test-equals
         (is (= true true)))

(deftest test-simple-math
  (is (= (- 10 (* 2 3)) 4)))

(deftest test-strings
  (is (= "HELLO WORLD" (.toUpperCase "hello world"))))