package com.example.wojciech.chorzydoktorzy;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng placPW = new LatLng(52.220408, 21.011809);
        mMap.addMarker(new MarkerOptions().position(placPW).title("Twoja lokalizacja"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(placPW));
        mMap.setMinZoomPreference(16);

        // geojson apteki - read file
        InputStream inputStream = getResources().openRawResource(R.raw.przychodnie);
        Scanner scanner = new Scanner(inputStream);
        String str = "";
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            str = str + line;
        }
        Log.v("myapp",str);


        //parse the string at JSON
        //jsonArrayFeature = null;
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArrayFeature = jsonObject.getJSONArray("features");
            Log.v("done", str);

            for (int i = 0; i < jsonArrayFeature.length(); i++) {
                try {
                    JSONObject featureObject = jsonArrayFeature.getJSONObject(i);
                    //String name = locationObj.getJSONObject("properties").getString("name");
                    //names[i] = name;
                    JSONObject geometryObject = featureObject.getJSONObject("geometry");
                    JSONArray wspolrzedne = geometryObject.getJSONArray("coordinates");
                    JSONObject propertiesObject = featureObject.getJSONObject("properties");
                    String name = propertiesObject.getString("name");

                    Log.v("name","name = " + name);
                    double lat = wspolrzedne.getDouble(1);
                    double lng = wspolrzedne.getDouble(0);
                    Log.v("latln","lat = " + lat + ", lng = " + lng);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng(lat,lng));
                    markerOptions.title(name);
                    markerOptions.snippet("click");
                    //markerOptions.snippet(ocena);
                    mMap.addMarker(markerOptions);

                } catch (JSONException e) {
                    Log.v("myapperror",e.getMessage());
                }
            }
        } catch (JSONException e) {
            Log.v("myapp",e.getMessage());
        }
        //String[] names = new String[jsonArrayFeature.length()];
    }
}
