package com.example.phoneclone.CommonClass;

import com.example.phoneclone.Paths;

import java.util.ArrayList;
import java.util.List;

public class ControlImageList {
    static List<ImageFiles> imageFilesList = new ArrayList();

    public static void setimageFilesList(ImageFiles imageFiles) {
        imageFilesList.add(imageFiles);
    }

    public static List<ImageFiles> getImageslist() {
        return imageFilesList;
    }

    public static void setAllFilesChecked() {
        for (ImageFiles imageFiles : imageFilesList) {
            imageFiles.setcheckedAll();
        }
    }

    public static void setAllFilesUnchecked() {
        for (ImageFiles imageFiles : imageFilesList) {
            imageFiles.setuncheckedall();
        }
    }

    public static int get_total_Images() {
        int i = 0;
        for (ImageFiles listofpaths : imageFilesList) {
            i += listofpaths.getListofpaths().size();
        }
        return i;
    }

    public static int get_total_Images_selected() {
        int i = 0;
        for (ImageFiles imageFiles : imageFilesList) {
            i += imageFiles.get_total_count();
        }
        return i;
    }

    public static List<Paths> get_Image_data() {
        ArrayList arrayList = new ArrayList();
        for (ImageFiles listofpaths : imageFilesList) {
            for (Paths next : listofpaths.getListofpaths()) {
                if (next.isCheck_value()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
