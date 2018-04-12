package com.goeckeler.excercises.festival;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.goeckeler.excercises.festival.database.factory.DataFactory;
import com.goeckeler.excercises.festival.database.model.BandData;
import com.goeckeler.excercises.festival.database.model.GigData;
import com.goeckeler.excercises.festival.tabular.reader.excel.ExcelReader;
import com.goeckeler.excercises.festival.tabular.sheet.Table;

public class Application
{
  public static void main(final String[] args) {
    System.out.println("Revival Festival");

    final ExcelReader reader = new ExcelReader("Festival.xlsx");
    try {
      System.out.println("-----------------------------------------------------------");
      System.out.println("BANDS");
      System.out.println("-----------------------------------------------------------");

      final Table bandSheet = reader.read("bands");
      // System.out.println(bandSheet);

      final List<BandData> bandData = DataFactory.createBandData(bandSheet);
      System.out.println(StringUtils.join(bandData, "\n"));

      System.out.println("-----------------------------------------------------------");
      System.out.println("PLAYLIST");
      System.out.println("-----------------------------------------------------------");
      final List<GigData> gigs = DataFactory.createGigData(reader.read("playlist"));
      System.out.println(gigs);
    } catch (final FileNotFoundException ex) {
      System.err.println("Cannot find festival file.");
    }
  }
}
