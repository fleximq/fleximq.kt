dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

rootProject.name = "fleximq.kt"

fun flexiMQModules(vararg modules: String) {
    for (module in modules) {
        include(":fleximq-$module")
        project(":fleximq-$module").projectDir = file(module)
    }
}

flexiMQModules(
    "transport"
)