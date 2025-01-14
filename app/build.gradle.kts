import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.apollographql.apollo3") version "4.0.0-beta.7"
}

apollo {
    service("service") {
        packageName.set("com.example")
    }
}


android {
    namespace = "com.example.socialnetwork"
    compileSdk = 34

    val appProperties = Properties().apply {
        load(project.rootProject.file("app.properties").inputStream())
    }

    defaultConfig {
        applicationId = "com.example.socialnetwork"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField(
            "String",
            "BASE_URL_API",
            appProperties.getProperty("BASE_URL_API")?.trim().toString()
        )

        buildConfigField(
            "String",
            "BASE_URL_GRAPHQL",
            appProperties.getProperty("BASE_URL_GRAPHQL")?.trim().toString()
        )

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        create("customDebugType") {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //navigation
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")


    //dagger hilt
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("com.google.dagger:hilt-android:2.46.1")
    kapt("com.google.dagger:hilt-compiler:2.46.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.work:work-runtime-ktx:2.8.0")

    //icon
    val compose_version = "1.6.7"
    implementation("androidx.compose.material:material-icons-extended:$compose_version")


    //retrofit
    val retrofit_version = "2.11.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")


    //lifecycle
    val lifecycle_version = "2.6.2"
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")


    //preference
    val preference_version = "1.2.1"
    implementation("androidx.preference:preference-ktx:$preference_version")
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    //interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

    //async image
    implementation("io.coil-kt:coil-compose:2.6.0")

    //compose  (for refresh indicator)
    implementation("androidx.compose.material:material:1.6.8")

    //apollo graphql
    implementation("com.apollographql.apollo3:apollo-runtime:4.0.0-beta.7")

}

kapt {
    correctErrorTypes = true
}