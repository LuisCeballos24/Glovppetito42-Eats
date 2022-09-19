package gg.glovpptetio42.api;

import java.util.List;

import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.RequestUser;
import gg.glovpptetio42.api.request.Recipes;
import gg.glovpptetio42.api.response.IdResponse;
import gg.glovpptetio42.api.response.UserResponse;
import gg.glovpptetio42.data.UserDataValues;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("login")
    Call<UserResponse> login(@Body RequestUser request);

    @POST("usuarios")
    Call<IdResponse> postRegistrarUsuarios(@Body UserDataValues usuario);

    @POST("datos_usuarios")
    Call<Integer> postRegistrarDatosUsuarios(@Body UserDataValues usuario);

    @GET("receta")
    Call<List<Recipes>> getRecipe();

    @GET("guardado")
    Call<List<FavRecipes>> getFavRecipe();

    @POST("guardado")
    Call<List<FavRecipes>> postFavRecipe(@Body FavRecipes guardado);

    @POST("receta")
    Call<Integer> postRecipe(@Body AddRecipes recipe);

    @DELETE("receta/{id}")
    Call<IdResponse> deleteRecipe(@Path("id") Recipes recipes);
}
