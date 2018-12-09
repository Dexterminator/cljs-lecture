(ns cljs-lecture.events
  (:require
    [re-frame.core :as rf]
    [cljs-lecture.db :as db]
    [cljs-lecture.slides :refer [slides]]
    [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

(rf/reg-event-fx
  ::initialize-db
  (fn-traced [_ _]
    {:db db/default-db}))

(rf/reg-event-fx
  ::next-slide
  (fn-traced [{:keys [db]} _]
    {:db (update db :slide-index #(min (dec (count slides)) (inc %)))}))

(rf/reg-event-fx
  ::previous-slide
  (fn-traced [{:keys [db]} _]
    {:db (update db :slide-index #(max 0 (dec %)))}))
