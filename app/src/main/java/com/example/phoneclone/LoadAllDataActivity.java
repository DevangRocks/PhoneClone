package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CompoundButton;

import com.example.phoneclone.CommonClass.ActivityLoadAllData$onCreate$1;
import com.example.phoneclone.CommonClass.MConstants;
import com.example.phoneclone.databinding.ActivityLoadAllDataBinding;
import com.example.phoneclone.model.ContactModel;
import com.example.phoneclone.model.FileModel;
import com.example.phoneclone.util.MUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public class LoadAllDataActivity extends AppCompatActivity {
    private long allDataSize;
    public ActivityLoadAllDataBinding binding;
    private SharedPreferences sharedPreferences;
    private SpotsDialog spotsDialog;
    public ArrayList<FileModel> mPicturesList = new ArrayList<>();
    public long mImagesSize;
    public ArrayList<FileModel> mVideosList = new ArrayList<>();
    public long mVideosSize;

    public ArrayList<FileModel> mMusicList = new ArrayList<>();
    public long mMusicsSize;
    public ArrayList<FileModel> mOtherFilesList = new ArrayList<>();
    public long mFilesSize;
    public ArrayList<FileModel> mAppsList = new ArrayList<>();
    public long mAppsSize;
    public ArrayList<ContactModel> mContactList = new ArrayList<>();
    private static final int SHARE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoadAllDataBinding inflate = ActivityLoadAllDataBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        ActivityLoadAllDataBinding activityLoadAllDataBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());

        SharedPreferences sharedPreferences2 = getSharedPreferences(MConstants.prefName, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getSharedPreferences(prefName, MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        //showDialog();
        //Job unused = BuildersKt.launch(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) this, (CoroutineStart) null, new ActivityLoadAllData$onCreate$1(this, (Continuation<? super ActivityLoadAllData$onCreate$1>) null), 3, (Object) null);
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                finish();
            }
        });

        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent shareIntent = new Intent(LoadAllDataActivity.this, ReceiveDataInfocusActivity.class);
                shareIntent.setAction("android.intent.action.SEND_MULTIPLE");
                //shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                LoadAllDataActivity.this.startActivityForResult(shareIntent, SHARE_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SHARE_REQUEST) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }
    }

    private void showDialog() {
        Context context = this;
        AlertDialog build = new SpotsDialog.Builder().setContext(context).setContext(context).setMessage("Data Loading...").setTheme(R.style.MyDialog).build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type dmax.dialog.SpotsDialog");
        SpotsDialog spotsDialog2 = (SpotsDialog) build;
        this.spotsDialog = spotsDialog2;
        if (spotsDialog2 == null) {
            spotsDialog2 = null;
        }
        spotsDialog2.show();
    }

    public final void setupCheckboxListeners() {
        ActivityLoadAllDataBinding activityLoadAllDataBinding = this.binding;
        ActivityLoadAllDataBinding activityLoadAllDataBinding2 = null;
        if (activityLoadAllDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding = null;
        }
        activityLoadAllDataBinding.checkboxApps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$3(LoadAllDataActivity.this, compoundButton, z);
            }
        });
        ActivityLoadAllDataBinding activityLoadAllDataBinding3 = this.binding;
        if (activityLoadAllDataBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding3 = null;
        }
        activityLoadAllDataBinding3.checkboxFiles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$4(LoadAllDataActivity.this, compoundButton, z);
            }
        });
        ActivityLoadAllDataBinding activityLoadAllDataBinding4 = this.binding;
        if (activityLoadAllDataBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding4 = null;
        }
        activityLoadAllDataBinding4.checkboxMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$5(LoadAllDataActivity.this, compoundButton, z);
            }
        });
        ActivityLoadAllDataBinding activityLoadAllDataBinding5 = this.binding;
        if (activityLoadAllDataBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding5 = null;
        }
        activityLoadAllDataBinding5.checkboxImages.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$6(LoadAllDataActivity.this, compoundButton, z);
            }
        });
        ActivityLoadAllDataBinding activityLoadAllDataBinding6 = this.binding;
        if (activityLoadAllDataBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoadAllDataBinding2 = activityLoadAllDataBinding6;
        }
        activityLoadAllDataBinding2.checkboxVideos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$7(LoadAllDataActivity.this, compoundButton, z);
            }
        });
    }

    public static final void setupCheckboxListeners$lambda$7(LoadAllDataActivity activityLoadAllData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(activityLoadAllData, "this$0");
        if (z) {
            activityLoadAllData.allDataSize += activityLoadAllData.mVideosSize;
        } else {
            activityLoadAllData.allDataSize -= activityLoadAllData.mVideosSize;
        }
        activityLoadAllData.updateUI();
    }

    public static final void setupCheckboxListeners$lambda$3(LoadAllDataActivity activityLoadAllData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(activityLoadAllData, "this$0");
        if (z) {
            activityLoadAllData.allDataSize += activityLoadAllData.mAppsSize;
        } else {
            activityLoadAllData.allDataSize -= activityLoadAllData.mAppsSize;
        }
        activityLoadAllData.updateUI();
    }

    public static final void setupCheckboxListeners$lambda$4(LoadAllDataActivity activityLoadAllData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(activityLoadAllData, "this$0");
        if (z) {
            activityLoadAllData.allDataSize += activityLoadAllData.mFilesSize;
        } else {
            activityLoadAllData.allDataSize -= activityLoadAllData.mFilesSize;
        }
        activityLoadAllData.updateUI();
    }

    public static final void setupCheckboxListeners$lambda$5(LoadAllDataActivity activityLoadAllData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(activityLoadAllData, "this$0");
        if (z) {
            activityLoadAllData.allDataSize += activityLoadAllData.mMusicsSize;
        } else {
            activityLoadAllData.allDataSize -= activityLoadAllData.mMusicsSize;
        }
        activityLoadAllData.updateUI();
    }

    public static final void setupCheckboxListeners$lambda$6(LoadAllDataActivity activityLoadAllData, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(activityLoadAllData, "this$0");
        if (z) {
            activityLoadAllData.allDataSize += activityLoadAllData.mImagesSize;
        } else {
            activityLoadAllData.allDataSize -= activityLoadAllData.mImagesSize;
        }
        activityLoadAllData.updateUI();
    }

    public final void loadPictures() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "EXTERNAL_CONTENT_URI");
        Cursor query = getContentResolver().query(uri, new String[]{"_id", "_display_name", "_data", "_size"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                String string3 = query.getString(query.getColumnIndexOrThrow("_size"));
                if (!(string == null || string2 == null || string3 == null)) {
                    this.mPicturesList.add(new FileModel(string, string2, "Images", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null));
                    try {
                        long length = new File(string2).length();
                        if (length > 0) {
                            this.mImagesSize += length;
                            this.allDataSize += length;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            query.close();
        }
    }

    public final void loadVideos() {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "EXTERNAL_CONTENT_URI");
        Cursor query = getContentResolver().query(uri, new String[]{"_id", "_display_name", "_data", "_size"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                String string3 = query.getString(query.getColumnIndexOrThrow("_size"));
                if (!(string == null || string2 == null || string3 == null)) {
                    this.mVideosList.add(new FileModel(string, string2, "Videos", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null));
                    try {
                        long length = new File(string2).length();
                        if (length > 0) {
                            this.mVideosSize += length;
                            this.allDataSize += length;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            query.close();
        }
    }

    public final void loadMusic() {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "EXTERNAL_CONTENT_URI");
        Cursor query = getContentResolver().query(uri, new String[]{"_id", "_display_name", "_data", "_size"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                String string3 = query.getString(query.getColumnIndexOrThrow("_size"));
                if (!(string == null || string2 == null || string3 == null)) {
                    this.mMusicList.add(new FileModel(string, string2, "Music", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null));
                    try {
                        long length = new File(string2).length();
                        if (length > 0) {
                            this.mMusicsSize += length;
                            this.allDataSize += length;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            query.close();
        }
    }
    public final void loadFiles() {
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(\"external\")");
        Cursor query = getContentResolver().query(contentUri, new String[]{"_id", "_display_name", "_data", "_size"}, "media_type=0", (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                String string3 = query.getString(query.getColumnIndexOrThrow("_size"));
                if (!(string == null || string2 == null || string3 == null)) {
                    if (endsWith$default(string, ".pdf", false, 2, (Object) null) || endsWith$default(string, ".txt", false, 2, (Object) null) || endsWith$default(string, ".docx", false, 2, (Object) null) || endsWith$default(string, ".xlsx", false, 2, (Object) null)) {
                        this.mOtherFilesList.add(new FileModel(string, string2, "Apps", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null));
                        try {
                            long length = new File(string2).length();
                            if (length > 0) {
                                this.mFilesSize += length;
                                this.allDataSize += length;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            query.close();
        }
    }

    public static  boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(str, str2, z);
    }

    public final void loadApps() {
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(9344);
        Intrinsics.checkNotNullExpressionValue(installedApplications, "pm.getInstalledApplications(flags)");
        for (ApplicationInfo next : installedApplications) {
            try {
                if ((next.flags & 1) != 1) {
                    String str = next.packageName;
                    Intrinsics.checkNotNullExpressionValue(str, "appInfo.packageName");
                    File appFile = MUtils.INSTANCE.appFile(this, str);
                    long length = appFile.length();
                    ArrayList<FileModel> arrayList = this.mAppsList;
                    String obj = next.loadLabel(packageManager).toString();
                    String path = appFile.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "apkFile.path");

                    //FileModel fileModel = r8;
                    FileModel fileModel2 = new FileModel(obj, path, "Apps", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null);
                    //arrayList.add(fileModel);
                    if (length > 0) {
                        this.mAppsSize += length;
                        this.allDataSize += length;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public final void updateUI() {
        SpotsDialog spotsDialog2 = this.spotsDialog;
        ActivityLoadAllDataBinding activityLoadAllDataBinding = null;
        if (spotsDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spotsDialog");
            spotsDialog2 = null;
        }
        spotsDialog2.dismiss();
        ActivityLoadAllDataBinding activityLoadAllDataBinding2 = this.binding;
        if (activityLoadAllDataBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding2 = null;
        }
        activityLoadAllDataBinding2.tvImagesSize.setText(this.mPicturesList.size() + " | " + MUtils.INSTANCE.size(this.mImagesSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding3 = this.binding;
        if (activityLoadAllDataBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding3 = null;
        }
        activityLoadAllDataBinding3.tvVideosSize.setText(this.mVideosList.size() + " | " + MUtils.INSTANCE.size(this.mVideosSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding4 = this.binding;
        if (activityLoadAllDataBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding4 = null;
        }
        activityLoadAllDataBinding4.tvMusicSize.setText(this.mMusicList.size() + " | " + MUtils.INSTANCE.size(this.mMusicsSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding5 = this.binding;
        if (activityLoadAllDataBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding5 = null;
        }
        activityLoadAllDataBinding5.tvFilesSize.setText(this.mOtherFilesList.size() + " | " + MUtils.INSTANCE.size(this.mFilesSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding6 = this.binding;
        if (activityLoadAllDataBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding6 = null;
        }
        activityLoadAllDataBinding6.tvAppsSize.setText(this.mAppsList.size() + " | " + MUtils.INSTANCE.size(this.mAppsSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding7 = this.binding;
        if (activityLoadAllDataBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoadAllDataBinding7 = null;
        }
        activityLoadAllDataBinding7.tvTotalSize.setText("Selected\n" + MUtils.INSTANCE.size(this.allDataSize));
        ActivityLoadAllDataBinding activityLoadAllDataBinding8 = this.binding;
        if (activityLoadAllDataBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoadAllDataBinding = activityLoadAllDataBinding8;
        }
        activityLoadAllDataBinding.tvContactsSize.setText(this.mContactList.size() + " contacts");
    }

}