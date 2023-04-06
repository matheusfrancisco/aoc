(ns aoc.2018.day1
  (:require
   [aoc.2018.helper :refer [lines]]))


(defn star [input-file]
  (->> (lines input-file)
       (map #(Integer/parseInt %))
       (apply +)))

(cycle [1 2 3 4 54])
(defn star* [input-file]
  (let [numbers (->> (lines input-file)
               (map #(Integer/parseInt %)))]
    (loop [[n & rn] (cycle numbers) f 0 acc #{}]
      (let [f (+ f n)]
        (if (acc f)
          f
          (recur rn f (conj acc f)))))))

(println (star "resources/2018/input1"))
(println (star* "resources/2018/input1"))

