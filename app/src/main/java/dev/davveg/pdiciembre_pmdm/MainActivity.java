package dev.davveg.pdiciembre_pmdm;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dev.davveg.pdiciembre_pmdm.fragments.CharacterFragment;
import dev.davveg.pdiciembre_pmdm.fragments.InventoryFragment;
import dev.davveg.pdiciembre_pmdm.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        final Fragment inventoryFragment = new InventoryFragment();
        final Fragment mainFragment = new MainFragment();
        final Fragment characterFragment = new CharacterFragment();

        bottomNavigationView.setOnItemSelectedListener( item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = mainFragment;
                    break;
                case R.id.inventory:
                    fragment = inventoryFragment;
                    break;
                case R.id.character:
                    fragment = characterFragment;
                    break;
            }
            assert fragment != null;
            fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.home);


    }



}