;
;   Tests for exercices of 4clojure.com : http://www.4clojure.com/
;
(ns essai.core.test    
    (:use essai.core)
    (:use clojure.test))

(deftest dummy
    (is (= 1 1)))
        
(deftest test-one
    (is (= ""       (keep-capitals "abc"))) 
    (is (= "AC"     (keep-capitals "AbC")))
    (is (= "ABC"    (keep-capitals "ABC")))) 