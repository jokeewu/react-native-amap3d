package cn.qiuxiang.react.amap3d

import com.amap.api.navi.AMapNavi
import com.amap.api.navi.enums.NaviType
import com.facebook.react.bridge.*

@Suppress("unused")
class AMapNaviModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private var mAMapNavi : AMapNavi? = null

    override fun getName(): String {
        return "AMapNavi"
    }

    @ReactMethod
    fun start() {
        mAMapNavi = AMapNavi.getInstance(reactContext.applicationContext)
        mAMapNavi?.setUseInnerVoice(true)
        mAMapNavi?.startGPS()
        mAMapNavi?.startNavi(NaviType.GPS)
    }

    @ReactMethod
    fun stop() {
        mAMapNavi?.stopNavi()
    }
}