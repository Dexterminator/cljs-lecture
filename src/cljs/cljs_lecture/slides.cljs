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
   - Course takeaways
   - ClojureScript
   - Reagent
   - re-frame
   "

   "
   # Who are we?
   - MSc in Computer Science graduates at KTH
   - Software Engineers at TriOptima
   "

   "
   # Course takeaways
   - Fun and modern
   - Used to be Java or Clojure
   - This is how it's done (almost)
     - The future is unknown
     - Demands change
     - Focus on writing good code
   "

   "
   # ClojureScript
   - Compiles to JavaScript
   - Includes most of Clojure (`clojure.core` etc.)
     - Persistent collections, sequence fns, etc
   - Some differences, i.e cljs number is just js number
   "

   "
   # ClojureScript
   - Google closure compiler
   - Seamless interop with js (though dependencies are a bit tricky at times)
   ```clojure
   (.log js/console \"hello\")
   ```
   "

   "
   # Code sharing
   - Code without interop is often identical in clj and cljs
   - `.cljc`
   - Example: validation logic
   "

   "
   # Hiccup
   - Express html using Clojure data structures
   - All seq fns available to manipulate/generate hiccup
   ```clojure
   [:div.example-class
     [:h1 \"Hello world\"]
     [:button {:on-click #(js/alert \"Clicked!\")}]]

   (interpose [:span.icon \" ▶ \"] links)
   ```
   "

   "
   # Figwheel
   - Change hiccup/css/other logic
     - Automatically reloads
     - Without having to recreate state
   - Encourages writing \"reloadable\" code
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
   - Components are just Clojure functions
   - Like React, rerender component when input changes
   ```clojure
   (defn hello-component [name]
     [:div
       [:h1 \"Welcome\"]
       [:p \"Hello, \" name \"!\"]])
   ```
   "

   "
   # Reagent ![reagent-logo](images/reagent-logo.png)
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
   # Performance
   - Intuitively, should be slower than js
     - Another layer on top of js, functional
     - However:
       - Very thin layer on top of js (e.g cljs functions are just js functions)
       - In practice often faster for React apps!
   "

   "
   # re-frame ![re-frame-logo](images/re-frame-logo.png)
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
   - Can subscribe to other subscriptions
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
   # re-frame-10x
   - Tools similar to Redux devtools
   - See current app-db, events etc
   "

   "
   # Example
   "

   "
   # Thank you!
   - [https://clojurescript.org/](https://clojurescript.org/)
   - [https://reagent-project.github.io/](https://reagent-project.github.io/)
   - [https://github.com/Day8/re-frame](https://github.com/Day8/re-frame)
   "
   ])
