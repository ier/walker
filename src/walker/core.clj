(ns walker.core
  (:require
   [clojure.edn :as edn])
  (:gen-class))


(defn walk
  [root items acc]
  (reduce
   (fn [acc* {:keys [name items]}]
     (let [root* (str root "/"  name)]
       (if (seq items)
         (walk root* items acc*)
         (conj acc* root*))))
   acc
   items))


(defn m->v
  [{:keys [name items]}]
  (walk name items []))


(defn read-structure
  [filename]
  (->> filename
       slurp
       edn/read-string))


(defn cli-pretty-print [v]
  (doseq [l v]
    (prn l)))


(defn -main
  [& args]
  (if (seq args)
    (let [filename (first args)]
      (->> filename
           read-structure
           m->v
           cli-pretty-print))
    (prn "Usage: java -jar target/uberjar/walker-0.1.0-SNAPSHOT-standalone.jar resources/structure.edn")))
