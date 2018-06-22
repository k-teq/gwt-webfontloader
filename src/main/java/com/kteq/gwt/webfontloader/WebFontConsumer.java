package com.kteq.gwt.webfontloader;

import jsinterop.annotations.JsFunction;

/**
 * Created by mancini on 21/06/2018.
 */

@JsFunction
public interface WebFontConsumer<T> {
    public void apply(T t);
}
