import React, { Component } from 'react'
import { StyleSheet, View, NativeModules } from 'react-native'
import { MapView, PlanRoute, Marker } from 'react-native-amap3d'

const { AMapNavi } = NativeModules

export default class PlanRouteExample extends Component {
  static navigationOptions = {
    title: '路径导航',
  }

  constructor(props) {
    super(props)
    this.mapRef = React.createRef()
    this.planRouteRef = React.createRef()
  }

  componentDidMount() {
    console.log(AMapNavi)
  }

  componentWillUnmount() {
    AMapNavi.stop()
  }

  onPlanSuccess = () => {
    console.log('路径规划成功')
    AMapNavi.start()
  }

  onPlanFailed = () => {
    console.warn('路径规划失败')
  }

  render() {
    return (
      <MapView
        locationType="map_rotate"
        locationEnabled={true}
        style={StyleSheet.absoluteFill}
      >
        <Marker
          coordinate={{
            longitude: 104.066937,
            latitude: 30.517895
          }}
        />
        <Marker
          coordinate={{
            longitude: 104.068567,
            latitude: 30.55545
          }}
        />
        <PlanRoute
          ref={this.planRouteRef}
          startPoi={{
            longitude: 104.066937,
            latitude: 30.517895
          }}
          endPoi={{
            longitude: 104.068567,
            latitude: 30.55545
          }}
          showTrafficLights={false}
          paddingTop={100}
          paddingBottom={400}
          onPlanSuccess={this.onPlanSuccess}
          onPlanFailed={this.onPlanFailed}
        />
      </MapView>
    )
  }
}
