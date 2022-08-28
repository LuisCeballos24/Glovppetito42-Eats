package gg.rubit.api;

import java.util.List;

import gg.rubit.api.request.RankingPodioRequest;
import gg.rubit.api.request.RequestGame;
import gg.rubit.api.request.RequestUser;
import gg.rubit.api.response.CVID_Tabla;
import gg.rubit.api.response.IdResponse;
import gg.rubit.api.response.PairsResponse;
import gg.rubit.api.response.UserResponse;
import gg.rubit.components.conversation.data.DatosConversacion;
import gg.rubit.components.conversation.data.SubTemas;
import gg.rubit.data.ConversationDataValues;
import gg.rubit.data.UserDataValues;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("login")
    Call<UserResponse> login(@Body RequestUser request);

    @POST("usuarios")
    Call<IdResponse> postRegistrarUsuarios(@Body UserDataValues estudiante);

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

    @GET("conversacion/{id}")
    Call<List<DatosConversacion>> getListDialogs(@Path("id") int id);

    @GET("lecciones/{id}")
    Call<List<SubTemas>> getSubTemas(@Path("id") int id);
}
