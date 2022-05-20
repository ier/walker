(ns walker.core
  (:gen-class))

(def data {:name  "root"
           :type  :folder
           :items [{:name  "Отчетность"
                    :type  :folder
                    :items [{:name  "По годам"
                             :type  :folder
                             :items [{:name  "2021"
                                      :type  :folder
                                      :items [{:name "Q1.xls"
                                               :type :file}
                                              {:name "Q2.xls"
                                               :type :file}
                                              {:name "Q3.xls"
                                               :type :file}
                                              {:name "Q4.xls"
                                               :type :file}]}
                                     {:name "Бюджет на 2021.xls"
                                      :type :file}
                                     {:name  "2020"
                                      :type  :folder
                                      :items [{:name "Q1.xls"
                                               :type :file}
                                              {:name "Q2.xls"
                                               :type :file}
                                              {:name "Q3.xls"
                                               :type :file}
                                              {:name "Q4.xls"
                                               :type :file}]}]}
                            {:name "Предварительный отчет Q1 2022.xls"
                             :type :file}]}
                   {:name "test.txt"
                    :type :file}
                   {:name  "Документы"
                    :type  :folder
                    :items [{:name "Служебная записка.doc"
                             :type :file}
                            {:name  "Бюджеты"
                             :type  :folder
                             :items [{:name "2021.xls"
                                      :type :file}
                                     {:name  "Промежуточные"
                                      :type  :folder
                                      :items [{:name "Q1 2021.xls"
                                               :type :file}
                                              {:name "Q2 2021.xls"
                                               :type :file}]}
                                     {:name "2022.xls"
                                      :type :file}]}]}
                   {:name "temp"
                    :type :folder}]})

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


(comment
  (m->v data)

  )

(defn -main
  [& args])
