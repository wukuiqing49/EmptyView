# EmptyView

简介

页面展示空布局,增加自定义设置错误信息,错误图片,按钮点击展示重连操作

引用
```

implementation 'com.github.wukuiqing49:EmptyView:2.0.1'

```



配置

```

allprojects {
buildscript {
    ext.kotlin_version = "1.4.32"
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.1.3"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
