package dev.davveg.pdiciembre_pmdm;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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