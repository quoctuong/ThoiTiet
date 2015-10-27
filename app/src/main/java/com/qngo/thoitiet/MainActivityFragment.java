package com.qngo.thoitiet;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;

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

        ListView listView = (ListView) viewFragment.findViewById(R.id.lv_forecast);
        listView.setAdapter(mForecastAdapter);

        return viewFragment;
    }
}
