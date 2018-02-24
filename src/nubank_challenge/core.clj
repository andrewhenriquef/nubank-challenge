(ns nubank-challenge.core
  (:gen-class))


(defn count-offers [min max coll]
  "Get min and max range and return how many numbers are between this range"
  (count (filter (fn [value](and (>= max value)(<= min value))) coll)))


(defn job-offers [scores lower-limits upper-limits]
  (let [max (count lower-limits)]
    (loop [count 0
           new-coll []]
      (if-not (< count max)
        new-coll
        (recur (inc count)
          (conj new-coll (count-offers (nth lower-limits count) (nth upper-limits count) scores)))))))


(defn -main
  [& args]
  (println (job-offers [1 3 4 5 7 9] [2 4] [8 4])))

