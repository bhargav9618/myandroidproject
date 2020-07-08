package com.example.amritapuriautoserviceapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AutoContactListAdapter extends RecyclerView.Adapter<AutoContactListAdapter.ViewHolder>{
    private ArrayList<String> mNames;
    private ArrayList<String> mNumbers;
    private Context mContext;
    public static final int REQUEST_CALL = 1;

    public AutoContactListAdapter(Context context, ArrayList<String> names, ArrayList<String> numbers)
    {
        mContext = context;
        mNames = names;
        mNumbers = numbers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(mNames.get(position));
        holder.number.setText(mNumbers.get(position));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(mContext,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(mContext, "Get permission", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions((Activity) mContext, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                }
                else{
                    String dailTo = "tel:"+mNumbers.get(position);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(dailTo));
                    mContext.startActivity(callIntent);
                }
            }
        });
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                makePhoneCall();
//            } else {
//                Toast.makeText(mContext, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void makePhoneCall() {
//        String dailTo = "tel:"+mNumbers.get(position);
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse(dailTo));
//        mContext.startActivity(callIntent);
//    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView number;
        private ConstraintLayout constraintLayout;
        private ImageView callButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            callButton = itemView.findViewById(R.id.callButton);
            name = itemView.findViewById(R.id.contactName);
            number = itemView.findViewById(R.id.contactNo);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
