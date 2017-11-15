package com.goeckeler.excercises.festival.database.factory;

import com.goeckeler.excercises.festival.database.model.BandData;
import com.goeckeler.excercises.festival.tabular.sheet.Table;
import com.goeckeler.excercises.festival.tabular.sheet.Row;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    /*
    public static <T> List<T> create(Class<T> clazz, Table sheet) {

    }
    */

    public static List<BandData> createBandData(Table sheet) {
        final int NAME_INDEX = 0;
        final int ARTISTS_INDEX = 1;

        List<BandData> dataList = new ArrayList<>();
        for (Row row : sheet) {
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
