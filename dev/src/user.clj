(ns user)

#_{:clj-kondo/ignore [:unresolved-namespace]}
(comment
  (do
    ((requiring-resolve 'tab.log/set-level!) :fine)

    (def tab
      ((requiring-resolve 'tab.api/run)
       :port 8080
       :browse? false
       :print-level 3
       :print-length 8)))

  ((requiring-resolve 'tab.api/halt) tab)

  (tap> (hukari.repl/runtime-stats))
  ,,,)

(defn check!
  ([] (check! nil))
  ([{:keys [path]}]
   (run! (requiring-resolve 'cognitect.transcriptor/run)
     ((requiring-resolve 'cognitect.transcriptor/repl-files) (format "repl/%s" path)))))

(comment
  (check! :path "test")
  (check! :path "spec")
  ,,,)

#_{:clj-kondo/ignore [:unresolved-namespace]}
(comment
  (tap> (sort-by :added #(compare %2 %1) (map meta (vals (ns-publics 'clojure.pprint)))))
  (/ 4 0)
  (tap> *e)
  (tap> java.net.ServerSocket)
  (tap> (java.time.ZonedDateTime/now))
  (tap> {:zoned-date-time (java.time.ZonedDateTime/now) :instant (java.time.Instant/now)})
  (tap> "foo")
  (tap> "bar")
  (tap> "baz")
  (tap> {:a 1})
  (tap> {:a 1 :b {:c 2} :d {:e 3}})
  (tap> {:a {:b {:c {:d 1}}}})
  (tap> {:a 1 :b {:c 2 :d {:e 3} :f {:g 4}}})
  (tap> {:a {:b {:c {:d 1} :e {:f 2} :g {:h 3}}}})
  (tap> {:a 1 :b {:c 2 :d {:e 3 :f 4} :g {:h 5 :f 6}}})
  (tap> [{:a 1} {:b 2}])
  (tap> [{:a 1 :b 2} {:a 3 :c 4}])
  (tap> [{:a 1} 3])
  (tap> #{1 2 3})
  (tap> (range 32))
  (tap> {:a (range 32) :b 1})
  (tap> {:foo (repeat 32 ["FOO" [{:bar 44.48} '(["BAZ" [{:quux 15.19}]])]])})
  (tap> #{{:a 1 :b 2 :c 3}})
  (tap> [[{:a 1 :b 2}] [{:a 3 :b 4}]])
  (tap> [[{:a 1} {:b 2}] [{:c 3} {:d 4}]])

  ;; Atom
  (def a (atom []))
  (tap> a)
  (swap! a conj 1)

  (tap> (sort-by :name (:members (clojure.reflect/reflect BigInteger))))
  (tap> java.util.concurrent.ArrayBlockingQueue)
  (tap> java.util.concurrent.BlockingQueue)
  (tap> (clojure.tools.analyzer.jvm/analyze '(map inc (range 10))))
  (tap> (clojure.tools.analyzer.jvm/analyze '(sequence (comp (filter odd?) (map inc) (partition-by even?)) (range 10))))
  (tap> (sort-by :added #(compare %2 %1) (map (comp #(dissoc % :doc) meta) (vals (ns-publics 'clojure.core)))))

  ;; This takes a while...
  (tap> (reverse (sort-by :added compare (map meta (vals (ns-publics 'clojure.core))))))

  (tap> (find-ns 'clojure.core))
  ,,,)