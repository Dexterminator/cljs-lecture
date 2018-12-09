(ns cljs-lecture.core
  (:require
    [reagent.core :as reagent]
    [re-frame.core :as rf]
    [cljs-lecture.events :as events]
    [cljs-lecture.views :as views]
    [cljs-lecture.config :as config]
    [re-pressed.core :as rp])
  (:import [goog.events KeyCodes]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (rf/dispatch-sync [::events/initialize-db])
  (rf/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (rf/dispatch-sync [::rp/set-keydown-rules {:event-keys           [[[::events/next-slide]
                                                                     [{:which KeyCodes.RIGHT}]
                                                                     [{:which KeyCodes.SPACE}]]
                                                                    [[::events/previous-slide]
                                                                     [{:which KeyCodes.LEFT}]]]
                                             :prevent-default-keys [{:which KeyCodes.SPACE}]}])
  (dev-setup)
  (mount-root))
