package cn.qiuxiang.react.amap3d.maps

import android.content.Context
import android.util.Log
import com.amap.api.navi.view.RouteOverLay
import com.amap.api.navi.AMapNavi
import com.amap.api.navi.AMapNaviListener
import com.amap.api.navi.AMapNaviView
import com.amap.api.navi.model.*
import com.autonavi.tbt.TrafficFacilityInfo
import java.util.logging.Logger

class NaviListener(context: Context, aMapView: AMapView, mAMapNavi: AMapNavi) : AMapNaviListener {
    private val context = context
    private val aMapView = aMapView
    private val mAMapNavi = mAMapNavi

    override fun onInitNaviFailure() {}

    override fun onInitNaviSuccess() {}

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

    override fun onCalculateRouteSuccess(var1: AMapCalcRouteResult) {
        // 绘制到地图上
        var routeOverlay = RouteOverLay(aMapView.map, mAMapNavi.naviPath, context)
        routeOverlay.addToMap()
    }

    override fun onCalculateRouteFailure(var1: AMapCalcRouteResult) {
        Log.d("onCalculateRouteFailure", var1.toString())
    }

    override fun onNaviRouteNotify(var1: AMapNaviRouteNotifyData) {}
}