/**
 * 导航组件
 *    依托于PlanRoute
 */
import React, { PureComponent } from "react";
import PropTypes from "prop-types";
import { requireNativeComponent, ViewPropTypes } from "react-native";

export default class Navi extends PureComponent {
  render() {
  }
}

const AMapNavi = requireNativeComponent("AMapNavi", Navi);