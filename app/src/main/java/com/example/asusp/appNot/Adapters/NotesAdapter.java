package com.example.asusp.appNot.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asusp.appNot.Pojos.Note;
import com.example.asusp.appNot.R;

import java.util.List;

/**
 * Created by AsusP on 19/03/2018.
 */

//CLASE ADAPTADOR
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    //Creo los contextos
    Context context;
    List<Note> noteList;

    public NotesAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }



    //metodos implementados  del adaptador viewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //cresmos la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //utilizamos el Holder que esta abajo
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(noteList.get(position).getId()));
        holder.title.setText(noteList.get(position).getTitle());
        holder.body.setText(noteList.get(position).getBody());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eliminamos elemento de la List
                noteList.remove(position);

                //Actualiza el Recyclerview (revisa cambios y vuelve a cargar)
                notifyDataSetChanged();
            }
        });

    }

    //cantidad de elemntos
    @Override
    public int getItemCount() {
        return noteList.size();
    }

    //creo la new clase
    public class ViewHolder extends RecyclerView.ViewHolder{

        //definimos los elementos del XML
        CardView cardView;
        TextView id,title,body;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            //Capturamos lo elementos del XML
            cardView = (CardView) itemView.findViewById(R.id.idCardview);
            id = (TextView) itemView.findViewById(R.id.txtId);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            body = (TextView) itemView.findViewById(R.id.txtBody);
            imageView = (ImageView) itemView.findViewById(R.id.imgTrash);
        }
    }
}
