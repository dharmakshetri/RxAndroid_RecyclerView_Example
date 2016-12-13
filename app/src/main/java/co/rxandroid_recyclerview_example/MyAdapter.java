package co.rxandroid_recyclerview_example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharma kshetri(@dharma.kshetri@gmail.com) on 12/12/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<String> nameList = new ArrayList<>();

    public MyAdapter(Context context){mContext=context;}

    public void setData(List<String> names){
        nameList.clear();
        nameList.addAll(names);
        notifyDataSetChanged();
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.display_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
    holder.myTextView.setText(nameList.get(position));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext," "+nameList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public  TextView myTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView=(TextView)itemView.findViewById(R.id.tvName);
        }
    }
}
