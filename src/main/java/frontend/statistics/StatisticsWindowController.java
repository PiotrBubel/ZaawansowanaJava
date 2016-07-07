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
    
    public void getSortedStatistics(int row, int colums) {
        //statisticsList = DatabaseUtils.getcostam(row,colums);
        if(!statisticsList.isEmpty()) {
            Collections.sort(statisticsList, new GameSummaryComparator());
        } else {
            //log about no results
        }
        
    }
    
    
    
    
}
