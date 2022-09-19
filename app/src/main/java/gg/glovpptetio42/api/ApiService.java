package gg.glovpptetio42.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiInterface API_SERVICE;

    public static ApiInterface getApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.56.1:8001/").addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
            API_SERVICE = retrofit.create(ApiInterface.class);
        }

        return API_SERVICE;
    }
}