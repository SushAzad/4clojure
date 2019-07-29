(ns clojure-noob.core
  (:gen-class)
  (:require [clojure.string :as str]))

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

(doManythings * {:a 2, :b 3, :c 4} {:a 2})

(defn plz [] (set '(:a :a :b :c :c :c :c :d :d)))

(apply str
  (re-seq #"[A-Z]+" "bA1B3Ce "))

((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)

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

((fn [seq n] (last (take (+ n 1) seq))) '(1 2 3 4 5) 2)

(fn [seq] (reduce + (map (constantly 1) seq)))

(reduce + (map (constantly 1) [:a :b :c]))

(defn la [seq] (let [mylist '()]
                 (map #(conj mylist %1) seq)))
(la '(1 2 3))

((fn [seq] (reduce + seq)) [1 2 3])

(defn lala [seq]
  (into [] (conj (into () seq))))


(fn [sequ] (= sequ (rseq sequ)))




(fn [func]
  (fn [x y]
    (func y x)))

((fn [n]
   (->> [0 1]
        (iterate (fn [[a b]] [b (+ a b)]))
        (map first)
        (take n))) 4)

(defn fib
  ([n]
   (fib [0 1] n))
  ([x, n]
   (if (< (count x) n)
     (fib (conj x (+ (last x) (nth x (- (count x) 2)))) n)
     x)))

(fib 5)


(defn inc-maker
  "Custom incrementer"
  [inc-by]
  #(/ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)




(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-kidney" :size 1}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "left-forearm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "abdomen" :size 6}
                             {:name "left-achilles" :size 1}
                             {:name "mouth" :size 1}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             ])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a sequence of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))


(defn better-symmetrize-body-parts
  "Expects a sequence of maps that have a :name and a :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          [] asym-body-parts))
(symmetrize-body-parts asym-hobbit-body-parts)
(better-symmetrize-body-parts asym-hobbit-body-parts)



(defn hit [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)

(def dalmation-list
  ["Pongo" "Peredita" "Pup 1" "Pup 2"])
(let [dalmations (take 2 dalmation-list)]
  dalmations)

(let [[pongo pingo & dalmations] dalmation-list]
  [pongo pingo dalmations])




(defn inc-maker
  "Custom incrementer"
  [inc-by]
  #(/ % inc-by))

(def inc3 (inc-maker 3))


(defn lala [mmax & body]
  (if (= nil body)
    mmax
    (if (> (first body) mmax)
      (apply lala body)
      (apply lala (conj (rest body) mmax)))))
(lala 1 8 3 4)

(defn nmax [a b]
  )

(fn nicola [& body]
  (reduce (fn [a b]
            (if (> a b)
              a
              b)) body))

(nmax 9 5)

((fn [strin]
   (apply str (filter #(Character/isUpperCase %) strin))) "SushMita")


((fn [llist]
   (reduce (fn [acc x] (conj acc x x)) [] llist)) [1 2 3])


(#{4 5 6 nil} 4)

(defn flat [llist]
  (reduce (fn [acc x]
            (if (coll? x)
              (vec (concat acc (flat x)))
              (conj acc x))) [] llist))
(flat [1 2 [3 [4]] 5 6])


(defn compress [collec]
  (reduce (fn [acc x]
            (if (= (last acc) x)
              acc
              (conj acc x))) [] collec))

(#(->> % (partition-by identity) (map first)) [1 1 2 3 3 2 2 3])

(defn ranges [a b]
  (take (- b a) (iterate inc a)))
(ranges 5 9)

(range 1 7)

(defn fact [n]
  (apply * (range 1 (+ 1 n))))

(apply + 1 2 [3 4])

(fact 5)

(def plus5 (partial + 5))

(plus5 5)

(def isNicola? (partial = "Nicola"))

(isNicola? "Nicola")
(map isNicola? ["Spencer" "Sush" "Nicola"])

(defn rev-interleave [coll x]
  (map second (group-by #(mod % x)
                        coll)))

(defn gcd [a b]
  (if (= 0 (mod a b))
    b
    (gcd b (mod a b))))

(gcd 1023 858)

(take 5 (iterate #(+ 3 %) 1))

(defn split [n coll]
  [(take n coll) (drop n coll)])

(take 3 [1 2 3 4 5 6])

(split 3 [1 2 3 4 5 6])

(type [1 2 3])

(defn split-type [coll]
  (map second (group-by type coll)))

(split-type [1 :a 2 :b])

(defn set-inter [a b]
  (set (remove nil? (for [x a
                          y b]
                      (when (= x y) x)))))


(#{3 :a #{1 2} 4 5} #{1 2})

(set-inter #{1 2 3} #{2 3 4 5})



(defn prod-dig [a  b]
  (map #(Integer/parseInt %) (str/split (str (* a b)) #"")))

#_(prod-dig 5 10)


((fn prod-dig [a b]
   (map #( Character/digit % 10) (str (* a b))))1 1)

(fn [n]
    (fn [x]
        (apply * (repeat n x))))