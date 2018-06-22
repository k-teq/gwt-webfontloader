package com.kteq.gwt.webfontloader;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * Created by mancini on 20/06/2018.
 */
public class WebFontLoader {


    //js loading
    public interface Resources extends ClientBundle {
        Resources INSTANCE = GWT.create(Resources.class);

        @Source("webfontloader/webfontloader.js")
        TextResource webfontloaderjs();
    }

    private static boolean injected = false;

    private static void ensureInjected() {
        if (!injected) {
            injected = true;
            ScriptInjector.fromString(WebFontLoader.Resources.INSTANCE.webfontloaderjs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    public static final void load(WebFontOptions o) {
        //carica la libresia
        ensureInjected();
        Console.log(o);
        //libreira caricata, oravanno caricati i font.
        NativeWebFont.load(o);
    }

    //simplified version, does not try to actually load fonts but just watches
    //when loading is done; you should insert fonts in css(s)
    public static final void load(Collection<String> fontFaces, AsyncCallback<String> callback) {
        //carica la libresia
        ensureInjected();

        WebFontOptions o = new WebFontOptions();


        o.setLoadingCallback( e -> Console.log("webfont loading started"));
        o.setActiveCallback( e -> callback.onSuccess(fontFaces.stream().collect(Collectors.joining(","))));


        o.setInactiveCallback( e -> callback.onFailure( new Exception("error loading fonts: " +
                fontFaces.stream().collect(Collectors.joining(",")))));


        o.setFontLoadingCallback( e -> Console.log("Webfontloader processing '"+ e + "' started"));
        o.setFontActiveCallback( e -> Console.log("Success loading '"+ e + "'"));
        o.setFontInactiveCallback( e -> Console.log("Error loading '"+ e + "'"));

        CustomEntry ce = new CustomEntry();
        ce.families = fontFaces.toArray(new String[fontFaces.size()]);
        o.setCustom(ce);


        Console.log(o);

        //libreira caricata, oravanno caricati i font.
        NativeWebFont.load(o);
    }


    //simplified version, loads from fonts.ggoogle.com
    public static void loadGoogle(Set<String> fontFamilies, AsyncCallback<String>callback) {
        ensureInjected();

        WebFontOptions o = new WebFontOptions();


        o.setLoadingCallback( e -> Console.log("webfont loading started"));
        o.setActiveCallback( e -> callback.onSuccess(fontFamilies.stream().collect(Collectors.joining(","))));


        o.setInactiveCallback( e -> callback.onFailure( new Exception("error loading fonts: " +
                fontFamilies.stream().collect(Collectors.joining(",")))));


        o.setFontLoadingCallback( e -> Console.log("Webfontloader processing '"+ e + "' started"));
        o.setFontActiveCallback( e -> Console.log("Success loading '"+ e + "'"));
        o.setFontInactiveCallback( e -> Console.log("Error loading '"+ e + "'"));

        GoogleEntry ce = new GoogleEntry();
        ce.families = fontFamilies.toArray(new String[fontFamilies.size()]);
        o.setGoogle(ce);


        Console.log(o);

        //libreira caricata, oravanno caricati i font.
        NativeWebFont.load(o);
    }


}
