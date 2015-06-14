package com.example.invictus.clubtut;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by invictus on 6/8/2015.
 */
public class myRecyclerAdapter extends RecyclerView.Adapter<myRecyclerAdapter.myViewHolder> {

    Context context;
    List<UserModel> users= Collections.EMPTY_LIST;

    myRecyclerAdapter(Context context,List<UserModel> users){
        this.context=context;
        this.users=users;
    }

    @Override
   public myRecyclerAdapter.myViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(context).inflate(R.layout.single_item,viewGroup,false);

        myViewHolder holder=new myViewHolder(view);

        return holder;///passed to viewholder class;
    }

    @Override
    public void onBindViewHolder(myRecyclerAdapter.myViewHolder myViewHolder, int i) {
        UserModel singleUser=users.get(i);

        myViewHolder.user_name.setText(singleUser.getName());
        myViewHolder.user_image.setImageResource(singleUser.getImage());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView user_image;
        TextView user_name;

        public myViewHolder(View view) {
            super(view);

            user_image= (ImageView) view.findViewById(R.id.user_pic);
            user_name= (TextView) view.findViewById(R.id.user_name);
        }
    }
}
