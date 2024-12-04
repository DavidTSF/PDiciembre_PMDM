package dev.davveg.pdiciembre_pmdm.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dev.davveg.pdiciembre_pmdm.api.RPGApiService;
import dev.davveg.pdiciembre_pmdm.game.GameState;
import dev.davveg.pdiciembre_pmdm.game.Inventory;
import dev.davveg.pdiciembre_pmdm.models.Item;
import dev.davveg.pdiciembre_pmdm.models.WeaponList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameModelView extends AndroidViewModel {

    Executor executor;
    MutableLiveData<GameState> gameState = new MutableLiveData<>();

    MutableLiveData<Inventory> inventory = new MutableLiveData<>();
    GameModel gameModel;

    Retrofit retrofit;
    RPGApiService service;

    public GameModelView(@NonNull Application application) {
        super(application);
        executor = Executors.newSingleThreadExecutor();
        retrofit = new Retrofit.Builder()
                .baseUrl(RPGApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RPGApiService.class);
        gameModel = new GameModel();
    }

    // API CALLS
    public void getAllItemsFromDatabase() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                gameModel.getAllItems(service, new GameModel.ApiCallback() {
                    @Override
                    public void onFinishRetrievingItems(List<Item> itemList) {
                        inventory.postValue(new Inventory(itemList));
                    }
                });
            }
        });


    }





    // GETTER AND SETTERS
    public MutableLiveData<GameState> getGameState() {
        return gameState;
    }

    public void setGameState(MutableLiveData<GameState> gameState) {
        this.gameState = gameState;
    }

    public MutableLiveData<Inventory> getInventory() {
        return inventory;
    }
}
