package com.aditya.recyclerviewcentered.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.recyclerviewcentered.feature.adapter.DemoAdapter;
import com.aditya.recyclerviewcentered.feature.impl.ScaleTransformer;
import com.aditya.recyclerviewcentered.feature.view.GalleryLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.main_recycle1);
        final List<String> title = new ArrayList<String>();
        int size = 50;
        for (int i = 0; i < size; i++) {
            title.add("Hello" + i);
        }
        GalleryLayoutManager layoutManager1 = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager1.attach(recyclerView, 0);
        layoutManager1.setItemTransformer(new ScaleTransformer());
        DemoAdapter demoAdapter1 = new DemoAdapter(title) {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };
        demoAdapter1.setOnItemClickListener(new DemoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                recyclerView.smoothScrollToPosition(position);
            }
        });
        recyclerView.setAdapter(demoAdapter1);
    }
}
