package org.gradle.presentation.plugin

import org.gradle.api.Project

inline fun <reified T> Project.property() = objects.property(T::class.java)

inline fun <reified T> Project.convention(defaultValue: T) = objects.property(T::class.java).convention(defaultValue)