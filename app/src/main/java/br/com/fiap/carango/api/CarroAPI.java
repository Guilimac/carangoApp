package br.com.fiap.carango.api;

import java.util.List;

import br.com.fiap.carango.models.Carro;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by guilherme on 19/11/16.
 */

public interface CarroAPI {

    @GET("/carros/tipo/{tipo}")
    Call<List<Carro>> findBy(@Path("tipo") String tipo);
}
