(ns cljs-lecture.views
  (:require [re-frame.core :as rf]
            [cljs-lecture.events :as events]
            [cljs-lecture.slides :refer [slides]]
            [cljs-lecture.subs :as subs]
            [cljs-lecture.components :refer [markdown-panel]]
            [clojure.string :as str]))


(defn form-example []
  (let [text @(rf/subscribe [::subs/text])
        common-letters @(rf/subscribe [::subs/top-common-letters])]
    ;(js-debugger)
    ;(.log js/console common-letters)
    [:div
     [:input {:on-change #(rf/dispatch [::events/text-changed (-> % .-target .-value)])
              :value     text}]
     [:div "You entered: " [:b text]]
     [:div "Most common letters: "
      [:b (->> common-letters
               (map (fn [[letter n]] (str letter "(" n ")")))
               (str/join ", "))]]]))

(def example-components {19 form-example})

(defn main-panel []
  (let [slide-index @(rf/subscribe [::subs/slide-index])]
    [:div.app
     [markdown-panel (get slides slide-index "")]
     (when-let [example-component (get example-components slide-index)]
       [example-component])]))
