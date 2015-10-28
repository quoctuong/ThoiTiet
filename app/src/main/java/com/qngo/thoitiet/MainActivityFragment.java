package com.qngo.thoitiet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Allow this fragment handle the menu event
        setHasOptionsMenu(true);
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_main, container, false);

        String[] arrForecast = {
                "Today - Sunny - 22/10",
                "Tomorrow - Foggy - 18/06",
                "Weds - Cloudy - 20/08",
                "Thurs - Heavy Rain - 15/08",
                "Fri - Sunny - 20/08"
        };

        List<String> listWeekForecast = new ArrayList<String>(Arrays.asList(arrForecast));

        // Setup Array Adapter
        mForecastAdapter = new ArrayAdapter<String>(
                // Current context
                getActivity(),
                // ID of list item
                R.layout.list_item_forecast,
                // ID of text view
                R.id.list_item_forecast_textview,
                // Data
                listWeekForecast);

        mListView = (ListView) viewFragment.findViewById(R.id.lv_forecast);
        mListView.setAdapter(mForecastAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strForecast = mForecastAdapter.getItem(position);
                Toast.makeText(getActivity(),strForecast,Toast.LENGTH_SHORT).show();
            }
        });

        return viewFragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                FetchWeatherTask weatherTask = new FetchWeatherTask(mListView,mForecastAdapter);
                weatherTask.execute("Massy");
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
