/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.statistics;

import frontend.GameSummary;
import frontend.GameSummaryComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lalu
 */
public class StatisticsWindowController {
    
    private List<GameSummary> statisticsList = new ArrayList<>();

    public List<GameSummary> getStatisticsList() {
        return statisticsList;
    }
    
    /**
     * get list of GameSummary objects and sort it by time
     * @param row - number of rows for which statistic should be found
     * @param colums - number of colums for which statistic should be found
     */
    public void getSortedStatistics(int row, int colums) {
        //statisticsList = DatabaseUtils.getcostam(row,colums);
        if(!statisticsList.isEmpty()) {
            Collections.sort(statisticsList, new GameSummaryComparator());
        } else {
            //log about no results
        }
        
    }
    
    
    
    
}
