## build.clj

look at build.clj example. simple function names, then
you can call them like `clj -T<:alias> <function name>`

so if build.clj has a fn called (defn foo [_] "bar")
and deps.edn had an alias :run-build
you would do `clj -T:run-build foo`
and it should work!

Sad to say, actually compiling in the functions is a
different story. 


## REPL
target top level namespace

you start in user, i dunno what that means
going to other namespaces does not seem good
instead require them
or rclick and load file into namespace

you can eval line as IN THE CODE EDITOR with the right hotkey
(go to rclick menu)
you can also CORRECTLY switch namespace using hotkey or menu
doing it in repl seems to go awry
