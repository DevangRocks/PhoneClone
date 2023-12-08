package com.example.phoneclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.phoneclone.CommonClass.MConstants;
import com.example.phoneclone.databinding.ActivityLoadAllDataBinding;
import com.example.phoneclone.model.ContactModel;
import com.example.phoneclone.model.FileModel;
import com.example.phoneclone.transfer.TransferService;
import com.example.phoneclone.util.MUtils;
import com.example.phoneclone.util.Settings;
import com.google.android.material.internal.ParcelableSparseArray;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import dmax.dialog.SpotsDialog;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class LoadAllDataActivity extends AppCompatActivity {
    private long allDataSize;
    public ActivityLoadAllDataBinding binding;
    private SharedPreferences sharedPreferences;
    private SpotsDialog spotsDialog;
    public ArrayList<FileModel> mPicturesList = new ArrayList<>();
    public long mImagesSize;
    public ArrayList<FileModel> mVideosList = new ArrayList<>();
    public Parcelable buildUriList ;
    public ArrayList<Parcelable>  arr = new ArrayList<>();
    public ArrayList<Parcelable>  arr1 = new ArrayList<>();
    public long mVideosSize;
    Uri parcelableUri;

    public ArrayList<FileModel> mMusicList = new ArrayList<>();
    public long mMusicsSize;
    public ArrayList<FileModel> mOtherFilesList = new ArrayList<>();
    public long mFilesSize;
    public ArrayList<FileModel> mAppsList = new ArrayList<>();
    public long mAppsSize;
    public ArrayList<ContactModel> mContactList = new ArrayList<>();
    private static final int SHARE_REQUEST = 1;
    private final String[] projection = {"contact_id", "display_name", "data1"};
    private Settings mSettings;
    LinearLayout progress_layout;
    ProgressDialog pDialog;
    static boolean process_successfully = false;
    GetStatusTask get_word_taskimg;

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
        binding.tvTotalSize.setText(getIntent().getStringExtra("total"));

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                finish();
            }
        });

        loadAllData();
        this.get_word_taskimg = new GetStatusTask();
        this.get_word_taskimg.execute(new String[0]);
        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent shareIntent = new Intent(LoadAllDataActivity.this, ReceiveDataInfocusActivity.class);
                shareIntent.setAction("android.intent.action.SEND_MULTIPLE");
                shareIntent.putExtra(Intent.EXTRA_STREAM, parcelableUri);
                LoadAllDataActivity.this.startActivityForResult(shareIntent, SHARE_REQUEST);

                Log.d("parcableUri", parcelableUri.toString());

            }
        });

        binding.checkboxApps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$3(LoadAllDataActivity.this, compoundButton, z);
            }
        });

        binding.checkboxFiles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$4(LoadAllDataActivity.this, compoundButton, z);
            }
        });

        binding.checkboxMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$5(LoadAllDataActivity.this, compoundButton, z);
            }
        });

        binding.checkboxImages.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$6(LoadAllDataActivity.this, compoundButton, z);
            }
        });

        binding.checkboxVideos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoadAllDataActivity.setupCheckboxListeners$lambda$7(LoadAllDataActivity.this, compoundButton, z);
            }
        });

    }
    public void loadAllData() {
        try {
            loadApps();
            loadFiles();
            loadMusic();
            loadVideos();
            //loadPictures();
           getContactList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public class GetStatusTask extends AsyncTask<String, Void, String> {
        public GetStatusTask() {
        }

        public void onPreExecute() {
            super.onPreExecute();
            LoadAllDataActivity.this.pDialog = new ProgressDialog(LoadAllDataActivity.this);
            LoadAllDataActivity.this.pDialog.setMessage("Wait for a second ...");
            LoadAllDataActivity.this.pDialog.setIndeterminate(false);
            LoadAllDataActivity.this.pDialog.setCancelable(false);
            LoadAllDataActivity.this.pDialog.show();
        }
        public String doInBackground(String... strArr) {
            LoadAllDataActivity.process_successfully = false;
            LoadAllDataActivity.this.loadPictures();
            return null;
        }

        public void onPostExecute(String str) {
            if (LoadAllDataActivity.this.pDialog != null) {
                LoadAllDataActivity.this.pDialog.dismiss();
            }
            if (LoadAllDataActivity.process_successfully) {
                LoadAllDataActivity loadAllDataActivity = LoadAllDataActivity.this;
                loadAllDataActivity.updateUI();
            } else {
                Toast.makeText(LoadAllDataActivity.this, "Process Failed...", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public final void getContactList() {
        Throwable th;
        ContentResolver contentResolver = getContentResolver();
        Cursor query = contentResolver != null ? contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.projection, (String) null, (String[]) null, "display_name ASC") : null;
        if (query != null) {
            try {
                HashSet hashSet = new HashSet();
                Closeable closeable = query;
                try {
                    Cursor cursor = (Cursor) closeable;
                    int columnIndex = cursor.getColumnIndex("display_name");
                    int columnIndex2 = cursor.getColumnIndex("data1");
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndex);
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(nameIndex)");
                        String string2 = cursor.getString(columnIndex2);
                        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(numberIndex)");
                        String replaceDefault = replace(string2, " ", "", false, 4, (Object) null);
                        if (!hashSet.contains(replaceDefault)) {
                             replaceDefault = replace(replace(replace(replaceDefault, " ", "", false, 4, (Object) null), "*", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
                            File csvFile = getCsvFile(replaceDefault);
                            if (csvFile == null) {
                                csvFile = createCsvFile(replaceDefault);
                            }
                            this.mContactList.add(new ContactModel(string, replaceDefault, String.valueOf(csvFile != null ? csvFile.getAbsolutePath() : null)));
                            hashSet.add(replaceDefault);
                        }
                    }
                    updateUI();
                    Unit unit = Unit.INSTANCE;
                   closeFinally(closeable, (Throwable) null);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                   closeFinally(closeable, th3);
                    //throw th3;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void closeFinally(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
    }

    public   File getCsvFile(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator + '.' + getString(R.string.app_name));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "Num_" + str + ".vcf");
        if (file2.exists()) {
            return file2;
        }
        return file2;
    }

    private  File createCsvFile(String str) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator + '.' + getString(R.string.app_name));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "Num_" + str + ".vcf");
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write("BEGIN:VCARD\r\n");
            fileWriter.write("VERSION:1.0\r\n");
            fileWriter.write(trimIndent("\n            FN:" + str + "\n            \n            "));
            fileWriter.write(trimIndent("\n            TEL;TYPE=WORK,VOICE:" + str + "\n            \n            "));
            fileWriter.write("END:VCARD\r\n");
            fileWriter.close();
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replaceIndent(str, "");
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
                    this.buildUriList = Uri.parse(string2);
                    this.arr.add(buildUriList);

                    ParcelableArrayList<String> parcelableList = new ParcelableArrayList<>(mPicturesList);

                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("content") // Change to your desired scheme
                            .authority("com.example.phoneclone") // Change to your authority
                            .appendQueryParameter("dataList", parcelableList.toString()); // Add Parcelable as a query parameter

                        parcelableUri = builder.build();
                    Log.d("URI:", parcelableUri.toString());

                    String dataListString = parcelableUri.getQueryParameter("dataList");
                    //
                    // ParcelableArrayList<String> retrievedList = ParcelableArrayList.(dataListString);

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
            process_successfully = true;
           /* updateUI();*/

        } else {
            process_successfully = false;
        }
    }

    public static  String replace(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, str2, str3, z);
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
//                    this.buildUriList = Uri.parse(string2);
//                    this.arr.add(buildUriList);
                    ParcelableArrayList<String> parcelableList = new ParcelableArrayList<>(mPicturesList);

                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("content") // Change to your desired scheme
                            .authority("com.example.phoneclone") // Change to your authority
                            .appendQueryParameter("dataList", parcelableList.toString()); // Add Parcelable as a query parameter

                    parcelableUri = builder.build();
                    Log.d("pURI:", parcelableUri.toString());
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
            updateUI();
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
//                    this.buildUriList = Uri.parse(string2);
//                    this.arr.add(buildUriList);
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
            updateUI();
        }
    }
    public final void loadFiles() {
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(\"external\")");
        Cursor query = getContentResolver().query(contentUri, new String[]{"_id", "_display_name", "_data", "_size"}, "media_type=0", (String[]) null, (String) null);
        try {
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("_size"));
                    if (!(string == null || string2 == null || string3 == null)) {
                        if (endsWith$default(string, ".pdf", false, 2, (Object) null) || endsWith$default(string, ".txt", false, 2, (Object) null) || endsWith$default(string, ".docx", false, 2, (Object) null) || endsWith$default(string, ".xlsx", false, 2, (Object) null)) {
                            this.mOtherFilesList.add(new FileModel(string, string2, "Apps", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null));
    //                        this.buildUriList = Uri.parse(string2);
    //                        this.arr.add(buildUriList);
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
                updateUI();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
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

                    FileModel r8 = null;
                    FileModel fileModel = r8;
                    FileModel fileModel2 = new FileModel(obj, path, "Apps", (ApplicationInfo) null, false, 24, (DefaultConstructorMarker) null);
                    arrayList.add(fileModel2);
                    //this.buildUriList = mAppsList;
//                    this.buildUriList = Uri.parse(str);
//                    this.arr.add(buildUriList);
                    if (length > 0) {
                        this.mAppsSize += length;
                        this.allDataSize += length;
                        updateUI();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public final void updateUI() {

        binding.tvImagesSize.setText(this.mPicturesList.size() + " | " + MUtils.INSTANCE.size(this.mImagesSize));

        binding.tvVideosSize.setText(this.mVideosList.size() + " | " + MUtils.INSTANCE.size(this.mVideosSize));

        binding.tvMusicSize.setText(this.mMusicList.size() + " | " + MUtils.INSTANCE.size(this.mMusicsSize));

        binding.tvFilesSize.setText(this.mOtherFilesList.size() + " | " + MUtils.INSTANCE.size(this.mFilesSize));

        binding.tvAppsSize.setText(this.mAppsList.size() + " | " + MUtils.INSTANCE.size(this.mAppsSize));

        binding.tvTotalSize.setText("Selected\n" + MUtils.INSTANCE.size(this.allDataSize));


        binding.tvContactsSize.setText(this.mContactList.size() + " contacts");
    }

    private class ParcelableArrayList<T> {
        public ParcelableArrayList(ArrayList<FileModel> mPicturesList) {

        }
    }
}