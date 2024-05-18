package com.example.qqchannels.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.qqchannels.Adapter.MyExpandableListAdapter;
import com.example.qqchannels.Adapter.RecyclerViewAdapter;
import com.example.qqchannels.R;
import com.example.qqchannels.classes.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChannelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ExpandableListView elistview;
    private MyExpandableListAdapter adapter;
    private List<Photo> photoList =new ArrayList<>();
    private  RecyclerViewAdapter adapter2;
//    private  RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChannelsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChannelsFragment newInstance(String param1, String param2) {
        ChannelsFragment fragment = new ChannelsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channels, container, false);
        getPhotos();
        RecyclerView recyclerView =(RecyclerView) view.findViewById(R.id.recyclerView_title);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter2 =new RecyclerViewAdapter(photoList);
        recyclerView.setAdapter(adapter2);
        // Find ExpandableListView in the fragment layout
        elistview = view.findViewById(R.id.elistview);

        // Create and set adapter for ExpandableListView
        adapter = new MyExpandableListAdapter(getContext());
        elistview.setAdapter(adapter);

        return view;
    }

    private void getPhotos() {

        Photo photo =new Photo(R.drawable.avatar);
        photoList.add(photo);

        Photo photo2 =new Photo(R.drawable.avatar);
        photoList.add(photo2);

        Photo photo3 =new Photo(R.drawable.avatar);
        photoList.add(photo3);

    }


}