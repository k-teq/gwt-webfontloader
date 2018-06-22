package com.kteq.gwt.webfontloader.sample;

import java.util.Collections;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.kteq.gwt.webfontloader.WebFontLoader;

public class Sample implements EntryPoint {



	@Override
	public void onModuleLoad() {


//		GoogleEntry ge = new GoogleEntry();
//		ge.families = new String[]{"Roboto","Droid Sans"};
//		o.setGoogle(ge);



        WebFontLoader.loadGoogle(Collections.singleton("Roboto"), new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Google problem loading fonts");
            }

            @Override
            public void onSuccess(String s) {
                RootPanel.get().add(new HTML("Google FONTS LOADED: " + s));
            }
        });

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


	}





}
