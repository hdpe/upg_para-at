## Parallel Acceptance Tests demo for UPG

This project demonstrates design of acceptance tests for parallelisation, using JBehave and Spring.

The `para_at-at` project achieves this through use of `ThreadLocal` variables in the `Universe`, in order to only store, track references to and clean up entities created via the current thread. A `ThreadLocal`-less, arguably better solution may be to configure JBehave to create a new Spring `ApplicationContext` for each thread.

1. Run the web application `com.upgplc.para_at.web.Application` in the `para_at-web` module
2. Run the JBehave tests via the JUnit runner `com.upgplc.para_at.at.Runner` in the `para_at-at` module

The current configuration runs the three story files in parallel with a separate thread for each.
