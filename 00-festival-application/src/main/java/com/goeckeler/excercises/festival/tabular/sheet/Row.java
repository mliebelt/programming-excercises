package com.goeckeler.excercises.festival.tabular.sheet;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Row {
    final private List<String> cells = new ArrayList<>();

    public void addCell(String text) {
        cells.add(text);
    }

    public String getCell(int index) {
        if (index < 0 || index >= cells.size()) return null;
        return cells.get(index);
    }

    @Override
    public String toString() {
        return "(" + StringUtils.join(cells, ", ") + ")";
    }
}
