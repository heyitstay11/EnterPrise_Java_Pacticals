/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Singleton;

/**
 *
 * @author hp
 */
@Singleton
public class Hits {
    int hits = 0;
    
    public int getHits(){
        return hits++;
    }
}
