package com.example.phoneclone.CommonClass;

import androidx.annotation.Nullable;

import com.example.phoneclone.LoadAllDataActivity;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class ActivityLoadAllDataOnCreate extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final LoadAllDataActivity this$0;
    public ActivityLoadAllDataOnCreate(LoadAllDataActivity activityLoadAllData, Continuation<? super ActivityLoadAllDataOnCreate> continuation) {
        super(2, (Continuation<Object>) continuation);
        this.this$0 = activityLoadAllData;
    }

//    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
//        return new ActivityLoadAllDataOnCreate(this.this$0, continuation);
//    }
    @Nullable
    @Override
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            //ResultKt.throwOnFailure(obj);
            this.this$0.loadPictures();
            this.this$0.loadVideos();
            this.this$0.loadMusic();
            this.this$0.loadFiles();
            this.this$0.loadApps();
            //this.this$0.getContactList();
            final LoadAllDataActivity activityLoadAllData = this.this$0;
            this.label = 1;
//            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
//                return coroutine_suspended;
//            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.setupCheckboxListeners();
        return Unit.INSTANCE;
    }

    @Override
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return null;
    }

//    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
//        int label;
//
//        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
//            return new AnonymousClass1(activityLoadAllData, continuation);
//        }
//
//        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
//            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
//        }
//
//        public final Object invokeSuspend(Object obj) {
//            IntrinsicsKt.getCOROUTINE_SUSPENDED();
//            if (this.label == 0) {
//                ResultKt.throwOnFailure(obj);
//                activityLoadAllData.updateUI();
//                return Unit.INSTANCE;
//            }
//            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//        }
//    }
}
