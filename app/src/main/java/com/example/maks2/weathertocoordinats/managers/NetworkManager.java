package com.example.maks2.weathertocoordinats.managers;

import com.example.maks2.weathertocoordinats.MyApplication;
import com.example.maks2.weathertocoordinats.models.Example;
import com.example.maks2.weathertocoordinats.models.WeatherModel;
import com.example.maks2.weathertocoordinats.network.OpenWeatherApi;
import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import rx.schedulers.Schedulers;

/**
 * Sorry for this code from Railian Maksym (24.09.2017).
 */

public class NetworkManager {

    private OpenWeatherApi api;

    public NetworkManager(OpenWeatherApi api) {
        this.api = api;
    }

    public rx.Observable<WeatherModel> getWeather(String lat, String lng, String units, String key) {
        return api.getData(lat, lng, units, key)
                .subscribeOn(Schedulers.io());
    }

    public rx.Observable<WeatherModel> getWeatherByCityName(String q, String units, String key) {
        return api.getWeatherByCityName(q, units, key)
                .subscribeOn(Schedulers.io());
    }

    public rx.Observable<Example> getWeatherForCeveralCities(String id, String units, String key) {
        return api.getWeatherForCeveralCities(id, units, key)
                .subscribeOn(Schedulers.io());
    }

}
