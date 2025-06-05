/*
    Copied from https://github.com/GenKt/mcp-sdk
 */
@file:OptIn(ExperimentalWasmDsl::class)

import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.mpp.*

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    explicitApi()

    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget = JvmTarget.JVM_1_8
            freeCompilerArgs.addAll("-Xjvm-default=all-compatibility")
        }
    }
    jvmToolchain(8)

//    js {
//        nodejs {
//            testTask {
//                useMocha {
//                    timeout = "10s"
//                }
//            }
//        }
//
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        compilerOptions {
//            sourceMap = true
//            moduleKind = JsModuleKind.MODULE_ES
//        }
//    }
//
//    wasmJs {
//        nodejs()
//    }
//
//    linuxArm64()
//    macosX64()
//    macosArm64()
//    iosSimulatorArm64()
//    iosX64()
//
//    // Tier 2
//    linuxX64()
//    linuxArm64()
//    watchosSimulatorArm64()
//    watchosX64()
//    watchosArm32()
//    watchosArm64()
//    tvosSimulatorArm64()
//    tvosX64()
//    tvosArm64()
//    iosArm64()
//
//    // Tier 3
//    mingwX64()
//    watchosDeviceArm64()
//    androidNativeArm32()
//    androidNativeArm64()
//    androidNativeX86()
//    androidNativeX64()
//
//    // setup tests running in RELEASE mode
//    targets.withType<KotlinNativeTarget>().configureEach {
//        binaries.test(listOf(NativeBuildType.RELEASE))
//    }
//    targets.withType<KotlinNativeTargetWithTests<*>>().configureEach {
//        testRuns.create("releaseTest") {
//            setExecutionSourceFrom(binaries.getTest(NativeBuildType.RELEASE))
//        }
//    }
}