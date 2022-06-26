package com.alaminkarno.meowbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirebaseActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        firebaseFirestore = FirebaseFirestore.getInstance();

        Map<String,Object> userMap = new HashMap<>();

        userMap.put("name","Md. Al-Amin");
        userMap.put("Age","24");
        userMap.put("Blood_Group","O+");

        firebaseFirestore.collection("users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(FirebaseActivity.this, "Data Saved Successfully.", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FirebaseActivity.this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}