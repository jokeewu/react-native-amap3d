import React, { Component } from 'react'
import { Alert, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { MapView } from 'react-native-amap3d'

export default class PlanRouteExample extends Component {
  static navigationOptions = {
    title: '路径规划',
  }

  constructor(props) {
    super(props)
    this.mapRef = React.createRef()
  }

  componentDidMount() {
    this.mapRef.current.planRoute({
      startPoi: {
        longitude: 104.066937,
        latitude: 30.517895
      },
      endPoi: {
        longitude: 104.068567,
        latitude: 30.55545
      },
      strategy: 0,
    })
  }

  render() {
    return (
      <MapView
        style={StyleSheet.absoluteFill}
        ref={this.mapRef}
      />
    )
  }
}
