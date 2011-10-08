;
;   Solutions for exercices of 4clojure.com : http://www.4clojure.com/
;
(ns essai.core)

(defn keep-capitals [s]
    (apply str (filter #(Character/isUpperCase %) (seq s))))
    

