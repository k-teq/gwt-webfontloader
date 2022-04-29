package com.kteq.gwt.webfontloader;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="console")
public abstract class Console {

	private Console() {};
	public static native void log(Object o);
	public static native void log(Object o1, Object o2);
	public static native void log(Object o1, Object o2, Object o3);
	public static native void log(Object o1, Object o2, Object o3, Object o4);

}
