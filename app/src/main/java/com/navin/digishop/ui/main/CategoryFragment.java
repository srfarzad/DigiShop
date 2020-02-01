package com.navin.digishop.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.navin.digishop.R;
import com.navin.digishop.models.Category;
import com.navin.digishop.models.IResponseMessage;
import com.navin.digishop.ui.main.adapter.CategoryAdapter;
import com.navin.digishop.webservice.ApiCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    @BindView(R.id.progress) ProgressBar progress;
    @BindView(R.id.recycler_categories) RecyclerView recycler_categories;

    ApiCaller apiCaller;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);

        apiCaller = new ApiCaller();


        progress.setVisibility(View.VISIBLE);
        apiCaller.getCat(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) {
                Log.e("","") ;
                progress.setVisibility(View.GONE);


                CategoryAdapter adapter = new CategoryAdapter((List<Category>) response);
                recycler_categories.setAdapter(adapter);

                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);

                recycler_categories.setLayoutManager(layoutManager);

            }

            @Override
            public void onFailuer(String errorMessage) {
                Log.e("","") ;
                progress.setVisibility(View.GONE);
            }
        });




        return view;
    }

}
