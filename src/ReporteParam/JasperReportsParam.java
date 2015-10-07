/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteParam;

import java.sql.Connection;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Belen-Cortez
 */
public abstract class JasperReportsParam {
    
    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;
    
    public static void createReport (Connection conn, String path){
        try{
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportFilled = JasperFillManager.fillReport(report, null , conn);
            
        }catch( JRException ex ){
            ex.printStackTrace();
        }
    }
    
    public static void showViewer (){
        
        viewer = new JasperViewer ( reportFilled );
        viewer.setVisible(true);
        
    }
    
    
}
