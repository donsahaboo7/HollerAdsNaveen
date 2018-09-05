package com.a2zdevelopers.hollerads;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FunctionRecyclerAdapter extends RecyclerView.Adapter<FunctionRecyclerAdapter.MyViewHolder> {
    public static final String POSITION_NO ="position_no" ;
    Context context;
    String[] fDataList;
    int[] salary;

    public FunctionRecyclerAdapter(Context context, String[] fDataList,int[] salary) {
        this.context = context;
        this.fDataList = fDataList;
        this.salary = salary;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.frecycler_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.textView.setText(fDataList[i]);
        myViewHolder.textView2.setText("Salary - " +salary[i]);
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra(POSITION_NO,i);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fDataList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textData);
            textView2 = itemView.findViewById(R.id.salary);
        }
    }
}
