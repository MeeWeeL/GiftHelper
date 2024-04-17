pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GiftHelper"
include(":main-app:app")
include(":core:ui-base")
include(":core:ui-components")
include(":core:base")
include(":core:navigation")
include(":core:common")
include(":domain:api")
include(":domain:impl")
include(":domain:models")
include(":data:api")
include(":data:impl")
include(":features:search")
include(":features:menu")
include(":features:offer-new-gift")
