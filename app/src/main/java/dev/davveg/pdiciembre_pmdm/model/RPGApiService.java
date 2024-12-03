package dev.davveg.pdiciembre_pmdm.model;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RPGApiService {
    String BASE_URL = "https://api.taxistahosting.com/";

    @GET("weapons")
    Call<WeaponList> getAllWeapons();

}
