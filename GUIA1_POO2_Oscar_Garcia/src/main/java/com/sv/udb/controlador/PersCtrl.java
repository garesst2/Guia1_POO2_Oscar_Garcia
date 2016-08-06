/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Pers;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class PersCtrl {
    
    public List<Pers> consTodo()
    {
        List<Pers> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT CODI_PERS,NOMB_PERS, APEL_PERS FROM Pers";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                Pers modelo = new Pers() ;
                modelo.setCodiPers(rs.getLong(1));
                modelo.setNombPers(rs.getString(2));
                modelo.setApelPers(rs.getString(3));
                resp.add(modelo);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }     
        return resp;
    }
    
}
