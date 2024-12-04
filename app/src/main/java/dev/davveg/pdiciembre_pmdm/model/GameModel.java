package dev.davveg.pdiciembre_pmdm.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.davveg.pdiciembre_pmdm.api.RPGApiService;
import dev.davveg.pdiciembre_pmdm.models.Item;
import dev.davveg.pdiciembre_pmdm.models.WeaponList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class GameModel {





    public interface ApiCallback {
        void onFinishRetrievingItems(List<Item> itemList);
    }

    public void getAllItems( RPGApiService service, ApiCallback callback ) {

        Call<WeaponList> weaponCall = service.getAllWeapons();
        weaponCall.enqueue(new Callback<WeaponList>() {
            @Override
            public void onResponse(Call<WeaponList> call, Response<WeaponList> response) {
                response.body().getResults().forEach(
                        weapon -> {
                            Log.d("DEBUG name", weapon.getName());
                            Log.d("DEBUG description", weapon.getDescription());
                            Log.d("DEBUG base_damege", String.valueOf(weapon.getBase_damage()));
                        }
                );

                List<Item> tmpList = new ArrayList<>();

                tmpList.addAll(response.body().getResults());
                callback.onFinishRetrievingItems(tmpList);
            }
            @Override
            public void onFailure(Call<WeaponList> call, Throwable t) {
                Log.d("Error", "NO SE HA PODIDO AGARRAR LA API?" + t.toString());
            }
        });






    }





}
