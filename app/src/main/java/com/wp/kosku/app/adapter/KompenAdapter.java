package com.wp.kosku.app.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wp.kosku.app.ActivityCRUDCreate;
import com.wp.kosku.app.ActivityCRUDView;
import com.wp.kosku.app.ActivityCRUDSingleView;
import com.wp.kosku.app.R;
import com.wp.kosku.app.model.Kos;

import java.util.ArrayList;


public class KompenAdapter extends RecyclerView.Adapter<KompenAdapter.ViewHolder> {

    private ArrayList<Kos> daftarJam;
    private Context context;
    FirebaseDataListener listener;

    public KompenAdapter(ArrayList<Kos> Koss, Context ctx){

        daftarJam = Koss;
        context = ctx;
        listener = (ActivityCRUDView)ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_nama);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String name = daftarJam.get(position).getNama();
        System.out.println("SEWA DATA one by one "+position+daftarJam.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(ActivityCRUDSingleView.getActIntent((Activity) context).putExtra("data", daftarJam.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(ActivityCRUDCreate.getActIntent((Activity) context).putExtra("data", daftarJam.get(position)));
                            }
                        }
                );

                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarJam.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {

        return daftarJam.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(Kos kos, int position);
    }
}
