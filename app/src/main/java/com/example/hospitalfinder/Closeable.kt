package com.example.hospitalfinder

import java.io.Closeable

// Executes the given [block] function on this resource and then closes it down correctly whether an exception is thrown or not.
//@param block a function to process this [Closeable] resource.
//@return the result of [block] function invoked on this resource.

//@InlineOnly
//@RequireKotlin(version:"1.2", versionKind = RequireKotlinVersionKind.COMPILER_VERSION, message="Required")
public inline fun<T : Closeable?, R> T.use(block: (T) -> R):R{
    var exception: Throwable? = null
    try{
        return block(this)
    } catch (e:Throwable){
        exception = e
        throw e
    } finally {
        val minor = 1
        when {
            //apiVersionIsAtLeast(major:1, minor:1, patch:0) -> this.closeFinally(exception)
            this == null -> {}
            exception == null -> close()
            else->
                try{
                    close()
                } catch (closeException: Throwable){
                    // cause.addSuppressed(closeException) // ignored here
                }
        }
    }
}