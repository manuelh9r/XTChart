/**
 * Copyright 2013 Xeiam LLC.
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
package com.xeiam.xchart.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author timmolter
 */
public class Histogram {

  private final List<Double> xAxisData; // bin centers
  private final List<Double> yAxisData; // frequency counts
  private final Collection<? extends Number> originalData;
  private final int numBins;
  private final double min;
  private final double max;

  /**
   * Constructor
   */
  public Histogram(Collection<? extends Number> data, int numBins, double min, double max) {

    this.numBins = numBins;
    this.originalData = data;
    // Arrays.sort(data);
    this.min = min;
    this.max = max;
    // this.min = data[0];
    // this.max = data[data.length - 1];

    double[] tempYAxisData = new double[numBins];
    final double binSize = (max - min) / numBins;

    // y axis data
    Iterator<? extends Number> itr = data.iterator();
    while (itr.hasNext()) {

      int bin = (int) (((Double) itr.next() - min) / binSize); // changed this from numBins
      if (bin < 0) { /* this data is smaller than min */
      }
      else if (bin >= numBins) { /* this data point is bigger than max */
      }
      else {
        tempYAxisData[bin] += 1;
      }
    }
    yAxisData = new ArrayList<Double>(numBins);
    for (double d : tempYAxisData) {
      yAxisData.add(new Double(d));
    }

    // x axis data
    xAxisData = new ArrayList<Double>(numBins);
    for (int i = 0; i < numBins; i++) {
      xAxisData.add(((i * (max - min)) / numBins + min) + binSize / 2);
    }
  }

  public List<Double> getxAxisData() {

    return xAxisData;
  }

  public List<Double> getyAxisData() {

    return yAxisData;
  }

  public Collection<? extends Number> getOriginalData() {

    return originalData;
  }

  public int getNumBins() {

    return numBins;
  }

  public double getMin() {

    return min;
  }

  public double getMax() {

    return max;
  }

}
