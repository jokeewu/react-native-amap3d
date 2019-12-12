package cn.qiuxiang.react.amap3d.maps

import cn.qiuxiang.react.amap3d.toLatLng
import cn.qiuxiang.react.amap3d.toPx
import com.amap.api.navi.model.NaviPoi
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@Suppress("unused")
internal class AMapPlanRouteManager : SimpleViewManager<AMapPlanRoute>() {
    override fun getName(): String {
        return "AMapPlanRoute"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): AMapPlanRoute {
        return AMapPlanRoute(reactContext)
    }

    override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any> {
        return mapOf("onPress" to mapOf("registrationName" to "onPress"))
    }

    @ReactProp(name = "startPoi")
    fun setStartPoi(route: AMapPlanRoute, poi: ReadableMap) {
        route.startPoi = NaviPoi(null, poi.toLatLng(), null)
    }

    @ReactProp(name = "endPoi")
    fun setEndPoi(route: AMapPlanRoute, poi: ReadableMap) {
        route.endPoi = NaviPoi(null, poi.toLatLng(), null)
    }

    @ReactProp(name = "colors")
    fun setColors(route: AMapPlanRoute, colors: ReadableArray) {
        route.colors = colors as Array<String>
    }

    @ReactProp(name = "strokeWidth")
    fun setStrokeWidth(route: AMapPlanRoute, strokeWidth: Float) {
        route.strokeWidth = strokeWidth.toPx().toFloat()
    }

    @ReactProp(name = "strategy")
    fun setStrategy(route: AMapPlanRoute, strategy: Int) {
        route.strategy = strategy
    }

    @ReactProp(name = "paddingTop")
    fun setDrawPaddingTop(route: AMapPlanRoute, paddingTop: Int) {
        route.drawPaddingTop = paddingTop
    }

    @ReactProp(name = "paddingRight")
    fun setDrawPaddingRight(route: AMapPlanRoute, paddingRight: Int) {
        route.drawPaddingRight = paddingRight
    }

    @ReactProp(name = "paddingBottom")
    fun setDrawPaddingBottom(route: AMapPlanRoute, paddingBottom: Int) {
        route.drawPaddingBottom = paddingBottom
    }

    @ReactProp(name = "paddingLeft")
    fun setDrawPaddingLeft(route: AMapPlanRoute, paddingLeft: Int) {
        route.drawPaddingLeft = paddingLeft
    }

    @ReactProp(name="showTrafficLights")
    fun setShowTrafficLights(route: AMapPlanRoute, showTrafficLights: Boolean) {
        route.showTrafficLights = showTrafficLights
    }

    @ReactProp(name="showTrafficStatus")
    fun setShowTrafficStatus(route: AMapPlanRoute, showTrafficStatus: Boolean) {
        route.showTrafficStatus = showTrafficStatus
    }
}
