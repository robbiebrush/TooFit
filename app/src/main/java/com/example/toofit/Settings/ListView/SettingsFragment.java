package com.example.toofit.Settings.ListView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.preference.PreferenceFragmentCompat;

import com.example.toofit.R;

import java.util.ArrayList;

public class SettingsFragment extends PreferenceFragmentCompat {
    ListView listView;
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
          //                   Bundle savedInstanceState) {

       // View view = inflater.inflate(R.layout.fragment_settings, container, false);
       // listView = view.findViewById(R.id.listView);
       // ArrayList<Item> arrayList = new ArrayList<>();
      //  arrayList.add(new Item("Account Info"));
       // arrayList.add(new Item("Font Size"));
      //  arrayList.add(new Item("App Color"));
      //  arrayList.add(new Item("Credits"));

       // listView.setAdapter(new CustomListViewAdapter(getContext(), arrayList));

       // return view;
   // }
}