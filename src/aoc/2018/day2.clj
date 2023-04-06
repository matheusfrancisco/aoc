(ns aoc.2018.day2
  (:require
   [aoc.2018.helper :refer [lines]]))

(defn ocurrence
  [i]
  (->> (frequencies i)
       (vals)
       (set)))

(defn checksum [i]
  (let [aps (->>
             (lines i)
             (map ocurrence))]
    (* 
      (count (filter #(contains? % 2) aps))
      (count (filter #(contains? % 3) aps)))))

(checksum "resources/2018/day2")



