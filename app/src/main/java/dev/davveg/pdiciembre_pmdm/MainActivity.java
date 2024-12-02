package dev.davveg.pdiciembre_pmdm;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);



        bottomNavigationView.setOnItemSelectedListener( item -> {
           switch (item.getItemId()) {
               case R.id.inventory:
                   navController.navigate(R.id.action_mainFragment_to_inventoryFragment);
                   break;

               case R.id.home:
                   navController.navigate(R.id.action_inventoryFragment_to_mainFragment);
                   break;

           }

            return true;
        });




    }




}