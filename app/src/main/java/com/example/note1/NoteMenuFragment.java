package com.example.note1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteMenuFragment extends Fragment {

    private boolean isTwoPane;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_menu_frag,container,false);
        RecyclerView noteMenuRW = (RecyclerView) view.findViewById(R.id.note_menu_rw);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        noteMenuRW.setLayoutManager(lm);
        MenuAdapter adapter = new MenuAdapter(getNote());
        noteMenuRW.setAdapter(adapter);
        return view;
    }

    private List<Note> getNote(){
        List<Note> newList = new ArrayList<>();
        Note note1 = new Note("Ah,shit!","Here we go again...");
        Note note2 = new Note("Another one","And another one");
        newList.add(note1);
        newList.add(note2);
        return newList;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.note_content_fragment) != null){
            isTwoPane = true;
        }
        else{
            isTwoPane = false;
        }
    }

    class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> implements com.example.note1.MenuAdapter {

        private List<Note> NoteList;

        public  class ViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView content;

            public ViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.title);
                content = (TextView) view.findViewById(R.id.content);
            }
        }

        public MenuAdapter(List<Note> NoteList1){
            NoteList = NoteList1;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Note note = NoteList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        NoteContentFragment NFC = (NoteContentFragment) getFragmentManager().findFragmentById(R.id.note_content_fragment);
                    }
                    else{
                        NoteContentActivity.actionStart(getActivity());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Note note = NoteList.get(position);
            holder.title.setText(Note.getTitle());
            holder.content.setText(Note.getContent());
        }

        @Override
        public int getItemCount() {
            return NoteList.size();
        };
    }

}
