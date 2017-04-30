package inventslab.hacareemps_2.com.hacareem.views;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import adapters.SearchAdapter;
import dataservices.AdsDataService;
import dataservices.SearchDropOfServices;
import inventslab.hacareemps_2.R;
import models.AdsModel;
import models.SearchDropOfModel;

public class ConfirmDropoffActivity extends AppCompatActivity {

    private SearchAdapter mSearchAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_dropoff);

        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Dialog dialog = new Dialog(ConfirmDropoffActivity.this);
                dialog.setContentView(R.layout.custom_popup);
                dialog.setTitle("Confirm your Dropoff");


                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.id_tv_adv);
                text.setText("Hey It's 50% off at KFC and guess what ... it's with in your route");

                Button dialogButton = (Button) dialog.findViewById(R.id.id_btn_chalo);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(ConfirmDropoffActivity.this , RidenowActivity.class);
                        startActivity(i);
                    }
                });

                dialog.show();
            }
        });



        SearchDropOfModel [] searchedDropof = SearchDropOfServices.getDropoffs("");
        List<SearchDropOfModel> data  = new ArrayList<SearchDropOfModel>(Arrays.asList(searchedDropof));
        AdsModel [] ads = AdsDataService.getAdsData();
        for(int i =0  ; i<ads.length ; i++){
            SearchDropOfModel temp = new SearchDropOfModel(ads[i].getName() ,ads[i].getLocation());
        data.add(temp);
        }
        mSearchAdapter = new SearchAdapter(ConfirmDropoffActivity.this, data);
        listView.setAdapter(mSearchAdapter);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, ConfirmDropoffActivity.class)));
        return true;
    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.search:
//                onSearchRequested();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    @Override


    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this,"query" + query,Toast.LENGTH_SHORT);
            doMySearch(query);
        }
    }
    private void doMySearch(String query){
//        SearchDropOfModel searchedDropof = SearchDropOfServices.getDropoffs(query);
//        List<SearchDropOfModel> data  = new ArrayList<SearchDropOfModel>();
//        data.add(searchedDropof);
//        mSearchAdapter = new SearchAdapter(ConfirmDropoffActivity.this, data);
//        listView.setAdapter(mSearchAdapter);
    }
}
