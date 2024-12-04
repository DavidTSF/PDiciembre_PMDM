package dev.davveg.pdiciembre_pmdm.api;

import dev.davveg.pdiciembre_pmdm.models.WeaponList;
import retrofit2.http.GET;
import retrofit2.Call;

public interface RPGApiService {
    String BASE_URL = "https://api.taxistahosting.com/";

    @GET("weapons")
    Call<WeaponList> getAllWeapons();

}
