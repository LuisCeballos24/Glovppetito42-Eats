package gg.glovpptetio42.api;

import java.util.List;

import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.RankingPodioRequest;
import gg.glovpptetio42.api.request.RequestGame;
import gg.glovpptetio42.api.request.RequestUser;
import gg.glovpptetio42.api.response.Recipes;
import gg.glovpptetio42.api.response.IdResponse;
import gg.glovpptetio42.api.response.PairsResponse;
import gg.glovpptetio42.api.response.UserResponse;
import gg.glovpptetio42.data.UserDataValues;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<UserResponse> login(@Body RequestUser request);

    @POST("usuarios")
    Call<IdResponse> postRegistrarUsuarios(@Body UserDataValues estudiante);

    @POST("datos_usuarios")
    Call<Integer> postRegistrarDatosUsuarios(@Body UserDataValues estudiante);

    @POST("partida")
    Call<Integer> postRegistrarPartida(@Body RequestGame partida);


    @GET("preguntas_pareo")
    Call<List<PairsResponse>> getPairsList();

    @GET("datos_usuarios")
    Call<List<Recipes>> getPuntaje();

    @GET("mostrarUser")
    Call<UserResponse> getUserDataById(@Body Integer userId);

    @GET("datos_usuarios")
    Call<List<UserResponse>> getDataUser();

    @GET("receta")
    Call<List<Recipes>> getRanking();

    @POST("receta")
    Call<Integer> postRanking2(@Body AddRecipes estudiante);

    @GET("datos_usuarios3")
    Call<List<RankingPodioRequest>> getParticipantes();
}
