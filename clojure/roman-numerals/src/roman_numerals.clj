(ns roman-numerals)

(def roman-int-coll [["M" 1000] ["CM" 900] ["D" 500] ["CD" 400]
                   ["C" 100] ["XC" 90] ["L" 50] ["XL" 40]
                   ["X" 10] ["IX" 9] ["V" 5] ["IV" 4] ["I" 1]])

(defn int->roman [n]
  (->> roman-int-coll 
       (filter #(<= (second %) n))
       first))

(defn numerals [digit]
  (loop [acc ""
         n digit]
    (if (zero? n)
      acc
      (let [[numeral value] (int->roman n)]
        (recur (str acc numeral) (- n value))))))

(comment 

  (defn numerals-recur 
    ([n] (numerals-recur "" n))
    ([acc n]
     (if (zero? n)
       acc
       (let [[numeral value] (int->roman n)]
         (recur (str acc numeral) (- n value))))))

  (->> roman-int-coll
       (filter #(<= (second %) 38))
       first)
  )
