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


(comment
  (->> "resources/structure.edn"
       read-structure
       m->v)

  )


(defn -main
  [& args])
