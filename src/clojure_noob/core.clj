(ns clojure-noob.core
  (:gen-class))

(defn -main [& _]
  (println "I'm a little teapot"))

(defn ops []
      (+ 1 2 3 4))
(def sush-alias ["yasmin" "minnu" "sloo"])

(ops)

(+ 1 2 3)

(str "It was the pand" "in the library " "with a hammer")

(defn error-mes [severity]
  (str "OH GOD WE GONNA"
       (if (= severity :mild) " BE MILDLY INCON" " DED")))

(error-mes :harsh)

(def sushmap {:first "Sush" :last "Azad"})

(defn oohlala [xyz]
  (get sushmap :last))

(oohlala :abc)

(sushmap :last)

(:bloo sushmap)


(def mylist [1 2 3 676])
(get mylist 8)
(conj mylist 3 4 7)
(get mylist 3)
'(1 2 3 4)


" Write a function which takes a function f and a variable number of maps.
Your function should return a map that consists of the rest of the maps conj-ed onto the first.
If a key occurs in more than one map, the mapping (s)
from the latter (left-to-right) should be combined with the mapping in the result by calling (f val-in-result val-in-latter)"
;(= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
;   {:a 4, :b 6, :c 20})
;
;(= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
;   {1 7, 2 10, 3 15})
;(= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
;   {:a [3 4 5], :b [6 7], :c [8 9]})

(defn doManythings
  ([f]
   {})

  ([f m1]
   m1)

  ([f m1 m2]
   (let [keys1 (keys m1)
         keys2 (keys m2)
         distinct-keys (set (concat keys1 keys2))]
     (into {}
           (for [k distinct-keys]
             [k (cond
                  (and (contains? m1 k)
                       (contains? m2 k))
                  (f (m1 k) (m2 k))
                  (contains? m1 k) (m1 k)
                  (contains? m2 k) (m2 k))])))))

(doManythings * {:a  2, :b 3, :c 4} {:a 2})

(defn plz [] (set '(:a :a :b :c :c :c :c :d :d)))

(apply str
       (re-seq #"[A-Z]+" "bA1B3Ce "))

((fn foo [x] (when (> x 0) (conj (foo (dec x)) x)))5)

(loop [x 5
       result []]
  (if (> x 0)
    (recur (dec x) (conj result (+ 2 x)))
    result))

(map (partial reduce +) [[1 2 3 4] [5 6 7 8]])

(->> [2 5 4 1 3 6]
     (drop 2)
     (take 3)
     (map inc))

(for [x (range 40)
            :when (= 1 (rem x 4))]
           x)
(.split "a 1 b 2 c 3" " ")

(defn p156 [defaultval keys] (let [key-map (for [key keys] {key defaultval})
                                   map-set {}]
                               (println key-map)
                               (reduce #(conj %1 %2) map-set key-map)))

(p156 0 [:a :b :c])

(conj {} {:b "2"})

(let [key-map {}]
  (for [x [0 1 2 3]]
    (conj)))


((fn [seq] (last seq)) [1 2 3 4])

((fn [seq] (let [len (count seq)]
           (println len)
           (nth seq (- len 1)))) [1 2 3 4])

(fn [seq] (let [len (count seq)]
            (nth seq (- len 2))))

((fn [seq n] (last (take (+ n 1) seq)))'(1 2 3 4 5) 2)

(fn [seq] (reduce + (map (constantly 1) seq)))

(reduce + (map (constantly 1) [:a :b :c]))

(defn la [seq] (let [mylist '()]
            (map #(conj mylist %1) seq)))
(la '(1 2 3))

((fn [seq] (reduce + seq)) [1 2 3])