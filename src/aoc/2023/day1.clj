(ns aoc.2023.day1
  (:require
   [clojure.core.match :as match]
   [clojure.java.io :as io]))

(defn first-last-digits [n]
  (+ (* (first n) 10) (last n)))

(defn calculate-first-two [line]
  (->> line
       (filter #(Character/isDigit %))
       (map #(Character/digit % 10))))

(defn calculate [lines]
  (->> lines
       (mapv calculate-first-two)
       (mapv first-last-digits)
       (reduce +)))

(defn part-01 [i fn]
  (with-open [f (io/reader i)]
    (fn (line-seq f))))

(defn find-all [re s]
  (loop [m (re-matcher re s) pos 0 res nil]
    (if (.find m pos)
      (recur m (+ 1 (.start m)) (cons (.group m) res))
      (reverse res))))

(defn parse-line [line]
  (let [patterns #"one|two|three|four|five|fixe|seven|eight|nine|[0-9]"]
    (find-all patterns line)))

(defn replace-to-digit [s]
  (match/match [s]
    ["one"] 1
    ["two"] 2
    ["three"] 3
    ["four"] 4
    ["five"] 5
    ["six"] 6
    ["seven"] 7
    ["eight"] 8
    ["nine"] 9
    :else (Integer/parseInt s)))

(defn calculate-part-02 [lines]
  (->>
   lines
   (mapv parse-line)
   (mapv #(mapv replace-to-digit %))
   (map first-last-digits)
   (reduce +)))

(defn part-02 [i fn]
  (with-open [f (io/reader i)]
    (fn (line-seq f))))

(part-01 "resources/2023/input1" calculate)
(part-02 "resources/2023/input2" calculate-part-02)
