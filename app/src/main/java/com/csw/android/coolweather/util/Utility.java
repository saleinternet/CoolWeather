package com.csw.android.coolweather.util;

import android.text.TextUtils;

import com.csw.android.coolweather.db.CoolWeatherDB;
import com.csw.android.coolweather.model.City;
import com.csw.android.coolweather.model.County;
import com.csw.android.coolweather.model.Province;

/**
 * 数据解析工具类
 * Created by chensiwen on 15/8/5.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * */
    public synchronized static boolean handleProvincesResponse(
            CoolWeatherDB coolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //  将解析的数据存储到Province表中
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * */
    public static boolean handleCitiesResponse(
            CoolWeatherDB coolWeatherDB, String response, int proviceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(proviceId);
                    //  将解析处理的数据存储到City表
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * */
    public static boolean handleCountiesResponse(
            CoolWeatherDB coolWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County country = new County();
                    country.setCountyCode(array[0]);
                    country.setCountyCode(array[1]);
                    country.setCityId(cityId);
                    //  将解析处理的数据存储到Country表
                    coolWeatherDB.saveCounty(country);
                }
                return true;
            }
        }
        return false;
    }
}
