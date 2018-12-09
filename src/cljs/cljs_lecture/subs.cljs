(ns cljs-lecture.subs
  (:require
    [re-frame.core :as rf]))

(rf/reg-sub
  ::slide-index
  (fn [db]
    (:slide-index db)))
