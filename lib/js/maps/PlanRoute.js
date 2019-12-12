/**
 * 路径规划
 */
import React from "react";
import PropTypes from "prop-types";
import { requireNativeComponent, ViewPropTypes } from "react-native";
import Component from '../Component'

const Point = PropTypes.shape({
  longitude: PropTypes.number,
  latitude: PropTypes.number
});

export default class PlanRoute extends Component {
  static propTypes = {
    ...ViewPropTypes,

    // 路径规划起点
    startPoi: Point,

    // 路径规划终点
    endPoi: Point,

    // 路径规划策略
    strategy: PropTypes.number,

    // 线条粗细
    strokeWidth: PropTypes.number,

    // 路径上路况对应颜色
    colors: PropTypes.arrayOf(function(propValue, key, componentName, location, propFullName) {
      if (!/^#[\da-f]{6}$/i.test(propValue[key])) {
        return new Error(
          'Invalid prop `' + propFullName + '` supplied to' +
          ' `' + componentName + '`. Validation failed.'
        );
      }
    }),

    // 距离地图边距
    paddingTop: PropTypes.number,
    paddingRight: PropTypes.number,
    paddingBottom: PropTypes.number,
    paddingLeft: PropTypes.number,

    // 是否显示交通灯
    showTrafficLights: PropTypes.bool,

    // 是否显示路况
    showTrafficStatus: PropTypes.bool,

    // 规划成功
    onPlanSuccess: PropTypes.func,

    // 规划失败
    onPlanFailed: PropTypes.func,
  }

  static defaultProps = {
    strategy: 0,
    strokeWidth: 20,
    paddingTop: 10,
    paddingRight: 10,
    paddingBottom: 10,
    paddingLeft: 10,
    showTrafficLights: false,
    showTrafficStatus: true
  }

  name = "AMapPlanRoute";

  /**
   * 将路线全部显示在可视区域
   */
  zoomToSpan() {
    this.sendCommand('zoomToSpan')
  }

  render() {
    return <AMapPlanRoute {...this.props} />
  }
}

const AMapPlanRoute = requireNativeComponent("AMapPlanRoute", PlanRoute);