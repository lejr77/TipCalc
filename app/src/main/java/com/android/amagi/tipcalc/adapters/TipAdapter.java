package com.android.amagi.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.amagi.tipcalc.R;
import com.android.amagi.tipcalc.models.TipRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ljaimes on 18/07/2016.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {
    List<TipRecord> dataset;
    private OnItemClickListerner onItemClickListerner;
    Context context;
    public TipAdapter(Context context,List<TipRecord> dataset,OnItemClickListerner onItemClickListerner){
        this.context=context;
        this.dataset=dataset;
        this.onItemClickListerner = onItemClickListerner;
    }
    public TipAdapter(Context context,OnItemClickListerner onItemClickListerner){
        this.context=context;
        this.dataset=new ArrayList<TipRecord>();
        this.onItemClickListerner = onItemClickListerner;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }
    /*
        Permite colocar el contenido
    */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element =dataset.get(position);
        String strTip = String.format(
                context.getString(R.string.global_message_tip),element.getTip());
        holder.txtContent.setText(strTip);
        holder.setOnItemClickListener(element,onItemClickListerner);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public void add(TipRecord record) {
        dataset.add(0,record);
        notifyDataSetChanged();
    }
    public void clear(){
        dataset.clear();
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setOnItemClickListener(final TipRecord element, final OnItemClickListerner onItemClickListerner) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListerner.onItemClick(element);
                }
            });
        }
    }
}
