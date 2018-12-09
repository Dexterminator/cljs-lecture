(ns cljs-lecture.components
  (:require [cljsjs.markdown-it]
            [cljsjs.highlight]))

(def md (js/markdownit. #js {:highlight (fn [s lang] (.-value (.highlight js/hljs lang s)))}))

(defn render-markdown [s]
  (.render md s))

(defn markdown-panel [s]
  [:div.markdown-panel {:dangerouslySetInnerHTML {:__html (render-markdown s)}}])
