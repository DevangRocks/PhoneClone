package com.example.phoneclone.model;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.phoneclone.CommonClass.ViewModelClass$allImages$1;

import kotlin.jvm.internal.Intrinsics;

public class ViewModelClass extends AndroidViewModel {
    private Context context;
    //private final LiveData allImages;
    public ViewModelClass(@NonNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.getApplicationContext()");
        this.context = applicationContext;
//        LiveData map = Transformations.map(new Repository(applicationContext).getImages(), ViewModelClass$allImages$1.INSTANCE);
//        Intrinsics.checkNotNullExpressionValue(map, "map(Repository(context).…ges()) {\n        it\n    }");
//        this.allImages = map;
    }

    public final LiveData getAllImages() {
        return null;
    }
}
