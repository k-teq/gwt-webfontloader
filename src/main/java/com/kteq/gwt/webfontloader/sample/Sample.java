package com.kteq.gwt.webfontloader.sample;

import java.util.Collections;
import java.util.function.Consumer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.kteq.gwt.webfontloader.Console;
import com.kteq.gwt.webfontloader.CustomEntry;
import com.kteq.gwt.webfontloader.WebFontLoader;
import com.kteq.gwt.webfontloader.WebFontOptions;

public class Sample implements EntryPoint {


    @Override
    public void onModuleLoad() {


//		GoogleEntry ge = new GoogleEntry();
//		ge.families = new String[]{"Roboto","Droid Sans"};
//		o.setGoogle(ge);


//
//        WebFontLoader.loadGoogle(Collections.singleton("Roboto"), new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                Window.alert("Google problem loading fonts");
//            }
//
//            @Override
//            public void onSuccess(String s) {
//                RootPanel.get().add(new HTML("Google FONTS LOADED: " + s));
//            }
//        });
//


//
//        WebFontLoader.load(Collections.singleton("xxx"), new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                Window.alert("problem loading fonts");
//            }
//
//            @Override
//            public void onSuccess(String s) {
//                Window.alert("FONTS LOADED: " + s);
//            }
//        });


        loadAbsolutely("fortuneregular", "./fortune-webfont.css", 5, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                Console.log("FAILED: ", caught);
            }

            @Override
            public void onSuccess(String result) {
                Window.alert("ANDATA !!!");
            }
        }, false);


        HTML html = new HTML("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.");

        html.getElement().getStyle().setProperty("fontFamily","fortuneregular");

        RootPanel.get().add( html );

    }


    public void loadAbsolutely(String fontFamily, String fontUrl, int maxRetries, AsyncCallback<String> endCallback, boolean tryAvoidCache) {

        WebFontOptions options = new WebFontOptions();
        CustomEntry ce = new CustomEntry();
        ce.families = new String[]{fontFamily};
        ce.urls = new String[]{fontUrl};
        options.setCustom(ce);
        options.setClasses(false);


        options.setFontActiveCallback((o) -> {
            Console.log("Active", o);
            endCallback.onSuccess((String) o);
        });

        options.setFontLoadingCallback((o) -> Console.log("Loading", o));

        _loadAbsolutely(options, maxRetries, endCallback, tryAvoidCache);
    }

    private void _loadAbsolutely(WebFontOptions options, int maxRetries, AsyncCallback<String> endCallback, boolean tryAvoidCache) {

        if (maxRetries > 0)
            options.setFontInactiveCallback(
                    (o) -> {
                        Console.log("Inactive", maxRetries, o);
                        _loadAbsolutely(options, maxRetries - 1, endCallback, tryAvoidCache);
                    });
        else
            options.setFontInactiveCallback(
                    (o) -> {
                        Console.log("Inactive, failed", maxRetries, o);
                        endCallback.onFailure(new Throwable("Unable to load font"));
                    });
        WebFontLoader.load(options);

//	    , new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                Console.log("retries", maxRetries, throwable);
//                if(maxRetries > 0)
//                    _loadAbsolutely(options,maxRetries-1,endCallback, tryAvoidCache);
//                else
//                    endCallback.onFailure(throwable);
//            }
//
//            @Override
//            public void onSuccess(String s) {
//                Console.log("font loaded", s);
//                endCallback.onSuccess(s);
//            }
//        });
    }


}
