
(ns jcrit.views.herd-changes
  (:require [noir.content.pages :as pages]
            [net.cgrand.enlive-html :as html])
  (:use noir.core
        clojure.pprint
        [jcrit.views.layout :only [layout]]))

;; This function is slightly different than the one used in the tutorial.
(defn- wrap-name-transformation [index base-name]
  (html/set-attr :name (cl-format nil "animal~A[~A]" index base-name)))

(html/defsnippet herd-with-size
  "jcrit/views/herd_changes.html" [:form]
  [number-of-animals]

  [:tr.per_animal_row]
  (html/clone-for [i (range number-of-animals)]
    [:input.true_name]
    (wrap-name-transformation i "true_name")

    [:select.species]
    (wrap-name-transformation i "species")

    [:input.extra_display_info]
    (wrap-name-transformation i "extra_display_info")))


(defpage "/herd_changes/new" []
  (layout (herd-with-size 12)
          "$('input.true_name').first().focus();"
          "$('select.species').change(C4.util.column_propagator('select.species'));"
          "$('input.extra_display_info').change(C4.util.column_propagator('input.extra_display_info'));"
          ))

(defpage [:post "/herd_changes"] args
  (pprint args)
  (pr-str args))
