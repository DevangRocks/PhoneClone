package com.example.phoneclone.CommonClass;

import com.example.phoneclone.PhoneCloneDataActivity;
import com.example.phoneclone.databinding.ActivityPhoneCloneDataBinding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PhoneCloneDataActivityClick implements Function0<ActivityPhoneCloneDataBinding> {
    final  PhoneCloneDataActivity this$0;

    PhoneCloneDataActivityClick(PhoneCloneDataActivity phoneCloneDataActivity) {
        this.this$0 = phoneCloneDataActivity;
    }

    public final ActivityPhoneCloneDataBinding invoke() {
        ActivityPhoneCloneDataBinding inflate = ActivityPhoneCloneDataBinding.inflate(this.this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            layoutInflater\n        )");
        return inflate;
    }
}
