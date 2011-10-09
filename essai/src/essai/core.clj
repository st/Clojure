;
;   Solutions for exercices of 4clojure.com : http://www.4clojure.com/
;
(ns essai.core)

(defn keep-capitals [s]
    (apply str (filter #(Character/isUpperCase %) (seq s))))
    
(defn word-sorting [s]
    (sort-by #(.toLowerCase %) (.split (.replaceAll s "[^a-zA-Z ]""") " "))) 
    
;(defn line-for? [l c]
;    (every? #(= c %) l))
;
;(defn at [v x y]
;    (-> v (nth y) (nth x)))
;
;(defn cols [v]
;    (for [x (range (count v))] (map #(nth % x) v)))
;
;(defn diag-up [v]
;    [(at v 0 2) (at v 1 1) (at v 2 0)])
;            
;(defn diag-down [v]
;    [(at v 0 0) (at v 1 1) (at v 2 2)])
;    
;(defn wins? [v c]
;    (or
;        (some #(line-for? % c) v) 
;        (some #(line-for? % c) (cols v))
;        (line-for? (diag-up v) c)
;        (line-for? (diag-down v) c)))

(defn find-winner [v]
    (let [  line-for? (fn [l c] (every? #(= c %) l))
            at (fn [v x y] (-> v (nth y) (nth x)))
            diag-up (fn [v] [(at v 0 2) (at v 1 1) (at v 2 0)])
            diag-down (fn [v] [(at v 0 0) (at v 1 1) (at v 2 2)])            
            cols (fn [v] (for [x (range (count v))] (map #(nth % x) v)))            
            wins? (fn [v c]
                    (or
                        (some #(line-for? % c) v) 
                        (some #(line-for? % c) (cols v))
                        (line-for? (diag-up v) c)
                        (line-for? (diag-down v) c)))]
    (cond
        (wins? v :x) :x
        (wins? v :o) :o
        :else nil)))
