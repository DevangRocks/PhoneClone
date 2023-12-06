package com.example.phoneclone.CommonClass;

import com.example.phoneclone.Paths;

import java.util.ArrayList;
import java.util.List;

public class ControlAudioList {
    static List<AudioFiles> audioFilesList = new ArrayList();

    public static void setAudioFilesList(AudioFiles audioFiles) {
        audioFilesList.add(audioFiles);
    }

    public static List<AudioFiles> getAudioslist() {
        return audioFilesList;
    }

    public static void setAllFilesChecked() {
        for (AudioFiles audioFiles : audioFilesList) {
            audioFiles.setcheckedAll();
        }
    }

    public static void setAllFilesUnchecked() {
        for (AudioFiles audioFiles : audioFilesList) {
            audioFiles.setuncheckedall();
        }
    }

    public static int get_total_Audios() {
        int i = 0;
        for (AudioFiles listofpaths : audioFilesList) {
            i += listofpaths.getListofpaths().size();
        }
        return i;
    }

    public static int get_total_Audios_selected() {
        int i = 0;
        for (AudioFiles audioFiles : audioFilesList) {
            i += audioFiles.get_total_count();
        }
        return i;
    }

    public static List<Paths> get_audio_data() {
        ArrayList arrayList = new ArrayList();
        for (AudioFiles listofpaths : audioFilesList) {
            for (Paths next : listofpaths.getListofpaths()) {
                if (next.isCheck_value()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
