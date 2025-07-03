/*
    Copied from https://github.com/GenKt/mcp-sdk
 */
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(libs.kotlinx.coroutine.core)
    implementation(libs.kotlinx.serialization.msgpack)
}

kotlin {
    explicitApi()
    jvmToolchain(8)
}