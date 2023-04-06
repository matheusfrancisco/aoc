(ns aoc.2018.day3
  (:require
   [aoc.2018.helper :refer [lines]]))

(defn squares [i]
  (let [inputs
        (->> (lines i))
        parsed-inputs (map 
                        (fn [line]
                          (let [[[_ & regns]] (re-seq #"(\d+) @ (\d+)\,(\d+)\: (\d+)x(\d+)" line)
                                [id sx sy width length] (map #(Integer/parseInt %)
                                                             regns)]
                            (set 
                              (for [x (range width)
                                    y (range length)]
                                [(+ sx x) (+ sy y)])))) 
                        inputs)]
    parsed-inputs))

(squares "resources/2018/day3")
