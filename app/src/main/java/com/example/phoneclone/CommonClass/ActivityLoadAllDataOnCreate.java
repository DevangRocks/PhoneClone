/*
package com.example.phoneclone.CommonClass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.phoneclone.LoadAllDataActivity;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

public final class ActivityLoadAllDataOnCreate extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    LoadAllDataActivity this$0;
    public ActivityLoadAllDataOnCreate(LoadAllDataActivity loadAllDataActivity, Continuation<? super ActivityLoadAllDataOnCreate> continuation) {
        super(2, (Continuation<Object>) continuation);
    }

    @Nullable
    @Override
    public Object invokeSuspend(@NonNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.loadPictures();
            this.this$0.loadVideos();
            this.this$0.loadMusic();
            this.this$0.loadFiles();
            this.this$0.loadApps();
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
        return invokeSuspend(Unit.INSTANCE);
    }

    private class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        int label;
        LoadAllDataActivity loadAllDataActivity;
        public AnonymousClass1(int arity, @Nullable Continuation<Object> completion) {
            super(arity, completion);
        }

        public AnonymousClass1(int arity) {
            super(arity);
        }

//        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
//            super(continuation);
//        }

        @Nullable
        @Override
        protected Object invokeSuspend(@NonNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                loadAllDataActivity.updateUI();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return invokeSuspend(Unit.INSTANCE);
        }
    }
}
*/
