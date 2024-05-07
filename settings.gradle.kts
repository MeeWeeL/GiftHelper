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
include(":app-main:app")
include(":app-admin:app")
include(":core:ui-base")
include(":core:ui-components")
include(":core:base")
include(":core:navigation")
include(":core:common")
include(":app-main:domain:api")
include(":app-main:domain:impl")
include(":app-main:domain:models")
include(":app-main:data:api")
include(":app-main:data:impl")
include(":app-main:features:search")
include(":app-main:features:menu")
include(":app-main:features:offer-new-gift")
include(":app-admin:features:menu")
include(":app-admin:features:search")
include(":app-admin:domain:api")
include(":app-admin:domain:impl")
include(":app-admin:domain:models")
include(":app-admin:data:api")
include(":app-admin:data:impl")
include(":app-admin:core:navigation")
