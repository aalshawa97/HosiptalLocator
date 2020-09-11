package com.example.hospitalfinder.ui

annotation class ImALocation

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImALocation class Plant {
    @get:OnGet
    val isLocation: Boolean = true

    @set:OnSet
    var needsLocation: Boolean = false
}