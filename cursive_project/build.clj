(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib 'PlaygroundClojure/cursive_project)
(def version (format "2024.10.19"))
(def class-dir "target/classes")
(def jar-dir "target/jar_classes")
(def jar-file (format "target/%s-%s.jar" (name lib) version))
(def uber-file (format "target/%s-%s-standalone.jar" (name lib) version))

;; delay to defer side effects (artifact downloads)
(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn clean [_]
      (b/delete {:path "target"}))

(defn jar [_]
      (b/write-pom {:class-dir class-dir
                    :lib lib
                    :version version
                    :basis @basis
                    :src-dirs ["src"]})
      (b/copy-dir {:src-dirs ["src" "resources"]
                   :target-dir jar-dir})
      (b/jar {:class-dir jar-dir
              :jar-file jar-file}))

(defn uber [_]
      (clean nil)
      (b/copy-dir {:src-dirs ["src" "resources"]
                   :target-dir class-dir})
      (b/compile-clj {:basis @basis
                      :ns-compile '[cursive-project.core]
                      :class-dir class-dir})
      (b/uber {:class-dir class-dir
               :uber-file uber-file
               :basis @basis
               :main 'cursive-project.core}))
