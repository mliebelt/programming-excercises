package com.goeckeler.excercises.festival;

import com.goeckeler.excercises.festival.database.model.BandData;
import com.goeckeler.excercises.festival.database.factory.DataFactory;
import com.goeckeler.excercises.festival.tabular.reader.excel.ExcelReader;
import com.goeckeler.excercises.festival.tabular.sheet.Table;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class Application
{
  public static void main(String[] args) {
    System.out.println("Revival Festival");

    ExcelReader reader = new ExcelReader("Festival.xlsx");
    try {
      System.out.println("-----------------------------------------------------------");
      System.out.println("BANDS");
      System.out.println("-----------------------------------------------------------");

      Table bandSheet = reader.read("bands");
      // System.out.println(bandSheet);

      List<BandData> bandData = DataFactory.createBandData(bandSheet);
      System.out.println(StringUtils.join(bandData, "\n"));

      System.out.println("-----------------------------------------------------------");
      System.out.println("PLAYLIST");
      System.out.println("-----------------------------------------------------------");
      Table playlistSheet = reader.read("playlist");
      System.out.println(playlistSheet);
    } catch (FileNotFoundException ex) {
      System.err.println("Cannot find festival file.");
    }
  }
}
