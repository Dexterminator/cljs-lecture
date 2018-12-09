(ns cljs-lecture.views
  (:require [re-frame.core :as rf]
            [cljs-lecture.events :as events]
            [cljs-lecture.slides :refer [slides]]
            [cljs-lecture.subs :as subs]
            [cljs-lecture.components :refer [markdown-panel]]))

(defn main-panel []
  (let [slide-index @(rf/subscribe [::subs/slide-index])]
    [:div.app
     [markdown-panel (get slides slide-index "")]]))
