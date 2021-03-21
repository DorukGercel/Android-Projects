package com.londonappbrewery.bitcointicker;

import org.json.JSONException;
import org.json.JSONObject;

public class BitcoinDataModel {

    private double lastCurrency;

    public static BitcoinDataModel fromJson(JSONObject jsonObject){
        BitcoinDataModel bitcoinData = new BitcoinDataModel();
        try {
            bitcoinData.lastCurrency = (double) jsonObject.get("last");
            return bitcoinData;
        }
        catch (JSONException exception){
            bitcoinData.lastCurrency = -1;
            return bitcoinData;
        }
    }

    public double getLastCurrency() {
        return lastCurrency;
    }
}
