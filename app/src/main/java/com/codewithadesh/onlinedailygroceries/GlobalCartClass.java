package com.codewithadesh.onlinedailygroceries;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class GlobalCartClass extends Application {
    Map<String,Integer> cartMap=new HashMap<>();

    public Map<String, Integer> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<String, Integer> cartMap) {
        this.cartMap = cartMap;
    }
}
