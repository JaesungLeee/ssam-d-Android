package com.mashup.ssamd

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.mashup.ssamd.util.CustomTimberDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Ssam_D_Android
 * @author jaesung
 * @created 2023/05/13
 */
@HiltAndroidApp
class SsamDApplication : Application() {

    @Inject
    lateinit var customTimberTree: CustomTimberDebugTree

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(customTimberTree)
        }

        val keyHash = Utility.getKeyHash(this)
        KakaoSdk.init(this, keyHash)
    }
}
