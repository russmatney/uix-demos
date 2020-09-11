(ns uix-demos.core
  (:require
   [uix-demos.app :as app]
   [uix.dom.alpha :as uix.dom]))

(defn start []
  (uix.dom/hydrate
    [app/view]
    (.getElementById js/document "app")))

(defn ^:export init []
  (println "init running")
  (start))
