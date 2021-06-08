package com.pruebasofka.mystore.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public class CsvUtilities {

  private static final String RESOURCES_DATA_PATH_CSV = "/data/";
  private static final String DATA_NAME_PREFIX_CSV = "data_";
  private static final String DATA_NAME_EXTENSION_CSV = ".csv";
  private static final String FILTER_COLUMN_NAME = "filterId";
  private static final char VALUE_SEPARATOR_CSV = ';';

  private CsvUtilities() {}

  public static List<Map<String, String>> getDataTest(String csvName, String filter)
      throws IOException {
    TestDataSource csvSourceData =
        new CSVTestDataSource(
            RESOURCES_DATA_PATH_CSV + DATA_NAME_PREFIX_CSV + csvName + DATA_NAME_EXTENSION_CSV,
            VALUE_SEPARATOR_CSV);
    return getFilteredData(csvSourceData, filter);
  }

  private static List<Map<String, String>> getFilteredData(
      TestDataSource csvData, String filterListString) {
    List<Map<String, String>> csvTotalDataList = csvData.getData();
    if ("".equals(filterListString)) {
      return csvTotalDataList;
    }
    String[] filterListArray = filterListString.split(",");
    return filterData(filterListArray, csvTotalDataList);
  }

  private static List<Map<String, String>> filterData(
      String[] filterListArray, List<Map<String, String>> totalDataList) {
    return totalDataList
        .stream()
        .filter(row -> inArray(filterListArray, row.get(FILTER_COLUMN_NAME)))
        .collect(Collectors.toList());
  }

  public static boolean inArray(String[] arr, String item) {
    if (arr.length > 0) {
      for (String n : arr) {
        if (item.trim().equals(n.trim())) {
          return true;
        }
      }
    }
    return false;
  }
}
