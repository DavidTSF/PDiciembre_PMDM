package dev.davveg.pdiciembre_pmdm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

import dev.davveg.pdiciembre_pmdm.databinding.ViewholderItemBinding;
import dev.davveg.pdiciembre_pmdm.databinding.FragmentInventoryBinding;
import dev.davveg.pdiciembre_pmdm.model.Item;
import dev.davveg.pdiciembre_pmdm.model.RPGApiService;
import dev.davveg.pdiciembre_pmdm.model.WeaponList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InventoryFragment extends Fragment {

    Retrofit retrofit;
    RPGApiService service;
    FragmentInventoryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl(RPGApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RPGApiService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentInventoryBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemAdapter itemAdapter = new ItemAdapter();
        binding.itemRecyclerView.setAdapter(itemAdapter);

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

                response.body().getResults().forEach( weapon ->
                        tmpList.add(weapon)
                );

                itemAdapter.establecerLista(tmpList);

            }
            @Override
            public void onFailure(Call<WeaponList> call, Throwable t) {
                Log.d("Error", "NO SE HA PODIDO AGARRAR LA API?" + t.toString());
            }
        });







    }





    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        List<Item> elementos;

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

            Item elemento = elementos.get(position);

            holder.binding.nameItem.setText(elemento.getItemName());


        }

        @Override
        public int getItemCount() {
            return elementos != null ? elementos.size() : 0;
        }

        public void establecerLista(List<Item> elementos){
            this.elementos = elementos;
            notifyDataSetChanged();
        }

        public Item obtenerElemento(int posicion){
            return elementos.get(posicion);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderItemBinding binding;

        public ItemViewHolder(ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}