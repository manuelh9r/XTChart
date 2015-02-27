/**
 * Copyright 2011 - 2014 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.curiousdev.xtchart.standalone;

import com.curiousdev.xtchart.CSVExporter;
import com.curiousdev.xtchart.CSVImporter;
import com.curiousdev.xtchart.Chart;
import com.curiousdev.xtchart.SwingWrapper;

/**
 * @author timmolter
 */
public class CSVChartColumns {

  public static void main(String[] args) throws Exception {

    // import chart from a folder containing CSV files
    Chart chart = CSVImporter.getChartFromCSVDir("./CSV/CSVChartColumns/", CSVImporter.DataOrientation.Columns, 600, 600);

    CSVExporter.writeCSVColumns(chart.getSeriesMap().get("series1"), "./CSV/CSVChartColumnsExport/");

    // Show it
    new SwingWrapper(chart).displayChart();

  }
}