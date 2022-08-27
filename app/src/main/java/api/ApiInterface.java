package api;

import java.util.List;


import api.request.RankingPodioRequest;
import api.request.RequestGame;
import api.request.RequestUser;
import api.response.CVID_Tabla;
import api.response.PairsResponse;
import api.response.UserResponse;
import data.ConversationDataValues;
import data.UserDataValues;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("login")
    Call<api.response.UserResponse> login(@Body RequestUser request);

    @POST("usuarios")
    Call<api.response.IdResponse> postRegistrarUsuarios(@Body UserDataValues estudiante);

    @POST("datos_usuarios")
    Call<Integer> postRegistrarDatosUsuarios(@Body UserDataValues estudiante);

    @POST("partida")
    Call<Integer> postRegistrarPartida(@Body RequestGame partida);

    @GET("conversacion")
    Call<List<ConversationDataValues>> getDialogsList();

    @GET("preguntas_pareo")
    Call<List<PairsResponse>> getPairsList();

    @GET("datos_usuarios")
    Call<List<CVID_Tabla>> getPuntaje();

    @GET("mostrarUser")
    Call<UserResponse> getUserDataById(@Body Integer userId);

    @GET("datos_usuarios")
    Call<List<UserResponse>> getDataUser();

    @GET("ranking")
    Call<List<CVID_Tabla>> getRanking();

    @GET("ranking2")
    Call<List<CVID_Tabla>> getRanking2();

    @GET("datos_usuarios3")
    Call<List<RankingPodioRequest>> getParticipantes();

}
