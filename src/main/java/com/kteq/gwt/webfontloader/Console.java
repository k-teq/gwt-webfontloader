package com.kteq.gwt.webfontloader;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="console")
public abstract class Console {

	private Console() {};
	public static native void log(Object ms);

}
