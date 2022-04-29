package com.kteq.gwt.webfontloader;


import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebFontOptions {

    @JsProperty
    public native CustomEntry getCustom();

    @JsProperty
    public native void setCustom(CustomEntry ce);

    @JsProperty
    public native GoogleEntry getGoogle();

    @JsProperty
    public native void setGoogle(GoogleEntry ce);

    @JsProperty
    public native void setClasses(boolean classes);

/*
    loading: function() {},
    active: function() {},
    inactive: function() {},
    fontloading: function(familyName, fvd) {},
    fontactive: function(familyName, fvd) {},
    fontinactive: function(familyName, fvd) {}
*/

    @JsProperty(name = "loading")
    public native void setLoadingCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "active")
    public native void setActiveCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "inactive")
    public native void setInactiveCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "fontloading")
    public native void setFontLoadingCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "fontactive")
    public native void setFontActiveCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "fontinactive")
    public native void setFontInactiveCallback(WebFontConsumer<Object> c);

    @JsProperty(name = "timeout")
    public native void setTimeout(int millis);


}
