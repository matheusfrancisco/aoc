(ns aoc.2018.helper
  (:require [clojure.string :as str]))

(defn lines [i]
  (str/split (slurp i)
             #"\n"))
