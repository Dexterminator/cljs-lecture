(ns cljs-lecture.subs
  (:require
    [re-frame.core :as rf]))

(rf/reg-sub
  ::slide-index
  (fn [db]
    (:slide-index db)))

(rf/reg-sub
  ::text
  (fn [db]
    (:text db)))

(rf/reg-sub
  ::top-common-letters
  :<- [::text]
  (fn [text]
    (->> text
         (frequencies)
         (sort-by val >)
         (take 3))))
