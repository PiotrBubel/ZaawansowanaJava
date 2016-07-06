/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.util.Comparator;

/**
 *
 * @author Lalu
 */
public class GameSummaryComparator implements Comparator<GameSummary>  {

    @Override
    public int compare(GameSummary o1, GameSummary o2) {
        if (o1.getTime() < o2.getTime()) return -1;
        if (o1.getTime() > o2.getTime()) return 1;
        return 0;
    }
    
}
