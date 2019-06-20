(ns clojure-noob.4clojure)

(fn [k m] (and (contains? m k) (nil? (m k))))

;Problem 2
(= (- 10 (* 2 3)) __)
;Ans
(4)


;Problem 4
(= (list __) '(:a :b :c))
;Ans
:a :b :c

;Problem  5
(= __ (conj '(2 3 4) 1))

(= __ (conj '(3 4) 2 1))
;Ans
'(1 2 3 4)

;Problem 16: Write a function which returns a personalized greeting
(= (__ "Dave") "Hello, Dave!")

(= (__ "Jenn") "Hello, Jenn!")

(= (__ "Rhea") "Hello, Rhea!")
;Ans
(fn namely [boo] (str "Hello, " boo "!"))


;Problem 17: The map function takes two arguments: a function (f) and a sequence (s).
;Map returns a new sequence consisting of the result of applying f to each item of s.
;Do not confuse the map function with the map data structure.
(= __ (map #(+ % 5) '(1 2 3)))
;Ans:
'(6 7 8)

;Problem 18: The filter function takes two arguments: a predicate function (f) and a sequence (s).
; Filter returns a new sequence consisting of all the items of s for which (f item) returns true.
(= __
   (filter #(> % 5) '(3 4 5 6 7)))
;Ans:
'(6 7)

;Problem 19: Write a function which returns the last element in a sequence.

(= (__ [1 2 3 4 5]) 5)
(= (__ '(5 4 3)) 3)
(= (__ ["b" "c" "d"]) "d")
;Ans
(fn [seq] (let [len (count seq)]
            (println len)
            (nth seq (- len 1))))
;Problem 20: Write a function which returns the second to last element from a sequence.

(= (__ (list 1 2 3 4 5)) 4)

(= (__ ["a" "b" "c"]) "b")

(= (__ [[1 2] [3 4]]) [1 2])
;Ans

(fn [seq] (let [len (count seq)]
            (nth seq (- len 2))))

;Problem 21:Write a function which returns the Nth element from a sequence.
(= (__ '(4 5 6 7) 2) 6)
(= (__ [:a :b :c] 0) :a)
(= (__ [1 2 3 4] 1) 2)
(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

;Ans
(fn [seq n] (last (take (+ n 1) seq)))

;Problem 22:
Write a function which returns the total number of elements in a sequence.
(= (__ '(1 2 3 3 1)) 5)
(= (__ "Hello World") 11)
(= (__ [[1 2] [3 4] [5 6]]) 3)
(= (__ '(13)) 1)
(= (__ '(:a :b :c)) 3)
(= (__ '(:a :b :c)) 3)
;Ans:
(fn [seq] (reduce + (map (constantly 1) seq)))

;Problem 24: Write a function which returns the sum of a sequence of numbers.
(= (__ [1 2 3]) 6)
(= (__ (list 0 -2 5 5)) 8)
(= (__ #{4 2 1}) 7)
(= (__ '(0 0 -1)) -1)
(= (__ '(1 10 3)) 14)
(= (__ '(1 10 3)) 14)

;Ans:
(fn [seq] (reduce + seq))

;Problem 25:  Write a function which returns only the odd numbers from a sequence.
(= (__ #{1 2 3 4 5}) '(1 3 5))
(= (__ [4 2 1 6]) '(1))
(= (__ [2 2 4 6]) '())
(= (__ [1 1 1 3]) '(1 1 1 3))
;Ans:
#(filter odd? %)




;Problem 35: Clojure lets you give local names to values using the special let-form.

(= __ (let [x 5] (+ 2 x)))
(= __ (let [x 3, y 10] (- y x)))
(= __ (let [x 21] (let [y 3] (/ x y))))
;Ans:
7

;Problem 36: Can you bind x, y, and z so that these are all true?
(= 10 (let __ (+ x y)))
(= 4 (let __ (+ y z)))
(= 1 (let __ z))
;Ans
[z 1 y 3 x 7]

;Problem 37: Regex patterns are supported with a special reader macro.
(= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
(= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
;Ans:
"ABC"

;Problem 52: Let bindings and function parameter lists support destructuring.
(= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
;Ans:
[c e]


;Problem 54: A recursive function is a function which calls itself. This is one of the fundamental techniques used in functional programming.
(= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
;Ans:
[5 4 3 2 1]

;Problem 64: Reduce takes a 2 argument function and an optional starting value. It then applies the function to the first 2 items in the sequence (or the starting value and the first element of the sequence). In the next iteration the function will be called on the previous return value and the next item from the sequence, thus reducing the entire collection to one value. Don't worry, it's not as complicated as it sounds.
(= 15 (reduce __ [1 2 3 4 5]))
(=  0 (reduce __ []))
(=  6 (reduce __ 1 [2 3]))
;Ans:
+

;Problem 71: The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item in the first form, making a list of it if it is not a list already. Then the first form is inserted as the second item in the second form, making a list of that form if necessary. This process continues for all the forms. Using -> can sometimes make your code more readable.
(= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
   5)
;Ans:
last

;Problem 145: Clojure's for macro is a tremendously versatile mechanism for producing a sequence based on some other sequence(s). It can take some time to understand how to use it properly, but that investment will be paid back with clear, concise sequence-wrangling later. With that in mind, read over these for expressions and try to see how each of them produces the same result.
(= __ (for [x (range 40)
            :when (= 1 (rem x 4))]
        x))
(= __ (for [x (range 40)
            :when (= 1 (rem x 4))]
        x))
(= __ (for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z))
(= __ (for [[x y] (partition 2 (range 20))]
        (+ x y)))
(= __ (for [[x y] (partition 2 (range 20))]
        (+ x y)))
;Ans:
[1 5 9 13 17 21 25 29 33 37]

;Problem 156: When retrieving values from a map, you can specify default values in case the key is not found:
;
;(= 2 (:foo {:bar 0, :baz 1} 2))
;
;However, what if you want the map itself to contain the default values? Write a function which takes a default value and a sequence of keys and constructs a map.
(= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0})
(= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
(= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})

;Ans
(fn [defaultval keys] (let [key-map (for [key keys] {key defaultval})
                                   map-set {}]
                               (reduce #(conj %1 %2) map-set key-map)))

;Problem 161: Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained" inside B. A and B may coincide.
(clojure.set/superset? __ #{2})
(clojure.set/subset? #{1} __)
(clojure.set/superset? __ #{1 2})
(clojure.set/subset? #{1 2} __)
(clojure.set/subset? #{1 2} __)
;Ans
#{1 2 3}

;Problem 162: In Clojure, only nil and false represent the values of logical falsity in conditional tests - anything else is logical truth.
(= __ (if-not false 1 0))
(= __ (if-not nil 1 0))
(= __ (if true 1 0))
(= __ (if [] 1 0))
(= __ (if [0] 1 0))
(= __ (if 0 1 0))
(= __ (if 1 1 0))
;Ans:
1

