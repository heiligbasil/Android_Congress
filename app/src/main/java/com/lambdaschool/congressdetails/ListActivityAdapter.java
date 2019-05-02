package com.lambdaschool.congressdetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityAdapter.ViewHolder> {
    private ArrayList<CongresspersonOverview> congresspersonOverviewArrayList;

    public ListActivityAdapter(ArrayList<CongresspersonOverview> congresspersonOverviewArrayList) {
        this.congresspersonOverviewArrayList = congresspersonOverviewArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_element_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CongresspersonOverview congresspersonOverview = congresspersonOverviewArrayList.get(i);

        viewHolder.textView.setText(String.format("%s: %s %s - %s", congresspersonOverview.getState(), congresspersonOverview.getFirstName(), congresspersonOverview.getLastName(), congresspersonOverview.getParty()));
        viewHolder.viewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent (v.getContext(), ???.class);
//                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return congresspersonOverviewArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View viewParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycler_view_image_view);
            textView = itemView.findViewById(R.id.recycler_view_text_view);
            viewParent = itemView.findViewById(R.id.recycler_view_parent_layout);
        }
    }
}
