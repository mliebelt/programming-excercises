package com.goeckeler.excercises.festival;

import java.io.FileNotFoundException;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.goeckeler.excercises.festival.database.factory.DataFactory;
import com.goeckeler.excercises.festival.database.model.BandData;
import com.goeckeler.excercises.festival.database.model.GigData;
import com.goeckeler.excercises.festival.domain.Act;
import com.goeckeler.excercises.festival.tabular.reader.excel.ExcelReader;
import com.goeckeler.excercises.festival.tabular.sheet.Table;

public class Application
{
  private List<BandData> bandData;
  private List<GigData> gigData;

  public static void main(final String[] args) {
    final Application self = new Application();
    self.importExcel();
    final SortedSet<Act> acts = self.load();

    System.out.println(StringUtils.join(acts, "\n"));
  }

  private SortedSet<Act> load() {
    final TreeSet<Act> acts = new TreeSet<>();

    for (final GigData gig : gigData) {
      acts.add(new Act(gig.getAct()));
    }
    return acts;
  }

  private void importExcel() {
    final ExcelReader reader = new ExcelReader("Festival.xlsx");
    try {
      // System.out.println("-----------------------------------------------------------");
      // System.out.println("BANDS");
      // System.out.println("-----------------------------------------------------------");

      final Table bandSheet = reader.read("bands");
      // System.out.println(bandSheet);
      bandData = DataFactory.createBandData(bandSheet);
      // System.out.println(StringUtils.join(bandData, "\n"));

      // System.out.println("-----------------------------------------------------------");
      // System.out.println("PLAYLIST");
      // System.out.println("-----------------------------------------------------------");
      gigData = DataFactory.createGigData(reader.read("playlist"));
      // System.out.println(gigs);
    } catch (final FileNotFoundException ex) {
      System.err.println("Cannot find festival file.");
    }
  }
}
