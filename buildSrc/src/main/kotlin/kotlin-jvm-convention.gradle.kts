/*
    Copied from https://github.com/GenKt/mcp-sdk
 */
plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    explicitApi()
    jvmToolchain(8)
}