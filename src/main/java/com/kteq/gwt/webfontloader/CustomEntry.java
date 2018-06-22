package com.kteq.gwt.webfontloader;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Created by mancini on 21/06/2018.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CustomEntry {
    public String families[];
    String urls[];
}
