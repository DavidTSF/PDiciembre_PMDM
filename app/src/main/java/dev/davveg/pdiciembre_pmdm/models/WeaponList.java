package dev.davveg.pdiciembre_pmdm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeaponList {
    @SerializedName("weapons")
    @Expose
    private ArrayList<Weapon> weaponList;

    public ArrayList<Weapon> getResults() {
        return weaponList;
    }
    public void setResults(ArrayList<Weapon> results) {
        this.weaponList = results;
    }
}
