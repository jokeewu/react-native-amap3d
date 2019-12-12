package cn.qiuxiang.react.amap3d.maps

import android.content.Context
import android.util.Log
import com.amap.api.maps.AMap
import com.amap.api.navi.AMapNavi
import com.amap.api.navi.AMapNaviListener
import com.amap.api.navi.model.*
import com.amap.api.navi.view.RouteOverLay
import com.autonavi.tbt.TrafficFacilityInfo
import com.facebook.react.views.view.ReactViewGroup

class AMapPlanRoute(context: Context) : ReactViewGroup(context), AMapOverlay, AMapNaviListener {
    private var mapInstance : AMap? = null
    private val mAMapNavi = AMapNavi.getInstance(context.applicationContext)
    private var routeOverlay : RouteOverLay? = null

    var startPoi : NaviPoi? = null
    var endPoi : NaviPoi? = null
    var strategy : Int = 0
    var strokeWidth : Float = 20f
    var colors : Array<String>? = null
    var drawPaddingTop : Int = 10
    var drawPaddingRight : Int = 10
    var drawPaddingBottom : Int = 10
    var drawPaddingLeft : Int = 10
    var showTrafficLights : Boolean = false
    var showTrafficStatus : Boolean = false

    private fun planRoute() {
        if (null != startPoi && null != endPoi) {
            routeOverlay?.removeFromMap()
            routeOverlay?.destroy()
            routeOverlay = null
            mAMapNavi?.calculateDriveRoute(startPoi, endPoi, null, strategy)
        }
    }

    override fun add(map: AMap) {
        mapInstance = map
        mAMapNavi.addAMapNaviListener(this)
        planRoute()
    }

    override fun remove() {
        routeOverlay?.removeFromMap()
        routeOverlay?.destroy()
        mAMapNavi?.removeAMapNaviListener(this)
        mAMapNavi?.releaseLocManager()
        mAMapNavi?.destroy()
    }

    // 初始化导航成功
    // 路径规划
    override fun onInitNaviSuccess() {
        planRoute()
    }

    // 路径规划成功
    override fun onCalculateRouteSuccess(res: AMapCalcRouteResult) {
        // 绘制到地图上
        routeOverlay = RouteOverLay(mapInstance, mAMapNavi.naviPath, context)

        // 交通线路
        routeOverlay?.isTrafficLine = showTrafficStatus

        // 隐藏起始点Marker
        routeOverlay?.setStartPointBitmap(null)
        routeOverlay?.setEndPointBitmap(null)

        // 添加到地图
        routeOverlay?.addToMap()
        // 清除交通灯
        if (!showTrafficLights) {
            routeOverlay?.clearTrafficLights()
        }
        // 将地图zoom到可以全览全路段的级别
        routeOverlay?.zoomToSpan(drawPaddingLeft, drawPaddingRight, drawPaddingTop, drawPaddingBottom, mAMapNavi?.naviPath)
    }

    override fun onInitNaviFailure() {}

    override fun onStartNavi(var1: Int) {}

    override fun onTrafficStatusUpdate() {}

    override fun onLocationChange(var1: AMapNaviLocation) {}

    @Deprecated("")
    override fun onGetNavigationText(var1: Int, var2: String) {}

    override fun onGetNavigationText(var1: String) {}

    override fun onEndEmulatorNavi() {}

    override fun onArriveDestination() {}

    @Deprecated("")
    override fun onCalculateRouteFailure(var1: Int) {}

    @Deprecated("")
    override fun onReCalculateRouteForYaw() {}

    @Deprecated("")
    override fun onReCalculateRouteForTrafficJam() {}

    override fun onArrivedWayPoint(var1: Int) {}

    override fun onGpsOpenStatus(var1: Boolean) {}

    override fun onNaviInfoUpdate(var1: NaviInfo) {}

    @Deprecated("")
    override fun onNaviInfoUpdated(var1: AMapNaviInfo) {}

    override fun updateCameraInfo(var1: Array<AMapNaviCameraInfo>) {}

    override fun updateIntervalCameraInfo(var1: AMapNaviCameraInfo, var2: AMapNaviCameraInfo, var3: Int) {}

    override fun onServiceAreaUpdate(var1: Array<AMapServiceAreaInfo>) {}

    override fun showCross(var1: AMapNaviCross) {}

    override fun hideCross() {}

    override fun showModeCross(var1: AMapModelCross) {}

    override fun hideModeCross() {}

    @Deprecated("")
    override fun showLaneInfo(var1: Array<AMapLaneInfo>, var2: ByteArray, var3: ByteArray) {}

    override fun showLaneInfo(var1: AMapLaneInfo) {}

    override fun hideLaneInfo() {}

    @Deprecated("")
    override fun onCalculateRouteSuccess(var1: IntArray) {}

    @Deprecated("")
    override fun notifyParallelRoad(var1: Int) {}

    @Deprecated("")
    override fun OnUpdateTrafficFacility(var1: Array<AMapNaviTrafficFacilityInfo>) {}

    @Deprecated("")
    override fun OnUpdateTrafficFacility(var1: AMapNaviTrafficFacilityInfo) {}

    @Deprecated("")
    override fun OnUpdateTrafficFacility(var1: TrafficFacilityInfo) {}

    @Deprecated("")
    override fun updateAimlessModeStatistics(var1: AimLessModeStat) {}

    @Deprecated("")
    override fun updateAimlessModeCongestionInfo(var1: AimLessModeCongestionInfo) {}

    override fun onPlayRing(var1: Int) {}

    override fun onCalculateRouteFailure(var1: AMapCalcRouteResult) {}

    override fun onNaviRouteNotify(var1: AMapNaviRouteNotifyData) {}
}
