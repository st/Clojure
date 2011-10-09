;
;   Tests for exercices of 4clojure.com : http://www.4clojure.com/
;
(ns essai.core.test    
    (:use essai.core)
    (:use clojure.test))

(deftest dummy
    (is (= 1 1)))
        
(deftest test-get-caps
    (is (= ""       (keep-capitals "abc"))) 
    (is (= "AC"     (keep-capitals "AbC")))
    (is (= "ABC"    (keep-capitals "ABC")))) 
    
    
(deftest test-word-sorting    
    (is (= (word-sorting  "Have a nice day.")                   ["a" "day" "Have" "nice"]))
    (is (= (word-sorting  "Clojure is a fun language!")         ["a" "Clojure" "fun" "is" "language"]))
    (is (= (word-sorting  "Fools fall for foolish follies.")    ["fall" "follies" "foolish" "Fools" "for"])))
    
(deftest test-detect-x
    (is (not (line-for-x?   [:e :e :e])))
    (is (not (line-for-x?   [:x :x :e])))
    (is (line-for-x?        [:x :x :x])))

(deftest test-detect-o
    (is (not (line-for-o?   [:e :e :e])))
    (is (not (line-for-o?   [:o :o :e])))
    (is (line-for-o?        [:o :o :o])))
 
(deftest test-extract-cols
    (is (= [[:x :x :x] [:e :e :e] [:e :x :e]]
        (cols [ [:x :e :e]
                [:x :e :x]
                [:x :e :e]]))))
                
 (deftest test-diag-up
     (is (= [:x :e :x]
         (diag-up [ [:o :e :x]
                    [:x :e :e]
                    [:x :e :o]]))))
                    
(deftest test-diag-down
    (is (= [:o :e :o]
        (diag-down [ [:o :e :x]
                     [:x :e :e]
                     [:x :e :o]]))))


(deftest test-find-winner
    (is (= nil (find-winner [[:e :e :e]
                            [:e :e :e]
                            [:e :e :e]])))
    
    (is (= :x (find-winner [[:x :e :o]
                            [:x :e :e]
                            [:x :e :o]])))
    
    (is (= :o (find-winner [[:e :x :e]
                            [:o :o :o]
                            [:x :e :x]])))
     
    (is (= nil (find-winner [[:x :e :o]
                            [:x :x :e]
                            [:o :x :o]])))
     
    (is (= :x (find-winner [[:x :e :e]
                            [:o :x :e]
                            [:o :e :x]])))
     
    (is (= :o (find-winner [[:x :e :o]
                            [:x :o :e]
                            [:o :e :x]])))
     
    (is (= nil (find-winner [[:x :o :x]
                            [:x :o :x]
                            [:o :x :o]]))))