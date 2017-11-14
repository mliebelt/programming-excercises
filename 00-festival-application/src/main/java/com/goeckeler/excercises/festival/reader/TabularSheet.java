package com.goeckeler.excercises.festival.reader;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TabularSheet {
   private List<TabularRow> rows = new ArrayList<>(1031);

   public void addRow(final TabularRow row) {
       rows.add(row);
   }

    @Override
    public String toString() {
       return "[" + StringUtils.join(rows, ", ") + "]";
    }
}
