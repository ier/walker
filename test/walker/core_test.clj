(ns walker.core-test
  (:require [clojure.test :refer [deftest is]]
            [walker.core :as w]))

(deftest main-test
  (let [input (w/read-structure "resources/structure.edn")
        expected ["root/Отчетность/По годам/2021/Q1.xls"
                  "root/Отчетность/По годам/2021/Q2.xls"
                  "root/Отчетность/По годам/2021/Q3.xls"
                  "root/Отчетность/По годам/2021/Q4.xls"
                  "root/Отчетность/По годам/Бюджет на 2021.xls"
                  "root/Отчетность/По годам/2020/Q1.xls"
                  "root/Отчетность/По годам/2020/Q2.xls"
                  "root/Отчетность/По годам/2020/Q3.xls"
                  "root/Отчетность/По годам/2020/Q4.xls"
                  "root/Отчетность/Предварительный отчет Q1 2022.xls"
                  "root/test.txt"
                  "root/Документы/Служебная записка.doc"
                  "root/Документы/Бюджеты/2021.xls"
                  "root/Документы/Бюджеты/Промежуточные/Q1 2021.xls"
                  "root/Документы/Бюджеты/Промежуточные/Q2 2021.xls"
                  "root/Документы/Бюджеты/2022.xls"
                  "root/temp"]
        actual (w/m->v input)]
    (is (= expected actual))))
