;
;   Solutions for exercices of 4clojure.com : http://www.4clojure.com/
;
(ns essai.core)

(defn keep-capitals [s]
    (apply str (filter #(Character/isUpperCase %) (seq s))))
    
(defn word-sorting [s]
    (sort-by #(.toLowerCase %) (.split (.replaceAll s "[^a-zA-Z ]""") " "))) 
    
(defn- line-for? [l c]
    (every? #(= c %) l))
    
(defn line-for-x? [l] 
    (line-for? l :x))
    
(defn line-for-o? [l] 
    (line-for? l :o))

(defn at [v x y]
    (-> v (nth y) (nth x)))

(defn cols [v]
    (for [x (range (count v))] (map #(nth % x) v)))

(defn diag-up [v]
    (let [len (count v)]
        (for [x (range len)]
            (at v x (- (dec len) x)))))
            
(defn diag-down [v]
    (let [len (count v)]
        (for [x (range len)]
            (at v x x))))

(defn find-winner [v]
    (let [all (conj (map conj v (cols v) (diag-down v) (diag-up v))]
        (cond
            (some line-for-x? all) :x
            (some line-for-o? all) :o
            :else nil)))
