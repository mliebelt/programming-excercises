package com.goeckeler.excercises.festival.reader;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TabularRow {
    final private List<String> cells = new ArrayList<>();

    public void addCell(String text) {
        cells.add(text);
    }

    @Override
    public String toString() {
        return "(" + StringUtils.join(cells, ", ") + ")";
    }
}
