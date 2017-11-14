package com.goeckeler.excercises.festival;

import com.goeckeler.excercises.festival.model.technical.BandData;
import com.goeckeler.excercises.festival.model.technical.DataFactory;
import com.goeckeler.excercises.festival.reader.ExcelReader;
import com.goeckeler.excercises.festival.model.data.TabularSheet;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Revival Festival");

        ExcelReader reader = new ExcelReader("Festival.xlsx");
        try {
            System.out.println("-----------------------------------------------------------");
            System.out.println("BANDS");
            System.out.println("-----------------------------------------------------------");

            TabularSheet bandSheet = reader.read( "bands");
            // System.out.println(bandSheet);

            List<BandData> bandData = DataFactory.createBandData(bandSheet);
            System.out.println(StringUtils.join(bandData, "\n"));

            System.out.println("-----------------------------------------------------------");
            System.out.println("PLAYLIST");
            System.out.println("-----------------------------------------------------------");
            TabularSheet playlistSheet = reader.read( "playlist");
            System.out.println(playlistSheet);
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot find festival file.");
        }
    }
}
