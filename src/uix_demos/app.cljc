(ns uix-demos.app
  (:require
   [uix.core.alpha :as uix :refer [with-effect]]))

(defn clock []
  (let [d (uix/state (js/Date))]
    (with-effect []
      (println :with-effecting!)
      (let [interval (js/setInterval
                       (fn []
                         (let [new-d (js/Date)]
                           (println :interval-called new-d)
                           (reset! d new-d))
                         )
                       3000)]
        (fn []
          (println :cleaning-up)
          (js/clearInterval interval)
          )))

    [:div (str @d)]))


(defn view []
  [:div
   "fancy clock, sir!"

   [clock]])
