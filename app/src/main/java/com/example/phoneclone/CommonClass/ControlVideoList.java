package com.example.phoneclone.CommonClass;

import com.example.phoneclone.Paths;

import java.util.ArrayList;
import java.util.List;

public class ControlVideoList {
    static List<VideosFiles> videosFilesList = new ArrayList();

    public static void setVideosFilesListitem(VideosFiles videosFiles) {
        videosFilesList.add(videosFiles);
    }

    public static List<VideosFiles> getVideoslist() {
        return videosFilesList;
    }

    public static void setAllFilesChecked() {
        for (VideosFiles videosFiles : videosFilesList) {
            videosFiles.setcheckedAll();
        }
    }

    public static void setAllFilesUnchecked() {
        for (VideosFiles videosFiles : videosFilesList) {
            videosFiles.setuncheckedall();
        }
    }

    public static int get_total_Videos() {
        int i = 0;
        for (VideosFiles listofpaths : videosFilesList) {
            i += listofpaths.getListofpaths().size();
        }
        return i;
    }

    public static int get_total_videos_selected() {
        int i = 0;
        for (VideosFiles videosFiles : videosFilesList) {
            i += videosFiles.get_total_count();
        }
        return i;
    }

    public static List<Paths> get_video_data() {
        ArrayList arrayList = new ArrayList();
        for (VideosFiles listofpaths : videosFilesList) {
            for (Paths next : listofpaths.getListofpaths()) {
                if (next.isCheck_value()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
