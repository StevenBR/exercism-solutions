(ns gigasecond
  (:require [java-time.api :as jt]))

(defn from [year month day]  ;; <- arglist goes here
  (-> (jt/local-date-time year month day)
      (jt/plus (jt/seconds 1000000000))
      (jt/as :year :month-of-year :day-of-month)
      vec))



(comment 
 (def dt (jt/local-date-time 1977 6 13))
 (jt/plus dt (jt/seconds 1000000000))
 (-> dt
     (jt/plus (jt/seconds 1000000000))
     (jt/as :year :month-of-year :day-of-month))
 (from 1977 6 13)
)
