package com.example.dns.leapfrog2.module;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dns.leapfrog2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecyclerViewFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecyclerViewFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    RecycleViewAdapter rViewAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;


    public RecyclerViewFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewFrag newInstance(String param1, String param2) {
        RecyclerViewFrag fragment = new RecyclerViewFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecycleViewAdapter(fillArrayList(), R.layout.fragment_recycler_view));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private ArrayList<UserInfo> fillArrayList() {
        ArrayList<UserInfo> customList = new ArrayList<>();
        customList.add(new UserInfo("Dinesh", "Android Develop", R.mipmap.dnes));
        customList.add(new UserInfo("Subash", "CMS Manager", R.mipmap.meme));
        customList.add(new UserInfo("Dheeraj", "Linux", R.mipmap.meme));
        customList.add(new UserInfo("Swekchya", "Content Writer", R.mipmap.meme));
        customList.add(new UserInfo("Manoj", "Graphics Designer", R.mipmap.meme));
        return customList;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rViewAdapter=new RecycleViewAdapter(fillArrayList(), R.layout.fragment_recycler_view);

        rViewAdapter.setOnItemClickListener(new RecycleViewAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getContext(), "onItemClick position: " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}
