(ns cljs-lecture.slides)

(def slides
  [
   "
   # ClojureScript
   ![cljs-logo](images/cljs-logo.png)
   "

   "
   # Agenda
   - Who are we?
   - Why this is the best course ever
   - ClojureScript
   - Reagent
   - re-frame
   "

   "
   # ClojureScript
   - Compiles to JavaScript
   - Most of Clojure
     - Persistent collections, sequence fns, etc
   - Some differences, i.e cljs number is just JS number
   "

   "
   # ClojureScript
   - Google closure compiler
   - Seamless interop with JS (though dependencies are a bit tricky at times)
   ```clojure
   (.log js/console \"hello\")
   ```
   "

   "
   # Hiccup
   - Express html using Clojure data structures
   - All seq fns available to manipulate/generate hiccup!
   ```clojure
   [:div.example-class
     [:h1 \"Hello world\"]
     [:button {:on-click #(js/alert \"Clicked!\")}]]

   (interpose [:span.icon \" ▶ \"] links)
   ```
   "

   "
   # Figwheel
   - Reloadable code
   - Change hiccup/css/other logic
     - Automatically reloads
     - Without having to recreate state
   - Heads up display of compile errors
   "

   "
   # Figwheel
   ![figwheel](images/figwheel-errors.png)
   "

   "
   # Reagent ![reagent-logo](images/reagent-logo.png)
   - React wrapper for cljs
   - Uses hiccup
   - Components are just Clojure functions!
   - Like React, rerender component when input changes
   ```clojure
   (defn hello-component [name]
     [:div
       [:h1 \"Welcome\"]
       [:p \"Hello, \" name \"!\"]])
   ```
   "

   "
   # Reagent
   - Can use \"ratoms\" to rerender
   ```clojure
   (def click-count (reagent/atom 0))

   (defn counting-component []
     [:div
       \"Clicks: \" @click-count
       [:input {:type \"button\"
                :value \"Click me!\"
                :on-click #(swap! click-count inc)}]])
   ```
   "

   "
   # Side note: Performance
   - Intuitively, should be slower
     - Another layer on top of JS, functional
     - However:
       - Very thin layer on top of JS (e.g cljs functions are just js functions)
       - In practice often faster for React apps!
   "

   "
   # re-frame
   - Framework built on top of Reagent
   - Similar to Redux in js
   - Centralized state, \"app-db\"
   - Events + event handlers
   - Effects
   - Subscriptions
   "

   "
   # Events and event handlers
   ```clojure
   [:button-clicked some-parameter]

   (reg-event-fx :button-clicked handler-fn)
   ```
   "

   "
   # Effects
   - Returned by the handler as a map
   - Most common effect: `:db`
   - Others: local store, api calls etc
   - Effect handler
     - Performs the actual side effect
     - e.g Updates the app-db
   "

   "
   # Subscriptions
   - Query the app db
   - View can `subscribe`
   - re-render as subscription value changes
   ```clojure
   (reg-sub
     :my-subscription
     (fn [db] (:some-key db))

   (subscribe [:my-subscription])
   ```
   "

   "
   # re-frame flow
   ![dominoes](images/re-frame-dominoes.png)
   "

   "
   # Example
   "

   "
   # Thank you!

   "
   ])
