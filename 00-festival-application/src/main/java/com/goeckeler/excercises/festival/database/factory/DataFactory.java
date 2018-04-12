package com.goeckeler.excercises.festival.database.factory;

import java.util.ArrayList;
import java.util.List;

import com.goeckeler.excercises.festival.database.model.BandData;
import com.goeckeler.excercises.festival.database.model.GigData;
import com.goeckeler.excercises.festival.tabular.sheet.Row;
import com.goeckeler.excercises.festival.tabular.sheet.Table;

public class DataFactory
{
  /*
   * public static <T> List<T> create(Class<T> clazz, Table sheet) {
   * }
   */

  public static List<BandData> createBandData(final Table sheet) {
    final int NAME_INDEX = 0;
    final int ARTISTS_INDEX = 1;

    final List<BandData> dataList = new ArrayList<>();
    for (final Row row : sheet) {
      // convert row to band data
      final String name = row.getCell(NAME_INDEX);
      final String artists = row.getCell(ARTISTS_INDEX);
      dataList.add(new BandData(name, artists));
    }
    // get rid of table header
    dataList.remove(0);
    return dataList;
  }

  public static List<GigData> createGigData(final Table sheet) {
    final int ORDER_INDEX = 0;
    final int SONG_INDEX = 1;
    final int ACT_INDEX = 2;

    final List<GigData> dataList = new ArrayList<>();
    for (final Row row : sheet) {
      // convert row to gig data
      final String order = row.getCell(ORDER_INDEX);
      final String song = row.getCell(SONG_INDEX);
      final String act = row.getCell(ACT_INDEX);
      dataList.add(new GigData(order, song, act));
    }
    // get rid of table header
    dataList.remove(0);
    return dataList;
  }
}
