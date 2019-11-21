/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgo3;

/**
 *
 * @author CR
 */
public class resourcees {

    public int id, qua;
    public String name, type, capa, admin;
    
    public resourcees(String na, String ti, String capa, String admi, int id, int quaa){
        this.name=na;
        this.type=ti;
        this.capa=capa;
        this.admin=admi;
        this.id=id;
        this.qua=quaa;
    }
}
