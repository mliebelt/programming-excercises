package com.goeckeler.excercises.festival.tabular.sheet;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table
  implements
  Iterable<Row>
{
  private List<Row> rows = new ArrayList<>(1031);

  public void addRow(final Row row) {
    rows.add(row);
  }

  @Override
  public String toString() {
    return "[" + StringUtils.join(rows, ", ") + "]";
  }

  @Override
  public Iterator<Row> iterator() {
    return rows.listIterator();
  }
}
