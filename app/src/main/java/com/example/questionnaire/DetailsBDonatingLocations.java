package com.example.questionnaire;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DetailsBDonatingLocations
{
    private DatabaseReference databaseReference;
    public DetailsBDonatingLocations()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference= db.getReference(BDonatingLocations.class.getSimpleName());
    }

public Task<Void> add(BDonatingLocations bDonatingLocations)
{

    return databaseReference.push().setValue(bDonatingLocations);
}

public Task<Void> update(String key, HashMap<String, Object> hashMap)
{
    return databaseReference.child(key).updateChildren(hashMap);
}
public Task<Void> delete(String key)
{
        return databaseReference.child(key).removeValue();
}


}
