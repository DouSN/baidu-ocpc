package com.dou.ocpc;

import com.baidu.mobads.action.ActionParam;
import com.baidu.mobads.action.ActionType;
import com.baidu.mobads.action.BaiduAction;
import com.bun.miitmdid.core.JLibrary;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import org.json.JSONException;
import org.json.JSONObject;

public class BaiduocpcModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public BaiduocpcModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Baiduocpc";
    }

    @ReactMethod
    public void init(long setId, String appKey) {
        // TODO: Implement some actually useful functionality
//        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
        JLibrary.InitEntry(reactContext);
        BaiduAction.init(reactContext, setId, appKey);
        BaiduAction.setActivateInterval(reactContext, 7);
    }

    @ReactMethod
    public void logRegister() {
        BaiduAction.logAction(ActionType.REGISTER);
    }

    @ReactMethod
    public void logPurchase(int money) {
        JSONObject actionParam = new JSONObject();
        try {
            actionParam.put(ActionParam.Key.PURCHASE_MONEY, money);
            BaiduAction.logAction(ActionType.REGISTER, actionParam);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
