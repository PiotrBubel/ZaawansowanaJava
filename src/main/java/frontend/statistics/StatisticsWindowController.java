/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.statistics;

import database.DatabaseUtils;
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
     *
     * @param rows - number of rows for which statistic should be found
     * @param colums - number of colums for which statistic should be found
     */
    public boolean getSortedStatistics(int rows, int colums) {
        if (DatabaseUtils.getConn() != null) {
            statisticsList = DatabaseUtils.getStatistics(rows, colums);
        } else {
            return false;
        }
        if (!statisticsList.isEmpty()) {
            Collections.sort(statisticsList, new GameSummaryComparator());
        } else {
            System.out.println("There are no statistics for given row and column numbers");
        }
        return true;
    }

    public String[] getRowsTable() {
        if (DatabaseUtils.getConn() != null) {
            return DatabaseUtils.getRows();
        } else {
            return new String[]{"3", "4", "5", "6", "7", "8", "9"};
        }
    }

    public String[] getColumnsTable() {
        if (DatabaseUtils.getConn() != null) {
            return DatabaseUtils.getColumns();
        } else {
            return new String[]{"3", "4", "5", "6", "7", "8", "9"};
        }
    }

}
