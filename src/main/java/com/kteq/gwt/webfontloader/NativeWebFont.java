package com.kteq.gwt.webfontloader;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "WebFont")
class NativeWebFont {
    public static native void load(WebFontOptions o);
}