package com.goeckeler.excercises.festival.model.technical;

import com.goeckeler.excercises.festival.model.data.TabularRow;
import com.goeckeler.excercises.festival.model.data.TabularSheet;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    /*
    public static <T> List<T> create(Class<T> clazz, TabularSheet sheet) {

    }
    */

    public static List<BandData> createBandData(TabularSheet sheet) {
        final int NAME_INDEX = 0;
        final int ARTISTS_INDEX = 1;

        List<BandData> dataList = new ArrayList<>();
        for (TabularRow row : sheet) {
            // convert row to band data
            String name = row.getCell(NAME_INDEX);
            String artists = row.getCell(ARTISTS_INDEX);
            dataList.add(new BandData(name, artists));
        }
        // get rid of table header
        dataList.remove(0);
        return dataList;
    }
}
