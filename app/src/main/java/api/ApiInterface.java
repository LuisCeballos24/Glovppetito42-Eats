package gg.rubit.api;

import java.util.List;

import gg.rubit.api.request.RequestGame;
import gg.rubit.api.request.RequestUser;
import gg.rubit.api.response.IdResponse;
import gg.rubit.api.response.PairsResponse;
import gg.rubit.api.response.UserResponse;
import gg.rubit.data.ConversationDataValues;
import gg.rubit.data.UserDataValues;
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

    @POST("usuarios")
    Call<Integer> postRegistrarPartida(@Body RequestGame partida);

    @GET("conversacion")
    Call<List<ConversationDataValues>> getDialogsList();

    @GET("preguntas_pareo")
    Call<List<PairsResponse>> getPairsList();
}
